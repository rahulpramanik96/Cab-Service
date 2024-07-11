package com.lloyds.cab.Cab.Service.Impl;

import ch.hsr.geohash.GeoHash;
import com.lloyds.cab.Cab.DAO.AddressRepository;
import com.lloyds.cab.Cab.DAO.CabRepository;
import com.lloyds.cab.Cab.Models.Address;
import com.lloyds.cab.Cab.Models.Cab;
import com.lloyds.cab.Cab.Service.AddressToGeoHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AddressToGeoHashServiceImpl implements AddressToGeoHashService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CabRepository cabRepository;

    @Override
    public Address latLngConvert(Address address) {

        GeoHash hash = GeoHash.withCharacterPrecision(address.getLat(), address.getLng(), 12);
        address.setHash(hash.toBase32());
        return addressRepository.save(address);

    }

    @Override
    public Map<Integer, List<Address>> getStatus() {
        List<Address> cabRequests = addressRepository.findAll();

// Sorting the list of addresses by the 'hash' field using a lambda expression
        cabRequests.sort(Comparator.comparing(Address::getHash));

// Grouping the sorted list into sublists of 4 elements each based on the first 6 characters of 'hash'
        List<List<Address>> partitioned = new ArrayList<>();
        List<Address> temp = new ArrayList<>();
        String currentPrefix = null;

        for (Address address : cabRequests) {
            String prefix = address.getHash().substring(0, 6);

            if (!prefix.equals(currentPrefix)) {
                if (!temp.isEmpty()) {
                    partitioned.add(new ArrayList<>(temp)); // Add a copy to partitioned list
                    temp.clear();
                }
                currentPrefix = prefix;
            }

            temp.add(address);

            // If temp has reached size of 4, add it to partitioned list and reset temp
            if (temp.size() == 4) {
                partitioned.add(new ArrayList<>(temp)); // Add a copy to partitioned list
                temp.clear();
                currentPrefix = null; // Reset currentPrefix to start a new group
            }
        }

// Add any remaining elements in temp to partitioned list
        if (!temp.isEmpty()) {
            partitioned.add(new ArrayList<>(temp));
        }

// Converting the partitioned sublists into a Map with an index as the key
        Map<Integer, List<Address>> groupedByIndex = IntStream.range(0, partitioned.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, partitioned::get));

        System.out.println(groupedByIndex);

        return groupedByIndex;

    }

    @Override
    public Cab resisterCab(Cab cab) {
        return cabRepository.save(cab);
    }
}

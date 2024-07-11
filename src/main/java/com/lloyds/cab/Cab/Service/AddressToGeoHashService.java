package com.lloyds.cab.Cab.Service;

import com.lloyds.cab.Cab.Models.Address;
import com.lloyds.cab.Cab.Models.Cab;
import com.lloyds.cab.Cab.Models.CabBookingRequestDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AddressToGeoHashService {

    public Address latLngConvert(Address address);
    public Map<Integer, List<CabBookingRequestDetails>> getStatus();
    public Cab resisterCab(Cab cab);
}

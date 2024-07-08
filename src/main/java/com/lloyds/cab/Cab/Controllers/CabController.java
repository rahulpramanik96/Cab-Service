package com.lloyds.cab.Cab.Controllers;

import com.lloyds.cab.Cab.Models.Address;
import com.lloyds.cab.Cab.Service.AddressToGeoHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="http://localhost:5173")
@RestController
public class CabController {

    @Autowired
    AddressToGeoHashService addressToGeoHashService;

    @PostMapping("/sendLocation")
    public ResponseEntity<Address> postAddress(@RequestBody Address address) {
        Address res = addressToGeoHashService.latLngConvert(address);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getStatus")
    public ResponseEntity<Map<Integer, List<Address>>> getStatus() {

        return new ResponseEntity<>(addressToGeoHashService.getStatus(),HttpStatusCode.valueOf(200));

    }


}

package com.example.motoinventoryservice.controller;

import com.example.motoinventoryservice.controller.feign.VinLookupFeignClient;
import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;
import com.example.motoinventoryservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class MotoInventoryController {

    @Autowired
    MotoInventoryDao motoDao;

    @Autowired
    VinLookupFeignClient feignClient;

    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {

        motorcycle = motoDao.addMotorcycle(motorcycle);

        return motorcycle;
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int motoId) {
        if (motoId < 1) {
           throw new IllegalArgumentException("MotoId must be greater than 0.");
        }

        return motoDao.getMotorcycle(motoId);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(@PathVariable("motoId") int motoId) {
        // do nothing here - in a real application we would delete the entry from
        // the backing data store.

        motoDao.deleteMotorcycle(motoId);
    }

    @RequestMapping(value = "/motorcycles/{motoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMotorcycle(@RequestBody @Valid Motorcycle motorcycle, @PathVariable int motoId) {
        // make sure the motoId on the path matches the id of the motorcycle object
        if (motoId != motorcycle.getId()) {
            throw new IllegalArgumentException("Motorcycle ID on path must match the ID in the Motorcycle object.");
        }

        // do nothing here - in a real application we would update the entry in the backing data store
        motoDao.updateMotorcycle(motorcycle);
    }

    @GetMapping(value = "/vehicle/{vin}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getMotorcycleByVin(@PathVariable @Valid @Size(min = 5, max = 5) String vin) {
        Vehicle vehicle = feignClient.getVehicleByVin(vin);

        Map<String, String> vehicleInfo = new HashMap<>();
        vehicleInfo.put("Vehicle Type", vehicle.getType());
        vehicleInfo.put("Vehicle Make", vehicle.getMake());
        vehicleInfo.put("Vehicle Model", vehicle.getModel());
        vehicleInfo.put("Vehicle Year", vehicle.getYear());
        vehicleInfo.put("Vehicle Color", vehicle.getColor());

        return vehicleInfo;
    }
}

package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;

public interface VehicleDao {

    Vehicle getVehicleByVin(String vin);

    void deleteAll();

}

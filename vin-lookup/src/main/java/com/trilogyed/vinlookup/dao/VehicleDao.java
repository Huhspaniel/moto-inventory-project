package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;

public interface VehicleDao {

    public Vehicle getVehicleByVin(String vin);

}

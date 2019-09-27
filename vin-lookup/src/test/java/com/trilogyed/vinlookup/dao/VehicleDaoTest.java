package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VehicleDaoTest {

    @Autowired
    private VehicleDao vehicleDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        vehicleDao.deleteAll();
    }

    @Test
    public void getVehicleByVin() {

        Vehicle vehicle = new Vehicle();
        vehicle.setType("motorcycle");
        vehicle.setMake("honda");
        vehicle.setModel("X1NX");
        vehicle.setYear("2019");
        vehicle.setColor("black");
    }
}
package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class VehicleDaoJdbcTemplateImpl implements VehicleDao {

    //Prepared Statements
    private static final String SELECT_VEHICLE_BY_VIN_SQL =
            "select * from motorcycle where vin = ?";

    private static final String DELETE_ALL_SQL =
            "delete from motorcycle";



    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VehicleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Vehicle getVehicleByVin(String vin) {
        return jdbcTemplate.queryForObject(SELECT_VEHICLE_BY_VIN_SQL, this::mapRowToVehicle, vin);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update(DELETE_ALL_SQL);
    }

    //RowMapper
    private Vehicle mapRowToVehicle(ResultSet rs, int rowNum) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("Motorcycle");
        vehicle.setMake(rs.getString("make"));
        vehicle.setModel(rs.getString("model"));
        vehicle.setYear(rs.getString("year"));
        vehicle.setColor(rs.getString("color"));

        return vehicle;
    }

}

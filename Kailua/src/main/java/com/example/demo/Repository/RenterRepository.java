package com.example.demo.Repository;

import com.example.demo.Model.Renter;
import com.example.demo.Model.Zip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RenterRepository {

    @Autowired
    JdbcTemplate template;

    public List<Renter> fetchAll (){
        String sql = "SELECT * FROM renters";

        RowMapper <Renter> rm = new BeanPropertyRowMapper<>(Renter.class);
        return template.query(sql, rm);
    }

    public Renter findRenterByID(int ID){
        String sql = "SELECT * FROM renters WHERE renterID = ?";
        RowMapper<Renter> rm = new BeanPropertyRowMapper<>(Renter.class);
        return template.queryForObject(sql, rm, ID);
    }

    public Renter addRenter(Renter newRenter){
        String sql = "INSERT INTO renters (firstname, lastname, mobile, phone, email, street, zip, licenseNumber, driverSinceDate) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, newRenter.getFirstname(), newRenter.getLastname(), newRenter.getMobile(), newRenter.getPhone(), newRenter.getEmail(),
                        newRenter.getStreet(), newRenter.getZip(), newRenter.getLicenseNumber(), newRenter.getDriverSinceDate());
        return null;
    }

    public Boolean deleteRenter(int ID){
        String sql = "DELETE FROM renters WHERE renterID = ?";
        return template.update(sql, ID) < 0;
    }

    public Renter updateRenter(int ID, Renter newRenter){
        String sql = "UPDATE renters SET firstname = ?, lastname = ?, mobile = ?, phone = ?, email = ?, street = ?, zip = ?, " +
                "licenseNumber = ?, driverSinceDate = ? WHERE renterID = ?";
        template.update(sql, newRenter.getFirstname(), newRenter.getLastname(), newRenter.getMobile(), newRenter.getPhone(), newRenter.getEmail(),
                newRenter.getStreet(), newRenter.getZip(), newRenter.getLicenseNumber(), newRenter.getDriverSinceDate(), newRenter.getRenterID());
        return null;
    }


}

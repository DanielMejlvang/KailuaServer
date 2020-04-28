package com.example.demo.Repository;

import com.example.demo.Model.Renter;
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
        return null;
    }

    public Renter addRenter(Renter newRenter){
        return null;
    }

    public Boolean deleteRenter(int ID){
        return null;
    }

    public Renter updateRenter(int ID, Renter renter){
        return null;
    }


}

package com.example.demo.Repository;

import com.example.demo.Model.Zip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ZipRepository {
    @Autowired
    JdbcTemplate template;

    public Boolean doesExist(Zip zip){
        String sql = "SELECT * FROM zips WHERE zip = ?";
        boolean result = false;
        int count = template.queryForObject(sql, new Object[] { zip.getZip() }, Integer.class);
        if(count > 0){
            result = true;
        }
        return result;
    }

    public Zip addZip(Zip zip){
        String sql = "INSERT INTO zips (zip, city, country) VALUES (?, ?, ?)";
        template.update(sql, zip.getZip(), zip.getCity(), zip.getCountry());
        return null;
    }

    public Zip editZip(String zipID, Zip newZip){
        return null;
    }
}

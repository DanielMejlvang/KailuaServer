package com.example.demo.Repository;

import com.example.demo.Model.Zip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZipRepository {
    @Autowired
    JdbcTemplate template;

    public static Zip latestZip;

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
        String sql = "INSERT IGNORE INTO zips (zip, city, country) VALUES (?, ?, ?)";
        template.update(sql, zip.getZip(), zip.getCity(), zip.getCountry());
        latestZip = zip;
        return null;
    }

    public Zip editZip(String zipID, Zip newZip){
        return null;
    }

    public List<Zip> getZipZip(Zip zip) {
        String sql = "SELECT * FROM ZIPS WHERE zip = "+zip.getZip();
        RowMapper<Zip> rm = new BeanPropertyRowMapper<>(Zip.class);

        return template.query(sql, rm);
    }
}

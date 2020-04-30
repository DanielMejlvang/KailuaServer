package com.example.demo.Repository;

import com.example.demo.Model.Zip;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        return null;
    }

    public Zip editZip(String zipID, Zip newZip){
        return null;
    }
}

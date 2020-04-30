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
        return null;
    }

    public Zip addZip(Zip zip){
        return null;
    }

    public Zip editZip(String zipID, Zip newZip){
        return null;
    }
}

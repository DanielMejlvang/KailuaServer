package com.example.demo.Service;

import com.example.demo.Model.Zip;
import com.example.demo.Repository.ZipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipService {
    @Autowired
    ZipRepository zr;

    public Boolean doesExist(Zip zip){
        return zr.doesExist(zip);
    }

    public Zip addZip(Zip zip){
        return zr.addZip(zip);
    }

    public Zip editZip(String zipID, Zip newZip){
        return zr.editZip(zipID, newZip);
    }

}

package com.example.demo.Service;

import com.example.demo.Model.Renter;
import com.example.demo.Repository.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterService {

    @Autowired
    RenterRepository rr;

    public List<Renter> fetchAll (){
        return rr.fetchAll();
    }

    public Renter findRenterByID(int ID){
        return rr.findRenterByID(ID);
    }

    public Renter addRenter(Renter newRenter){
        return rr.addRenter(newRenter);
    }

    public Boolean deleteRenter(int ID){
        return rr.deleteRenter(ID);
    }

    public Renter updateRenter(int ID, Renter renter){
        return rr.updateRenter(ID, renter);
    }

}

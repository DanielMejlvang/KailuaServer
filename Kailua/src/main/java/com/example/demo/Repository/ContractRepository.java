package com.example.demo.Repository;

import com.example.demo.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepository {
    @Autowired
    JdbcTemplate template;

    public List<Contract> fetchAll(){
        String sql = "SELECT * FROM rentalcontracts";
        RowMapper<Contract> rm = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rm);
    }

    public Contract viewContractByID(int ID){
        String sql = "SELECT * FROM rentalcontracts JOIN renters USING (renterID) JOIN cars USING (carID) WHERE contractID = ?";
        RowMapper<Contract> rm = new BeanPropertyRowMapper<>(Contract.class);
        return template.queryForObject(sql, rm, ID);
    }

    public Contract updateContract(){
        return null;
    }

    public Contract addNewContract(){
        return null;
    }

    public Boolean deleteContract(){
        return null;
    }
}

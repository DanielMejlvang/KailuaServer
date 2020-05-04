package com.example.demo.Service;

import com.example.demo.Model.Contract;
import com.example.demo.Repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    ContractRepository cr;

    public List<Contract> fetchAll(){
        return cr.fetchAll();
    }

    public Contract viewContractByID(int ID){
        return cr.viewContractByID(ID);
    }
}

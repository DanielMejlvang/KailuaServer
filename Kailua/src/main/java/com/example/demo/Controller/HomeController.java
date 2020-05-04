package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Contract;
import com.example.demo.Model.Renter;
import com.example.demo.Model.Zip;
import com.example.demo.Repository.ZipRepository;
import com.example.demo.Service.CarService;
import com.example.demo.Service.ContractService;
import com.example.demo.Service.RenterService;
import com.example.demo.Service.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CarService cs;

    @Autowired
    RenterService rs;

    @Autowired
    ZipService zs;

    @Autowired
    ContractService cos;

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/createZip")
    public String createZip() {
        return "home/createZip";
    }

    @PostMapping("/createZip")
    public String createZip(@ModelAttribute Zip zip){

        //if(!zs.doesExist(zip)){
            zs.addZip(zip);
        //}
        return "redirect:/createRenter";
    }

    @GetMapping("/createRenter")
    public String createRenter(Model model){
        //List<Zip> justzip = zs.getZipZip(ZipRepository.latestZip);
        model.addAttribute("chosenZip", ZipRepository.latestZip);
        return "home/createRenter";
    }

    @PostMapping("/createRenter")
    public String createRenter(@ModelAttribute Renter renter){
        rs.addRenter(renter);
        return "redirect:/renter";
    }

    @GetMapping("/deleteRenter/{renterID}")
    public String deleteRenter(@PathVariable("renterID") int ID){

        boolean deletedRenter = rs.deleteRenter(ID);
        if(deletedRenter){
            return "redirect:/renter";
        } else{
            return "redirect:/renter";
        }

    }

    @GetMapping("/updateRenter/{renterID}")
    public String updateRenter(@PathVariable("renterID") int ID, Model model){
        model.addAttribute("renter", rs.findRenterByID(ID));
        return "home/updateRenter";
    }

    @PostMapping("/updateRenter")
    public String updateRenter(@ModelAttribute Renter renter){
        rs.updateRenter(renter.getRenterID(), renter);
        return "redirect:/renter";
    }

    @GetMapping("/renter")
    public String renter(Model model){
        List<Renter> renterList = rs.fetchAll();
        model.addAttribute("renters" , renterList);
        return "home/renter";
    }

    @GetMapping("/car")
    public String car(Model model){
        List<Car> carList = cs.fetchAll();
        model.addAttribute("cars", carList);
        return "home/car";
    }

    @GetMapping("/contract")
    public String contract(Model model){
        List<Contract> contractList = cos.fetchAll();
        model.addAttribute("rentalcontracts", contractList);
        return "home/contract";
    }

    @GetMapping("/viewContract/{contractID}-{carID}-{renterID}")
    public String viewContract(@PathVariable ("contractID") int contractID, @PathVariable ("carID") int carID,
                               @PathVariable ("renterID") int renterID, Model model){
        model.addAttribute("rentalcontracts", cos.viewContractByID(contractID));
        model.addAttribute("cars", cs.findCarByID(carID));
        model.addAttribute("renters", rs.findRenterByID(renterID));
        return "home/viewContract";
    }

    @GetMapping("/deleteCar/{carID}")
    public String deleteCar(@PathVariable("carID") int carID){
        boolean deletedCar = cs.deleteCar(carID);
        if(!deletedCar){
            return "redirect:/car";
        } else{
            return "redirect:/car";
        }
    }
}

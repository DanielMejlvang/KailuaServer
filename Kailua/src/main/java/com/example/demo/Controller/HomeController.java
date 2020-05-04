package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Renter;
import com.example.demo.Model.Zip;
import com.example.demo.Repository.ZipRepository;
import com.example.demo.Service.CarService;
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
        return "redirect:/";
    }

    @GetMapping("/deleteRenter/{renterID}")
    public String deleteRenter(@PathVariable("renterID") int ID){

        boolean deletedRenter = rs.deleteRenter(ID);
        if(deletedRenter){
            return "redirect:/";
        } else{
            return "redirect:/";
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
        return "redirect:/";
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
    public String contract(){
        return "home/contract";
    }
}

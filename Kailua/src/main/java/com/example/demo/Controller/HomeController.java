package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Renter;
import com.example.demo.Model.Zip;
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
    public String index(Model model) {
        List<Car> carList = cs.fetchAll();
        model.addAttribute("cars", carList);

        List<Renter> renterList = rs.fetchAll();
        model.addAttribute("renters" , renterList);

        return "home/index";
    }

    @GetMapping("/createRenter")
    public String createRenter(){
        return "home/createRenter";
    }

    @PostMapping("/createRenter")
    public String createRenter(@ModelAttribute Renter renter, @ModelAttribute Zip zip){
        if(!zs.doesExist(zip)){
            zs.addZip(zip);
        }
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
}

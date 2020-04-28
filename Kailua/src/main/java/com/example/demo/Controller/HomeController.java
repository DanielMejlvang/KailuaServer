package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Renter;
import com.example.demo.Service.CarService;
import com.example.demo.Service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CarService cs;

    @Autowired
    RenterService rs;

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
    public String createRenter(@ModelAttribute Renter renter){
        rs.addRenter(renter);
        return "redirect:/";
    }
}

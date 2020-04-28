package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CarService cs;

    @GetMapping("/")
    public String index(Model model) {
        List<Car> carList = cs.fetchAll();
        model.addAttribute("cars", carList);
        return "home/index";
    }
}

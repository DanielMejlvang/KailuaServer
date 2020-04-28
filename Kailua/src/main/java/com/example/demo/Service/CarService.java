package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository cr;

    public List<Car> fetchAll() {
        return cr.fetchAll();
    }
    public Car addCar(Car car) {
        return cr.addCar(car);
    }
    public Car findCarByID(int id) {
        return cr.findCarByID(id);
    }
    public Boolean deleteCar(int id) {
        return cr.deleteCar(id);
    }
    public Car updateCar(int id, Car car) {
        return cr.updateCar(id, car);
    }
}

package com.example.demo.Repository;

import com.example.demo.Model.Car;
import com.example.demo.Model.Renter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {
    @Autowired
    JdbcTemplate template;

    public List<Car> fetchAll() {
        String sql = "SELECT * FROM cars";
        RowMapper<Car> rm = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql, rm);
    }
    public Car addCar(Car car) {
        return null;
    }
    public Car findCarByID(int ID) {
        String sql = "SELECT * FROM cars WHERE carID = ?";
        RowMapper<Car> rm = new BeanPropertyRowMapper<>(Car.class);
        return template.queryForObject(sql, rm, ID);
    }
    public Boolean deleteCar(int ID) {
        String sql = "DELETE FROM cars WHERE carID = ?";
        return template.update(sql, ID) < 0;
    }
    public Car updateCar(int ID, Car car){
        String sql = "UPDATE cars SET carType = ?, carBrand = ?, carModel = ?, licenseplate = ?, registrationDate = ?, odometer = ? WHERE carID = ?";
        template.update(sql, car.getCarBrand(), car.getCarModel(), car.getLicenseplate(), car.getRegistrationDate(), car.getOdometer(), car.getCarID());
        return null;
    }
}
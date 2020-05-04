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
    public Boolean deleteCar(int id) {
        return null;
    }
    public Car updateCar(int id, Car car){
        return null;
    }
}

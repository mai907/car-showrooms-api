package com.car.showrooms.repository;

import com.car.showrooms.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByShowroom_DeletedFalse();

}

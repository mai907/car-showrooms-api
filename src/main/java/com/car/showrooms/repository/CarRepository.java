package com.car.showrooms.repository;

import com.car.showrooms.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Page<Car> findByShowroom_DeletedFalse(Pageable pageable);

}

package com.car.showrooms.specification;

import com.car.showrooms.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CarSpecificationRepository  extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car>
{

}

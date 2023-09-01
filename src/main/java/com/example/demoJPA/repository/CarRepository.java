package com.example.demoJPA.repository;

import com.example.demoJPA.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}

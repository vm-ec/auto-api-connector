package com.vm.smartvin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.smartvin.entity.CarDetailsEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetailsEntity, Long> {
    public CarDetailsEntity findByVin(String vin);
}

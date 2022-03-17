package com.pms.deatils.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.deatils.entity.PatientEmergencyEntity;

public interface EmergencyContactRepository extends JpaRepository<PatientEmergencyEntity, Integer>{

}

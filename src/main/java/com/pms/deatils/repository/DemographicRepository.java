package com.pms.deatils.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.deatils.entity.PatientDemogrphicEntity;

public interface DemographicRepository extends JpaRepository<PatientDemogrphicEntity, Integer> {

}

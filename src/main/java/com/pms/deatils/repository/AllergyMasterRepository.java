package com.pms.deatils.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.deatils.entity.AllergyMasterEntity;

public interface AllergyMasterRepository extends JpaRepository<AllergyMasterEntity, Integer> {

    List<AllergyMasterEntity> findByAllergyCode(String code);
	
	List<AllergyMasterEntity> findByAllergyName(String name);
	
	List<AllergyMasterEntity> findByAllergyType(String name);
}

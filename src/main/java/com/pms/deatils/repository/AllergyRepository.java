package com.pms.deatils.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pms.deatils.entity.PatientAllergyEntity;

public interface AllergyRepository extends JpaRepository<PatientAllergyEntity, Integer>{

	@Query(value = "select * from patient_allergy where patient_Id=:id",nativeQuery = true)
    Optional<List<PatientAllergyEntity>> getByPatientId(@Param("id")Integer id);
}

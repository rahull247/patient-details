package com.pms.deatils.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pms.deatils.entity.PatientUserEntity;

public interface PatientRepository extends JpaRepository<PatientUserEntity, Integer>{

	@Query(value ="select * from patient_user_master patient "
			+ "Inner JOIN patient_demographic_details demographic On demographic.patient_id=patient.patient_id "
			+ "Inner JOIN emergenency_contact_info emergency On emergency.patient_id=patient.patient_id "
			+ "Inner JOIN patient_allergy allergy On allergy.patient_id=patient.patient_id "
			+ "where patient.patient_id=:id",nativeQuery = true)
	List<PatientUserEntity> findByPatientId(@Param("id")Integer id);
}

package com.pms.deatils.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.deatils.entity.AllergyMasterEntity;
import com.pms.deatils.entity.PatientAllergyEntity;
import com.pms.deatils.entity.PatientAndAllergyEntity;
import com.pms.deatils.entity.PatientUserEntity;
import com.pms.deatils.repository.AllergyRepository;

@Service
public class AllergyService {

	@Autowired
	private AllergyRepository allergyRepository;
	
	
	public List<PatientAllergyEntity> getAllAllergy(){
		return allergyRepository.findAll();
	}
	
	public ResponseEntity<PatientAllergyEntity> getAllergyById(Integer id){
		Optional<PatientAllergyEntity> demographic=allergyRepository.findById(id);
	    if(demographic.isPresent()) {
	    	return ResponseEntity.ok(demographic.get());
	    }
	    
	     throw new RuntimeException();
	}

	public ResponseEntity<List<PatientAllergyEntity>> getAllByPatientId(Integer id) {
		
		Optional<List<PatientAllergyEntity>> allergies=allergyRepository.getByPatientId(id);
		
		if(allergies.isPresent()) {
	    	return ResponseEntity.ok(allergies.get());
	    }
	    
	     throw new RuntimeException("Allergyies is not present of this patient id: "+id);
	}

	public void saveAllergyOfPatient(PatientAndAllergyEntity patientAndAllergyEntity) {
		System.out.println(patientAndAllergyEntity);
		PatientUserEntity patientUserEntity=new PatientUserEntity();
        PatientAllergyEntity patientAllergyEntity=new PatientAllergyEntity();
        
        patientUserEntity.setPatientId(patientAndAllergyEntity.getPatientId());
        
        patientAllergyEntity.setAllergyId(patientAndAllergyEntity.getAllergyId());
        patientAllergyEntity.setAllergyCode(patientAndAllergyEntity.getAllergyCode());
        patientAllergyEntity.setAllergyType(patientAndAllergyEntity.getAllergyType());
        patientAllergyEntity.setAllergyName(patientAndAllergyEntity.getAllergyName());
        patientAllergyEntity.setAllergyDesc(patientAndAllergyEntity.getAllergyDesc());
        patientAllergyEntity.setAllergyClinicInfo(patientAndAllergyEntity.getAllergyClinicInfo());
        patientAllergyEntity.setAllergyFatal(patientAndAllergyEntity.getAllergyFatal());
        patientAllergyEntity.setPatient(patientUserEntity);
        
        allergyRepository.save(patientAllergyEntity);
	}

	public void deleteAllergyById(Integer allergyId) {
		allergyRepository.deleteById(allergyId);
		
	}

	public void updatePatientAllergyById(PatientAndAllergyEntity patientAndAllergyEntity) {
		System.out.println("Updating Patient data: "+patientAndAllergyEntity);
		PatientUserEntity patientUserEntity=new PatientUserEntity();
        PatientAllergyEntity patientAllergyEntity=new PatientAllergyEntity();
        
        patientUserEntity.setPatientId(patientAndAllergyEntity.getPatientId());
        
        patientAllergyEntity.setAllergyId(patientAndAllergyEntity.getAllergyId());
        patientAllergyEntity.setAllergyCode(patientAndAllergyEntity.getAllergyCode());
        patientAllergyEntity.setAllergyType(patientAndAllergyEntity.getAllergyType());
        patientAllergyEntity.setAllergyName(patientAndAllergyEntity.getAllergyName());
        patientAllergyEntity.setAllergyDesc(patientAndAllergyEntity.getAllergyDesc());
        patientAllergyEntity.setAllergyClinicInfo(patientAndAllergyEntity.getAllergyClinicInfo());
        patientAllergyEntity.setAllergyFatal(patientAndAllergyEntity.getAllergyFatal());
        patientAllergyEntity.setPatient(patientUserEntity);
        
        allergyRepository.save(patientAllergyEntity);
		
	}
	
	
	
}

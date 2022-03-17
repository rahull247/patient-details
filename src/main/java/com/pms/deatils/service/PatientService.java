package com.pms.deatils.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.deatils.entity.PatientUserEntity;
import com.pms.deatils.exception.PatientNotFoundException;
import com.pms.deatils.repository.PatientRepository;


@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	
	
	public List<PatientUserEntity> getAllPatients(){
		return patientRepository.findAll();
	}
	
	public ResponseEntity<PatientUserEntity> getPatientById(Integer id){
		Optional<PatientUserEntity> patient=patientRepository.findById(id);
	    if(patient.isPresent()) {
	    	return ResponseEntity.ok(patient.get());
	    }
	    
	     throw new PatientNotFoundException();
	}

	public List<PatientUserEntity> getPatientAllDetails(Integer id) {
		 List<PatientUserEntity> patientDetails=patientRepository.findByPatientId(id);
		 return patientDetails;
	}
	
	
	
}

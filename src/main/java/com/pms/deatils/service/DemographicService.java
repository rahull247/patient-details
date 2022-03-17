package com.pms.deatils.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.deatils.entity.PatientAndDemographicEntity;
import com.pms.deatils.entity.PatientDemogrphicEntity;
import com.pms.deatils.entity.PatientUserEntity;
import com.pms.deatils.exception.PatientNotFoundException;
import com.pms.deatils.repository.DemographicRepository;
import com.pms.deatils.repository.PatientRepository;

@Service
public class DemographicService {

	@Autowired
	private DemographicRepository demographicRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	
	public List<PatientDemogrphicEntity> getAllDemographics(){
		return demographicRepository.findAll();
	}
	
	public ResponseEntity<PatientDemogrphicEntity> getDemographicsById(Integer id){
		Optional<PatientDemogrphicEntity> demographic=demographicRepository.findById(id);
	    if(demographic.isPresent()) {
	    	return ResponseEntity.ok(demographic.get());
	    }
	    
	     throw new RuntimeException();
	}

	public void saveDemographicDetails(PatientAndDemographicEntity patientAndDemographicEntity) {
        PatientUserEntity patientUserEntity=new PatientUserEntity();
        PatientDemogrphicEntity patientDemogrphicEntitys=new  PatientDemogrphicEntity();
        
        patientUserEntity.setPatientId(patientAndDemographicEntity.getPatientUserEntity().getPatientId());
        patientUserEntity.setTitle(patientAndDemographicEntity.getPatientUserEntity().getTitle());
        patientUserEntity.setFirstName(patientAndDemographicEntity.getPatientUserEntity().getFirstName());
        patientUserEntity.setLastName(patientAndDemographicEntity.getPatientUserEntity().getLastName());
        patientUserEntity.setDateOfBirth(patientAndDemographicEntity.getPatientUserEntity().getDateOfBirth());
        patientUserEntity.setEmailId(patientAndDemographicEntity.getPatientUserEntity().getEmailId());
        patientUserEntity.setCountryCode(patientAndDemographicEntity.getPatientUserEntity().getCountryCode());
        patientUserEntity.setPhoneNumber(patientAndDemographicEntity.getPatientUserEntity().getPhoneNumber());
        
        patientRepository.save(patientUserEntity);
        
        patientDemogrphicEntitys.setDemographicId(patientAndDemographicEntity.getPatientDemogrphicEntity().getDemographicId());
        patientDemogrphicEntitys.setGender(patientAndDemographicEntity.getPatientDemogrphicEntity().getGender());
        patientDemogrphicEntitys.setEthnicity(patientAndDemographicEntity.getPatientDemogrphicEntity().getEthnicity());
        patientDemogrphicEntitys.setRace(patientAndDemographicEntity.getPatientDemogrphicEntity().getRace());
        patientDemogrphicEntitys.setLanguages(patientAndDemographicEntity.getPatientDemogrphicEntity().getLanguages());
        patientDemogrphicEntitys.setAddress(patientAndDemographicEntity.getPatientDemogrphicEntity().getAddress());
        patientDemogrphicEntitys.setPatient(patientUserEntity);
        
	    demographicRepository.save(patientDemogrphicEntitys);
	}
}

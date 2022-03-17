package com.pms.deatils.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.deatils.entity.AllergyMasterEntity;
import com.pms.deatils.repository.AllergyMasterRepository;

@Service
public class AllergyMasterService {

	@Autowired
	private AllergyMasterRepository allergyMasterRepository;
	
	
	public List<AllergyMasterEntity> getAllMasterAllergy(){
		return allergyMasterRepository.findAll();
	}
	
	public ResponseEntity<AllergyMasterEntity> getMasterAllergyById(Integer id){
		Optional<AllergyMasterEntity> demographic=allergyMasterRepository.findById(id);
	    if(demographic.isPresent()) {
	    	return ResponseEntity.ok(demographic.get());
	    }
	    
	     throw new RuntimeException();
	}
	
	public List<AllergyMasterEntity> getAllergyByCode(String code){
		List<AllergyMasterEntity> allergy=allergyMasterRepository.findByAllergyCode(code);
		return allergy;
	    
	}
	
	public List<AllergyMasterEntity> getAllergyByName(String name){
		List<AllergyMasterEntity> allergy=allergyMasterRepository.findByAllergyName(name);
	     if(allergy.isEmpty()) {
	    	 throw new RuntimeException("Allergy Not Found");	 
	     }
	    
	    return allergy;
	    
	}
	
	public List<AllergyMasterEntity> getAllergyByType(String name){
		List<AllergyMasterEntity> allergy=allergyMasterRepository.findByAllergyType(name);
	     if(allergy.isEmpty()) {
	    	 throw new RuntimeException("Allergy Not Found");	 
	     }
	    
	    return allergy;
	    
	}
}

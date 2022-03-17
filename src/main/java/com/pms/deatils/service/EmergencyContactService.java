package com.pms.deatils.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.deatils.entity.EmergencyContact;
import com.pms.deatils.entity.PatientEmergencyEntity;
import com.pms.deatils.entity.PatientUserEntity;
import com.pms.deatils.entity.RelationShipEntity;
import com.pms.deatils.repository.EmergencyContactRepository;

@Service
public class EmergencyContactService {

	@Autowired
	private EmergencyContactRepository emergencyContactRepository;
	
	public List<PatientEmergencyEntity> getAllEmergencyContact(){
		return emergencyContactRepository.findAll();
	}
	
	public ResponseEntity<PatientEmergencyEntity> getEmergencyContactById(Integer id){
		Optional<PatientEmergencyEntity> demographic=emergencyContactRepository.findById(id);
	    if(demographic.isPresent()) {
	    	return ResponseEntity.ok(demographic.get());
	    }
	    
	     throw new RuntimeException();
	}

	public void saveEmergencyDetails(EmergencyContact emergencyContact) {
		PatientUserEntity patientUserEntity=new PatientUserEntity();
		PatientEmergencyEntity patientEmergencyEntity=new PatientEmergencyEntity();
		RelationShipEntity relationShipEntity=new RelationShipEntity();
		
		patientUserEntity.setPatientId(emergencyContact.getPatientId());
        relationShipEntity.setId(emergencyContact.getRelationShipEntity().getId());
        relationShipEntity.setRelation(emergencyContact.getRelationShipEntity().getRelation());
        
        patientEmergencyEntity.setEmergencyId(emergencyContact.getEmergencyId());
        patientEmergencyEntity.setEmergencyFirstName(emergencyContact.getEmergencyFirstName());
        patientEmergencyEntity.setEmergencyLastName(emergencyContact.getEmergencyLastName());
        patientEmergencyEntity.setEmergencyEmail(emergencyContact.getEmergencyEmail());
        patientEmergencyEntity.setEmergencyCountryCode(emergencyContact.getEmergencyCountryCode());
        patientEmergencyEntity.setEmergencyContactNo(emergencyContact.getEmergencyContactNo());
        patientEmergencyEntity.setEmergencyAddress(emergencyContact.getEmergencyAddress());
        patientEmergencyEntity.setEmergencyAccessToPortal(emergencyContact.getEmergencyAccessToPortal());
        patientEmergencyEntity.setRelationShipEntity(relationShipEntity);
        patientEmergencyEntity.setPatient(patientUserEntity);
        
        emergencyContactRepository.save(patientEmergencyEntity);
		
	}
}

package com.pms.deatils.entity;

public class PatientAndDemographicEntity {

	private PatientUserEntity patientUserEntity;
	
	private PatientDemogrphicEntity patientDemogrphicEntity;

	public PatientUserEntity getPatientUserEntity() {
		return patientUserEntity;
	}

	public void setPatientUserEntity(PatientUserEntity patientUserEntity) {
		this.patientUserEntity = patientUserEntity;
	}

	public PatientDemogrphicEntity getPatientDemogrphicEntity() {
		return patientDemogrphicEntity;
	}

	public void setPatientDemogrphicEntity(PatientDemogrphicEntity patientDemogrphicEntity) {
		this.patientDemogrphicEntity = patientDemogrphicEntity;
	}

	@Override
	public String toString() {
		return "PatientAndDemographicEntity [patientUserEntity=" + patientUserEntity + ", patientDemogrphicEntity="
				+ patientDemogrphicEntity + "]";
	}
	
	
	
}

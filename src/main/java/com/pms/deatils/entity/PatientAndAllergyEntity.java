package com.pms.deatils.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class PatientAndAllergyEntity {

private Integer allergyId;
 	
	private String allergyCode;

	private String allergyName;

	private String allergyType;

	private String allergyFatal;

	private String allergyDesc;

	private String allergyClinicInfo;
	
    private Integer patientId;

	@Override
	public String toString() {
		return "PatientAndAllergyEntity [allergyId=" + allergyId + ", allergyCode=" + allergyCode + ", allergyName="
				+ allergyName + ", allergyType=" + allergyType + ", allergyFatal=" + allergyFatal + ", allergyDesc="
				+ allergyDesc + ", allergyClinicInfo=" + allergyClinicInfo + ", patientId=" + patientId + "]";
	}
    
    
	
}

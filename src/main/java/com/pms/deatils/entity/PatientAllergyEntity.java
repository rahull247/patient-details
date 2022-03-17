package com.pms.deatils.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PATIENT_ALLERGY")
public class PatientAllergyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allergy_id")
	private Integer allergyId;
 	
	@Column(name = "allergy_code")
	private String allergyCode;

	@Column(name = "allergy_name")
	private String allergyName;

	@Column(name = "allergy_type")
	private String allergyType;

	@Column(name = "allergy_fatal")
	private String allergyFatal;

	@Column(name = "allergy_desc")
	private String allergyDesc;

	@Column(name = "allergy_clinicinfo")
	private String allergyClinicInfo;
	
	@ManyToOne
    @JoinColumn(name="patientId", nullable=false,referencedColumnName="patient_id")
    private PatientUserEntity patient;
	
}

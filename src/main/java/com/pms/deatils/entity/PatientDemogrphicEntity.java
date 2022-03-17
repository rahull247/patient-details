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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="patient_demographic_details")
public class PatientDemogrphicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="demographic_id")
	private Integer demographicId;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="race")
	private String race;
	
	@Column(name="ethnicity")
	private String ethnicity;
	
	@Column(name="languages")
	private String languages;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
    @JoinColumn(name="patientId", nullable=false,referencedColumnName="patient_id")
    private PatientUserEntity patient;

	@Override
	public String toString() {
		return "PatientDemogrphicEntity [demographicId=" + demographicId + ", gender=" + gender + ", race=" + race
				+ ", ethnicity=" + ethnicity + ", languages=" + languages + ", address=" + address + ", patient="
				+ patient + "]";
	}
	
	
	
}

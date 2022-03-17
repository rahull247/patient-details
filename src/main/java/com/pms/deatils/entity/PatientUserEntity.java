package com.pms.deatils.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Check;

import com.pms.deatils.constant.CommonConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PATIENT_USER_MASTER")
public class PatientUserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private Integer patientId;
	@Check(constraints = "title in ('Mr', 'Ms', 'Mrs'")
	private String title;
	@Column(name = "first_name")
	@NotEmpty(message = "Please provide your first name")
	private String firstName;
	@Column(name = "last_name")
	@NotEmpty(message = "Please provide your last name")
	private String lastName;
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String emailId;
	@Column(name="current_password")
	private String currentPassword;
	@Column(name = "old_password")
	private String oldPassword;
	@Column(name = "dob")
	private LocalDateTime dateOfBirth;
	@Column(name = "country_code", nullable = false)
	private String countryCode;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Column(name = "reg_date")
	private LocalDateTime dateOfRegistration;
	@Column(name = "account_status", nullable = false)
	private String accountStatus = CommonConstants.ACTIVE_ACCOUNT_STATUS;
	
	
	@Override
	public String toString() {
		return "PatientUserEntity [patientId=" + patientId + ", title=" + title + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", currentPassword=" + currentPassword
				+ ", oldPassword=" + oldPassword + ", dateOfBirth=" + dateOfBirth + ", countryCode=" + countryCode
				+ ", phoneNumber=" + phoneNumber + ", dateOfRegistration=" + dateOfRegistration + ", accountStatus="
				+ accountStatus + "]";
	}
	
	

}
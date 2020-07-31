package com.ait.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REGISTRATIONFORM")
public class RegistrationEntity {
	@Id
	@Column(name = "REG_ID")
	@SequenceGenerator(name = "SEQUENCE_ID", sequenceName = "REG_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCE_ID", strategy = GenerationType.SEQUENCE)
	private Integer regId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NO")
	private Long phoneNo;
	@Column(name = "DOB")
	private String DOB;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "CITY_ID")
	private Integer cityId;
	@Column(name = "ACC_STATUS")
	private String accStatus;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@UpdateTimestamp  
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	@Column(name = "PASSWORD")
	private String password;
	
}

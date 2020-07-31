package com.ait.bind;


import lombok.Data;

@Data
public class RegistrationForm {
	private Integer regId;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNo;
	private String DOB;
	private String gender;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private String accStatus;
	private String activeSw;
	private String password;

}

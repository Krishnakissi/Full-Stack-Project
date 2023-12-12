package com.xworkz.rto.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String state;
	private String country;
	private int age;
	private String dob;
	private String bloodgroup;
	private String qualification;
	private String placeOfBirth;
	private String rtoOffice;
	private String email;
	private String permanentAddress;
	private int permanentPincode;
	private String currenetAddress;
	private int currentPincode;
	private long phoneNumber;
	private long aadharNumber;
	private LocalDateTime registerLocalDateTime;
	private boolean organDonation;
	private String applicationNumber;
	private String status;
	private String otp;
	
}

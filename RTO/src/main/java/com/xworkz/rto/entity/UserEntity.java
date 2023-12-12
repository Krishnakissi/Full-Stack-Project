package com.xworkz.rto.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="User_info")
@NamedQueries({
		@NamedQuery(name="userFindAll" , query = "select entity from UserEntity entity"),
		@NamedQuery(name = "userLogin"     , query = "select entity from UserEntity entity where entity.applicationNumber=:aporpn or entity.phoneNumber=:aporpn and entity.dob=:db"),
		@NamedQuery(name = "searchByUserState" ,query = "select e from UserEntity e where e.state=:llrstate"),
		@NamedQuery(name="updatestatus",query = "update UserEntity e set e.status='Approved' where e.applicationNumber=:appNum ")
	})

public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Id")
	private int id;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Middle_Name")
	private String middleName;

	@Column(name="Last_Name")
	private String lastName; 
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Country")
	private String country;
	
	@Column(name="Age")
	private int age;
	
	@Column(name="Dob")
	private String dob;
	
	@Column(name="Bloodgroup")
	private String bloodgroup;
	
	@Column(name="Qualification")
	private String qualification;
	
	@Column(name="Place_Of_Birth")
	private String placeOfBirth;
	
	@Column(name="Rto_Of_Office")
	private String rtoOffice;
	
	@Column(name="E_mail")
	private String email;
	
	@Column(name="Permanent_Address")
	private String permanentAddress;
	
	@Column(name="Permanent_Pincode")
	private int permanentPincode;
	
	@Column(name="Currenet_Address")
	private String currenetAddress;
	
	@Column(name="Current_Pincode")
	private int currentPincode;
	
	@Column(name="Phone_Number")
	private long phoneNumber;
	
	@Column(name="Aadhar_Number")
	private long aadharNumber;
	
	@Column(name="Register_LocalDateTime")
	private LocalDateTime registerLocalDateTime;
	
	@Column(name="Organ_Donation")
	private boolean organDonation;
	
	@Column(name="ApplicationNumber")
    private String applicationNumber;
	
	@Column (name="Status")
	private String status;
	
	@Column (name="OTP")
	private String otp;


}

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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rto_info")
@Data
@NoArgsConstructor
@NamedQueries({ @NamedQuery(name = "FindAll", query = "select entity from RtoEntity entity"),
		@NamedQuery(name = "FindByEmail", query = "select entity from  RtoEntity entity where entity.email=:em"),
		@NamedQuery(name="checkLogin" , query = "select entity from RtoEntity entity where entity.email=:em and entity.password=:pw"),
		@NamedQuery(name="adminLogin",query="select entity from  RtoEntity entity where entity.email=:eml and entity.password=:pwd"),
        @NamedQuery(name="adminOtpLogin", query ="select entity from RtoEntity entity where entity.email=:eml and entity.otp=:otp"),

		@NamedQuery(name="searchByState",query="select entity from RtoEntity entity where entity.state=:st")})
public class RtoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Password")
	private String password;

	@Column(name = "ConfirmPassword")
	private String confirmPassword;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "PhoneNumber")
	private long phoneNumber;

	@Column(name="State")
	private String state;

	@Column(name="District")
	private String district;
	
	@Column(name = "Email")
	private String email;

	@Column(name = "RegisteredOn")
	private LocalDateTime registerDateTime;
	
	@Column(name = "otp")
	private String otp;

	
}
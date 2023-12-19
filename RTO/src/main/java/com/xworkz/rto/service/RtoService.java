package com.xworkz.rto.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.UserEntity;

public interface RtoService {
	public Set<ConstraintViolation<RtoDto>> onSave(RtoDto dto);
	public boolean onUserSave(UserDto udto);
	public List<RtoDto> findAll();
	public List<UserDto> userfindAll();

	public RtoDto checkLogin(String email,String password);
	public RtoDto adminLogin(String email,String otp);
	public RtoDto forgotPass(String email, String otp) ;

	public UserDto userLogin(String apporpn, String dob) ;

	public abstract List<RtoDto> searchByState(String state);
	public List<UserDto> searchByUserState(String state) ;
	public boolean updateStatus(String applicationNumber) ;
	public boolean updateOtpById(RtoDto rtoDto,String otp);

	public boolean updateById(int id) ;
	public boolean updateForgot(RtoDto rtoDto,String password,String ConfirmPassword) ;



}
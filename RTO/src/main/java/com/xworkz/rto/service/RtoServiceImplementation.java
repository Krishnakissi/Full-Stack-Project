package com.xworkz.rto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.entity.UserEntity;
import com.xworkz.rto.repository.RtoRepository;

@Service
public class RtoServiceImplementation implements RtoService {
	@Autowired
	RtoRepository repo;

	public RtoServiceImplementation() {
		System.out.println("this is RtoServiceImplementation");
	}

	@Override
	public Set<ConstraintViolation<RtoDto>> onSave(RtoDto dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator valid = factory.getValidator();
		Set<ConstraintViolation<RtoDto>> voilations = valid.validate(dto);
		if (voilations.isEmpty()) {
			repo.onSave(dto);
			System.out.println("Data saved succesfully....");
			return voilations;
		} else {
			System.out.println("Voilations are present" + voilations);
			return voilations;
		}
	}
	
	
	
//eli nodko maga on save method  validation front end nalli madirthivi......start
	@Override
	public boolean onUserSave(UserDto udto) {
		
		 int randomNumber = (int) ((Math.random()*800));
		 String  rn=String.valueOf(randomNumber);
		 String code=null;
		 if  (udto.getState().equals("Karnataka"))
		  { 
			 code="KA2023LLR" + rn; }
		  udto.setApplicationNumber(code);
		 	
		repo.onUserSave(udto);
		System.out.println(udto);
		return true;
	}
//the end........................................
	
	
	@Override
	public List<RtoDto> findAll() {

		List<RtoEntity> entityList = repo.findAll();

		List<RtoDto> dtoList = new ArrayList<RtoDto>();

		for (RtoEntity en : entityList) {
			System.out.println(en);
			RtoDto dto = new RtoDto();
			BeanUtils.copyProperties(en, dto);
			dtoList.add(dto);
		}
		System.out.println(dtoList.toString());
		return dtoList;
	}
	
	@Override
	public List<UserDto> userfindAll() {

		List<UserEntity> userEntityList = repo.userfindAll();

		List<UserDto> userdtoList = new ArrayList<UserDto>();

		for (UserEntity en : userEntityList) {
			System.out.println(en);
			UserDto udto = new UserDto();
			BeanUtils.copyProperties(en, udto);
			userdtoList.add(udto);
		}
		System.out.println(userdtoList.toString());
		return userdtoList;
	}
	@Override
	public RtoDto checkLogin(String email, String password) {
		RtoEntity entity = repo.checkLogin(email, password);
		if (email != null && password != null & password.length() >= 8) {
			if (entity != null) {
				RtoDto dto = new RtoDto();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmail().equalsIgnoreCase(email) && dto.getPassword().equals(password)) {
					return dto;
				} else {
					System.out.println("Invalid email or password");
					return null;
				}
			} else {
				System.out.println("Entity is null");
				return null;
			}
		} else {
			System.out.println("email or password is null");
			return null;
		}
	}
	
	@Override
	public RtoDto adminLogin(String email, String otp) {
		if (email != null && otp != null) {
			RtoEntity entity= repo.checkLogin(email, otp);
			if (entity != null) {
				RtoDto dto = new RtoDto();
				dto.setAccountActiveOrInactive("active");
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmail().equalsIgnoreCase(email) && dto.getOtp().equals(otp)) {					
					System.out.println(dto);
					return dto;
				} else {
					dto.setAccountActiveOrInactive("inactive");
					System.out.println("Invalid email or otp");
					return null;
				}
			} else {
				System.out.println("Entity is null");
				return null;
			}
		} else {
			System.out.println("email or otp is null");
			return null;
		}
	}
	
	public RtoDto forgotPass(String email, String otp) {
		if (email != null && otp != null) {
			RtoEntity entity = repo.checkLogin(email, otp);
			if (entity != null) {
				RtoDto dto = new RtoDto();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmail().equals(email) && dto.getOtp().equals(otp)) {
					return dto;
				} else {
					System.out.println("Invalid email or otp");
					return null;
				}
			} else {
				System.out.println("Entity is null");
				return null;
			}
		} else {
			System.out.println("email or otp is null");
		return null;
	}
}
	
	@Override
	public UserDto userLogin(String apporphone, String dob) {
		if(apporphone!=null  && dob!=null) {
			UserEntity uentity=repo.userLogin(apporphone, dob);
			if(uentity!=null) {
				UserDto udto=new UserDto();
				BeanUtils.copyProperties(uentity, udto);
				if(udto.getApplicationNumber().equals(apporphone) && udto.getDob().equals(dob)) {
					return udto;
				}else {
					System.out.println("Invalid login credentials");
					return null;
					}
		}else {
			System.out.println("Entity is null");
			return null;
		}
		}else {
			System.out.println("credentials are null");
		
	}
		return null;
	}

				
				

	@Override
	public List<RtoDto> searchByState(String state) {

		System.out.println("search by state:" + state);
		List<RtoEntity> entityList = repo.searchByState(state);

		List<RtoDto> dtoList = new ArrayList<RtoDto>();

		for (RtoEntity en : entityList) {
			System.out.println(en);
			RtoDto dto = new RtoDto();
			BeanUtils.copyProperties(en, dto);
			dtoList.add(dto);
		}
		System.out.println(dtoList.toString());
		return dtoList;
	}

	@Override
	public List<UserDto> searchByUserState(String state) {
		System.out.println("search by state:"+state);
		List<UserEntity> entityList=repo.searchByUserState(state);
		List<UserDto> udtoList=new ArrayList<UserDto>();
		for(UserEntity uen:entityList) {
			System.out.println(uen);
			UserDto udto=new UserDto();
			BeanUtils.copyProperties(uen,udto );
			udtoList.add(udto);
			}
		return udtoList;
	}

	

	@Override
	public boolean updateStatus(String applicationNumber) {
		repo.updateStatus(applicationNumber);
		return true;
	}

	@Override
	public boolean updateById(int id) {
		boolean update=repo.updateById(id);
		return update;
	}

	@Override
	public boolean updateOtpById(RtoDto rtoDto,String otp) {
		rtoDto.setOtp(otp);
		 boolean otpupdate= repo.updateOtpById(rtoDto);
		return otpupdate;
	}
	
	@Override
	public boolean updateForgot(RtoDto rtoDto,String password,String ConfirmPassword) {
		rtoDto.setPassword(password);
		rtoDto.setConfirmPassword(ConfirmPassword);
		 boolean otpupdate= repo.updateForgot(rtoDto, password, ConfirmPassword);
		return otpupdate;
	}
}

	

package com.xworkz.rto.repository;

import java.util.List;


import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.entity.UserEntity;

public interface RtoRepository {
public abstract boolean onSave(RtoDto dto);
public abstract boolean onUserSave(UserDto udto);
public List<RtoEntity> findAll();
public List<UserEntity> userfindAll();
public RtoEntity checkLogin(String email,String password);
public RtoEntity adminLogin(String email,String otp);
public RtoEntity forgotPass(String email, String otp) ;

public UserEntity userLogin(String apporphone,String dob) ;
public abstract List<RtoEntity> searchByState(String state);
public boolean updateById(int id);
public boolean updateOtpById(RtoDto rtoDto);
public List<UserEntity> searchByUserState(String state) ;
public boolean updateStatus(String applicationNumber) ;


}

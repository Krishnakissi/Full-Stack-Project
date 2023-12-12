package com.xworkz.rto.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.entity.UserEntity;

@Repository
public class RtoRepositoryImplementation implements RtoRepository {
	public RtoRepositoryImplementation() {
		System.out.println("this is RtoRepositoryImplementation");
	}

	@Autowired//(for initialization purpose)
	EntityManagerFactory factory;

	@Override
	public boolean onSave(RtoDto dto) {
		System.out.println("repo method");
		System.out.println(dto);

		RtoEntity entity = new RtoEntity();
		BeanUtils.copyProperties(dto, entity);//dto-source,entity-target(beanutils-to copy properties
																	//from dto to entity)
		entity.setRegisterDateTime(LocalDateTime.now());
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	
	@Override
	public boolean onUserSave(UserDto udto) {
		System.out.println("On save method of User dto");
		UserEntity uentity=new UserEntity();
		BeanUtils.copyProperties(udto, uentity);
		uentity.setRegisterLocalDateTime(LocalDateTime.now());
		uentity.setStatus("pending");
		
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(uentity);
		transaction.commit();
		manager.close();
		return true;
	}
	
	@Override
	public List<RtoEntity> findAll() {
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createNamedQuery("FindAll");
		List<RtoEntity> entities = q.getResultList();
		System.out.println(entities);
		return entities;
	}
	
	
	@Override
	public List<UserEntity> userfindAll() {
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createNamedQuery("userFindAll");
		List<UserEntity> userentities = q.getResultList();
		System.out.println(userentities);
		return userentities;
	}
	
	@Override
	public RtoEntity checkLogin(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Query loginQuery = manager.createNamedQuery("checkLogin");
		loginQuery.setParameter("em", email);
		loginQuery.setParameter("pw", password);
		try {
			return (RtoEntity) loginQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	@Override
	public RtoEntity adminLogin(String email, String otp) {
		EntityManager manager = factory.createEntityManager();
		Query loginQuery = manager.createNamedQuery("adminOtpLogin");
		loginQuery.setParameter("eml", email);
		loginQuery.setParameter("otp", otp);

		//loginQuery.setParameter("pwd", password);
		
		try {
			
		
			return (RtoEntity) loginQuery.getSingleResult();
		} catch (NoResultException e) {
		return null;
	}
}
	
	public RtoEntity forgotPass(String email, String otp) {
		EntityManager manager = factory.createEntityManager();
		Query loginQuery = manager.createNamedQuery("adminOtpLogin");
		loginQuery.setParameter("eml", email);
		//loginQuery.setParameter("pwd", password);
		loginQuery.setParameter("otp", otp);

		
		try {
			return (RtoEntity) loginQuery.getSingleResult();
		} catch (NoResultException e) {
		return null;
	}
	
}
	public UserEntity userLogin(String apporphone,String dob) {
		EntityManager manager = factory.createEntityManager();
		Query loginQuery = manager.createNamedQuery("userLogin");
		loginQuery.setParameter("aporpn", apporphone );
		loginQuery.setParameter("db", dob);

		
		
		try {
			return (UserEntity) loginQuery.getSingleResult();
		} catch (NoResultException e) {
		return null;
	}
	}
	@Override
	public List<RtoEntity> searchByState(String state) {
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("searchByState");
		q.setParameter("st",state);
		List<RtoEntity> list=q.getResultList();
		System.out.println(list.toString());
		return list;
		
	}
	
	@Override
	public List<UserEntity> searchByUserState(String state) {
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("searchByUserState");
		q.setParameter("llrstate",state);
		List<UserEntity> userlist=q.getResultList();
		System.out.println(userlist.toString());
		return userlist;
		}

	@Override
	public boolean updateStatus(String applicationNumber) {
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("updateStatus");
		q.setParameter("appNum",applicationNumber);
		manager.getTransaction().begin();
		int row=q.executeUpdate();
manager.getTransaction().commit();
		return row>0;
	}
	
	public boolean updateById(int id) {
		EntityManager manager=factory.createEntityManager();
		UserEntity entity=manager.find(UserEntity.class, id);
		if(entity!=null) {
			entity.setStatus("approved");
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
			manager.close();
			return true;
			}else {
			System.out.println("Invalid id");
		
		return false;
	}
	}


	@Override
	public boolean updateOtpById(RtoDto rtoDto) {
		EntityManager manager=factory.createEntityManager();
		RtoEntity entity=new RtoEntity();
		BeanUtils.copyProperties(rtoDto, entity);
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	
}
package com.entity.layer2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.layer1.Logindetail;
import com.entity.layer1.Userdetail;

@Repository
public class LoginDetailRepositoryImpl implements LoginDetailRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	//@Override
	@Transactional
	public List<Logindetail> getAll() {
		Query query= entityManager.createNativeQuery("select * from  LoginDetails", Logindetail.class);
		
		 List<Logindetail> user= query.getResultList();
		return user;
		
	}

}

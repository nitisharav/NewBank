package com.entity.layer2;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entity.layer1.Admininput;



@Repository
public class AdmininputImpl implements AdmininputRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public void save(Admininput admininputs) {
		
		entityManager.persist(admininputs);
	}
	
	@Transactional
	public Admininput getAdminById(String adminuserid) {
	//	 System.out.println("Hi3");
	//	Query query= entityManager.createNativeQuery("select * from admininputs a where a.adminuserid="+adminuserid,
		
		//		Admininput.class);
            System.out.println("Hi1");
		//		Admininput items = (Admininput)query.getSingleResult();
	//			 System.out.println("Hi2");
			//List<fundTransfer> f=query.getResultList();
		                          //  select * from fundtransfer t where t.FROM_ACCNO=111 OR t.TO_ACCNO=111;
				
			 System.out.println("Hi5");
		//("getMiniStatement").setParameter("accNumber",accNumber)
		   return entityManager.find(Admininput.class, adminuserid);
	//	return items;
		
	}
	
	@Transactional
	public String getAdminByIdAndPassword(String adminuserid, String adminpassword) {
	Query query= entityManager.createQuery("select a.adminuserid from Admininput a where a.adminuserid=:x and a.adminpassword=:y");
	query.setParameter("x",adminuserid);
	query.setParameter("y",adminpassword);
//	System.out.println("hello1");
		//Query query= entityManager.createNativeQuery("select * from Admininputs t where t.adminuserid="+adminuserid+" or adminpassword="+adminpassword,Admininput.class);
			
	
	String items = (String)query.getSingleResult();
			//	System.out.println("hello");
				return items;
	}

	@Override
	public boolean isAdminAvailable(String adminuserid) {
		System.out.println("userId is "+adminuserid);
		BigDecimal res  = (BigDecimal) entityManager.createNativeQuery("select count(a.adminUserID) from Admininputs a where a.adminUserID ="+adminuserid)
				/*.setParameter("id", adminuserid)*/.getSingleResult();
		System.out.println("count is "+res);
		int intNumber = res.intValue();
//		return (Long) entityManager.createNativeQuery("select count(a.adminUserID) from Admininputs a where a.adminUserID ="+adminuserid)
		//		/*.setParameter("user", adminuserid)*/.getSingleResult() == 1 ? true : false;
		System.out.println("count is "+intNumber);
		System.out.println("admin exist.....");
	return intNumber ==  1 ? true : false;
	
	}



	
	
}


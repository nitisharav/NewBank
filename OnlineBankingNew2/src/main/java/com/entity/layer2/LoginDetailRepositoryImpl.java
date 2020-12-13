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
	private EntityManager em;
	
	/*@Override
	@Transactional
public void save(Logindetail user) {
		 //TODO Auto-generated method stub
		em.persist(user);
	}*/
	
	//@Override
		@Transactional
		public List<Logindetail> getAl1l() {
			Query query= em.createNativeQuery("select * from  LoginDetails", Logindetail.class);
			
			 List<Logindetail> user= query.getResultList();
			return user;
			
		}

	

	//@Transactional
//	public List<Logindetail>getUserId() {
//		// TODO Auto-generated method stub
//		Query q=em.createNativeQuery("select max(u.Userid) from Logindetails u", Logindetail.class);
				
//		return(String) q.getSingleResult();
				
//	}

//	@Override
//	public void save(Logindetail login) {
//		// TODO Auto-generated method stub
		
//	}
	//@Transactional
//	public List<Logindetail> getUserByAccNumber(String accNumber)
	// {
		
	//	Query query= em.createNativeQuery("select * from Logindetails u where u.ACCOUNTNUMBER.accountno="+accNumber,Logindetail.class);
				
		
				
		//			List<Logindetail> items = query.getResultList(); 

					
			//		return items;
	//	}

	
	//@Transactional
	//public void resetPassword(String updatedPassword,String accountno) {
	
		
		
		
	//	Query query = em.createNativeQuery("update Logindetails set Login_Password ='"+updatedPassword+"' where ACCOUNTNUMBER ="+accountno,Logindetail.class);
	//	query.executeUpdate();
		
	//}
	


@Transactional
public void resetTransactionPassword(String userId,String updatedPassword) {

	
	
	
	Query query = em.createNativeQuery("update Logindetails set Transaction_Password ='"+updatedPassword+"' where USERID ="+userId,Logindetail.class);
	query.executeUpdate();
	
}


			

/*@Override
@Transactional
public String getUserByAccNumber(String accNumber) {
	// TODO Auto-generated method stub
	return (String)em.createNamedQuery("getIdByAccNumber")
			.setParameter("accNumber",accNumber).getSingleResult();
}
@Override
@Transactional
public String getTransactionPassword(String fromAccNumber) {
	// TODO Auto-generated method stub
	System.out.println(fromAccNumber);
	return (String)em.createNamedQuery("getTnPassword")
			.setParameter("accNumber",fromAccNumber).getSingleResult();
}
}
	
	@Override
	@Transactional
	public OpenAccount findbyId(String accNumber) {
		return em.find(OpenAccount.class,accNumber);
	}
	
	@Override
	@Transactional
	public boolean isAccountRegistered(String accNumber) {
		return (Long)em.createNamedQuery("getAcc").setParameter("accNumber", accNumber)
				.getSingleResult()==1 ? true : false;
	}
	
	@Override
	@Transactional
	public boolean validUserIdPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return (Long) em.createNamedQuery("loginCheck").setParameter("id", userId).setParameter("password", password)
				.getSingleResult()==1?true:false;
	}

	@Override
	@Transactional
	public User findUserById(String userId) {	
		return em.find(User.class,userId);
	}

	@Override
	@Transactional
	public boolean isUserValid(String userId) {
		return (Long) em.createNamedQuery("userIdCheck").setParameter("id",userId)
				.getSingleResult()==1?true:false;
	}

	@Override
	@Transactional
	public int getNoOfInvalidAttempts(String userId) {
		// TODO Auto-generated method stub
		return (Integer)em.createNamedQuery("getInvalidAttempts").setParameter("id", userId)
				.getSingleResult();
	}

	@Override
	@Transactional
	public void setNoOfInvalidAttempts(String userId, int attempts) {
		// TODO Auto-generated method stub
		em.createNamedQuery("updateInvalidAttempts")
		.setParameter("attempts",attempts)
		.setParameter("id", userId)
		.executeUpdate();
	}
	
	@Override
	@Transactional
	public void resetPassword(String userId, String updatedPassword) {
		em.createNamedQuery("changePassword")
		.setParameter("id",userId)
		.setParameter("password",updatedPassword)
		.executeUpdate();
	}
	@Override
	@Transactional
	public String getUserByAccNumber(String accNumber) {
		// TODO Auto-generated method stub
		return (String)em.createNamedQuery("getIdByAccNumber")
				.setParameter("accNumber",accNumber).getSingleResult();
	}
	@Override
	@Transactional
	public String getTransactionPassword(String fromAccNumber) {
		// TODO Auto-generated method stub
		System.out.println(fromAccNumber);
		return (String)em.createNamedQuery("getTnPassword")
				.setParameter("accNumber",fromAccNumber).getSingleResult();
	}
	@Override
	@Transactional
	public void savelastLogin(String userId,String date) {
		// TODO Auto-generated method stub
		em.createNamedQuery("setLastLoginDate")
		.setParameter("id",userId)
		.setParameter("dateTime",date)
		.executeUpdate();
	}

	@Override
	@Transactional
	public void resetTransactionPassword(String userId, String updatedPassword) {
		System.out.println(userId);
		System.out.println(updatedPassword);
		em.createNamedQuery("changeTransactionPassword")
		.setParameter("id",userId)
		.setParameter("password",updatedPassword)
		.executeUpdate();
	}
}*/
	

	
	@Transactional
	public void save(Logindetail user) {
		
		em.persist(user);
		
	}

	@Override
	public boolean isUserPresent() {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public String getUserId() {
		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Userdetail findbyId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountRegistered(String accNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validUserIdPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Logindetail findUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserValid(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNoOfInvalidAttempts(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNoOfInvalidAttempts(String userId, int attempts) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void resetPassword(String userId, String updatedPassword) {
//		// TODO Auto-generated method stub
		
//	}

//	@Override
//	public String getUserByAccNumber(String accNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String getTransactionPassword(String fromAccNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savelastLogin(String userId, String date) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void resetTransactionPassword(String userId, String updatedPassword) {
//		// TODO Auto-generated method stub
		
//	}

	

	@Transactional
	public void resetPassword(String updatedPassword,String accountno) {

	Query query = em.createNativeQuery("update Logindetails set Login_Password ='"+updatedPassword+"' where accountnumber ="+accountno,Logindetail.class);
	query.executeUpdate();

	}
	
	
	@Transactional
	public List<Logindetail> getUserId(){
		Query q = em.createNativeQuery("select * from logindetails", Logindetail.class);
		List<Logindetail> f = q.getResultList();
		return f;
	}

//@Override
//	public List<Logindetail> getAll() {
		// TODO Auto-generated method stub
//		return null;
//	}


//@Override
//public List<Logindetail> getUserId() {
//	// TODO Auto-generated method stub
//	return null;
//}




//@Override
//public List<Logindetail> getAll1() {
//	// TODO Auto-generated method stub
//	return null;
//}
	

	
	
	@Transactional
	public List<Logindetail> getUserByAccNumber(String accno ) {
		
		Query query= em.createNativeQuery("select * from logindetails where logindetails.accountnumber="+accno,
		
				Logindetail.class);
	//	select u.userId from User u where u.accountNumber.accountNumber =:accNumber

				 List<Logindetail> items = query.getResultList(); 
				return items;

}
	/*
		@Transactional
	public Logindetail getUserByAccNumber(Userdetail a) {
			//Query q = null;
			String query = "from Logindetail where userdetail2 =:x";
	   Query     q = (Query) this.entityManager.createQuery(query);
	        q.setParameter("x", a);
	        Logindetail cs = (Logindetail)q.getSingleResult();
	       // System.out.println(cs.getLastlogin());
	          
		return cs;
	
	}*/
		@Transactional
	    public List<Logindetail> getAll() {
	        String s="from Logindetail";
	        Query query = em.createQuery(s);
	        List<Logindetail> logindetail=query.getResultList();
	        return logindetail;
		}
	/*public Logindetail get(String accountno)
	{
		 
			   
		       
		        Logindetail re = entityManager.find(Logindetail.class, accountno);
				return re;
	}
	
		@Override
		public Logindetail get(String accountno) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Logindetail getUserByAccNumber(String accountno) {
			// TODO Auto-generated method stub
			return null;
		}
}*/



		@Override
		public List<Logindetail> getUserByAccNumber1(String accno) {
			// TODO Auto-generated method stub
			return null;
		}
}


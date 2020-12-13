package com.entity.layer2;

import java.util.List;

import com.entity.layer1.Logindetail;
import com.entity.layer1.Userdetail;

public interface LoginDetailRepository {
	void save(Logindetail login);
	//public String getUserId();
	
	
	
	List<Logindetail> getUserByAccNumber(String accNumber);
	
	void resetPassword(String updatedPassword,String accountno);
	void resetTransactionPassword(String userId,String updatedPassword);
	
	
//	void save(Logindetail user);
	boolean isUserPresent();
	//String getUserId();
	public List<Logindetail> getUserId();
	Userdetail findbyId(String id);
	boolean isAccountRegistered(String accNumber);
	boolean validUserIdPassword(String userId, String password);
	Logindetail findUserById(String userId);
	boolean isUserValid(String userId);
	int getNoOfInvalidAttempts(String userId);
	void setNoOfInvalidAttempts(String userId, int attempts);
//	void resetPassword(String userId,String updatedPassword);
//	String getUserByAccNumber(String accNumber);
	String getTransactionPassword(String fromAccNumber);
	void savelastLogin(String userId,String date);
//	void resetTransactionPassword(String userId,String updatedPassword);
	
	//void save(Logindetail login);
	

//	 List<Logindetail> getUserId();
	//OpenAccount findbyId(String id);
	
	
	//User findUserById(String userId);
	
	//int getNoOfInvalidAttempts(String userId);
	///void setNoOfInvalidAttempts(String userId, int attempts);
//	void resetPassword(String userId,String updatedPassword);
	
	//void savelastLogin(String userId,String date);
	//void resetTransactionPassword(String userId,String updatedPassword);
	//String getUserByAccNumber(String accNumber);
	//String getTransactionPassword(String fromAccNumber);
	List<Logindetail> getUserByAccNumber1(String accno);
	//public Logindetail getUserByAccNumber(String accountno);
  // public Logindetail get(String accountno);
	//void resetPassword(String updatedPassword,String accountno);
	//public Logindetail getUserByAccNumber(Userdetail a);
	public List<Logindetail> getAll();
	//public List<Logindetail> getAll1();
	//void save(Logindetail login);
	
		//String getUserId();
		//OpenAccount findbyId(String id);
		
		
		//User findUserById(String userId);
		
		//int getNoOfInvalidAttempts(String userId);
		///void setNoOfInvalidAttempts(String userId, int attempts);
		//void resetPassword(String userId,String updatedPassword);
		
		//void savelastLogin(String userId,String date);
		//void resetTransactionPassword(String userId,String updatedPassword);
		//String getUserByAccNumber(String accNumber);
		//String getTransactionPassword(String fromAccNumber);
	
                            //                 List<Logindetail> getUserByAccNumber(String accno);
		//Logindetail getUserByAccNumber(String accountno);
	                          //              	public Logindetail get(String accountno);

}

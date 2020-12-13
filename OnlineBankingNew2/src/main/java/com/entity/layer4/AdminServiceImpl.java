package com.entity.layer4;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.entity.layer1.Admininput;
import com.entity.layer2.AdmininputRepository;
import com.entity.layer3.AdminCredentialsdto;

//import com.lti.exception.ServiceException;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdmininputRepository repo;
	
	@Override
	public void registerAdmin(Admininput admin) {
	/*	// TODO Auto-generated method stub
		Admininput obj;
	//	obj=repo.getAdminById(admin.getAdminuserid());
	//	if(obj==null) {
			repo.save(admin);
		}else {
		//	throw new ServiceException("User Already Exists");
		}*/
		Admininput obj = repo.getAdminById(admin.getAdminuserid());
		
		if(obj==null) {
			repo.save(admin);
		}else {
			System.out.println("User Already Exists");
			throw new ServiceException("User Already Exists");
		}
		
	
	}

	@Override
	public Admininput adminLogin(AdminCredentialsdto adminCredentials)
	{
		// TODO Auto-generated method stub
		try {
//			System.out.println("user "+adminCredentials.getUserId());
//			System.out.println("value is "+repo.findAdminById(adminCredentials.getUserId()));
			if(!repo.isAdminAvailable(adminCredentials.getUserId())) {
//				System.out.println("printing this");
				throw new ServiceException("User Not Exist");
			}
			String userId = repo.getAdminByIdAndPassword(adminCredentials.getUserId(), adminCredentials.getPassword());
			System.out.println(userId);
			Admininput admin = repo.getAdminById(userId);
//			System.out.println("Admin is service is " +admin);
			return admin;
		}
		catch(EmptyResultDataAccessException e){
			throw new ServiceException("Incorrect UserId/Password");
		}
	}
}
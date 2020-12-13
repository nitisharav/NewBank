package com.entity.layer5;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.layer3.AdminCredentialsdto;
//import com.lti.exception.ServiceException;
import com.entity.layer1.Admininput;
import com.entity.layer4.AdminService;
import com.entity.layer6.LoginStatus;
import com.entity.layer6.Status;
import com.entity.layer6.Status.StatusType;

@CrossOrigin(origins = "http://localhost:4200")
@RestController	
public class AdminInputController {
	
	@Autowired
	private AdminService service;
/*	
	@PostMapping(path="/registerAdmin")
	public Status registerAdmin(@RequestBody Admin admin) {
	try {
			service.registerAdmin(admin);
			Status registerStatus = new Status();
			registerStatus.setStatus(StatusType.SUCCESS);
			registerStatus.setMessage("User Registered");
			return registerStatus;
		}
	catch(ServiceException e) {
			Status registerStatus = new Status();
			registerStatus.setStatus(StatusType.FAILURE);
			registerStatus.setMessage(e.getMessage());
			return registerStatus;
		}
	}
	*/
	@PostMapping(path="/registerAdmin")
	public Status registerAdmin(@RequestBody Admininput admin) {
		try {
			service.registerAdmin(admin);
			Status registerStatus = new Status();
			registerStatus.setStatus(StatusType.SUCCESS);
			registerStatus.setMessage("User Registered");
			return registerStatus;
		}
	catch(ServiceException e) {
			Status registerStatus = new Status();
			registerStatus.setStatus(StatusType.FAILURE);
			registerStatus.setMessage("not registered");
			return registerStatus;
	}
		}
/*	
	 @PostMapping(path="/registerAdmin")
	    public Status registerAdmin(@RequestBody Admininput admin) {​​​​​​​
	        try {​​​​​​​
	            service.registerAdmin(admin);
	            Status registerStatus = new Status();
	            registerStatus.setStatus(StatusType.SUCCESS);
	            registerStatus.setMessage("User Registered");
	            return registerStatus;
	        }​​​​​​​
	    catch(ServiceException e) {​​​​​​​
	            Status registerStatus = new Status();
	            registerStatus.setStatus(StatusType.FAILURE);
	            registerStatus.setMessage("not registered");
	            return registerStatus;
	    }​​​​​​​
	        }​​​​​​​
	
	*/
	@PostMapping(path="/loginAdmin")
	public LoginStatus adminLogin(@RequestBody AdminCredentialsdto adminCredentials) {
		try {
			Admininput admin = service.adminLogin(adminCredentials);
			System.out.println("Hello2");
			LoginStatus loginStatus = new LoginStatus();
			System.out.println("Hello1");
			loginStatus.setName(admin.getAdminname());
			loginStatus.setUserId(admin.getAdminuserid());
			loginStatus.setMessage("Login Successful");
			loginStatus.setStatus(StatusType.SUCCESS);
			return loginStatus;
		}
		catch(ServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setMessage(e.getMessage());
			loginStatus.setStatus(StatusType.FAILURE);
			return loginStatus;
		}
		
	}
}
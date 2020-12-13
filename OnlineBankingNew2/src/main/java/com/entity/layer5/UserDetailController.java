package com.entity.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.layer1.Userdetail;
import com.entity.layer3.CreateAccountStatusdto;
import com.entity.layer4.UserDetailService;

import com.entity.layer6.Status;
//import com.lti.exception.ServiceException;
import com.entity.layer6.Status.StatusType;
import com.entity.layer3.ViewUserDetailsDto;




@CrossOrigin //(origins =  "http://localhost:4200")
@RestController
public class UserDetailController {
	
	@Autowired
	UserDetailService service;
	
	@PostMapping(path="/openAccount")
	public Status registerAccount(@RequestBody Userdetail account) 
	{try 
	{
		service.registerAccount(account);
		Status status = new Status();
		status.setMessage("Account created, check refernce ID "+account.getReferenceid()+" for future update");
		status.setStatus(StatusType.SUCCESS);
		return status;
	}
	catch(Exception e) 
	{
		Status status = new Status();
		status.setMessage(e.getMessage());
		status.setStatus(StatusType.FAILURE);
		return status;
	}
	
	}
	@GetMapping(path="/viewAllAccounts")
	public List<Userdetail> viewAllAccounts(){
		return service.getAllAccounts();
	}
	@GetMapping(path = "/viewAccountByRefId/{referId}")
	public CreateAccountStatusdto viewAccountByRefId(@PathVariable(value = "referId") String referId) 
	{
//		System.out.println("Reference Id is: "+refId);
		
		try {
			Userdetail account = service.getAccountById(referId);
			System.out.println("acc is : "+account);
			
			CreateAccountStatusdto status = new CreateAccountStatusdto();
			status.setRefernceId(account.getReferenceid());
			status.setFirstName(account.getFirstname());
			status.setAdminRemark(account.getAdminremark());
			status.setApprovedByAdmin(account.getApprovedbyadmin());
			System.out.println(account.getApprovedbyadmin());
			if(account.getApprovedbyadmin().equals("Decline") || account.getApprovedbyadmin().equals("Waiting for Approval")) {
				status.setAccountNumber("NA");
			}else status.setAccountNumber(account.getAccountno());
			return status;
		}
		catch (Exception e) {
			// TODO: handle exception
			CreateAccountStatusdto status = new CreateAccountStatusdto();
			status.setAccountNumber("No User");
			return status;
		}
	}

	@PostMapping(path="/adminApproval")
	public Status adminApproval(@RequestBody CreateAccountStatusdto result) 
	{
		System.out.println(result);
		try 
		{
			service.addAccountStatus(result);
			Status status = new Status();
			status.setMessage("Updated Successfully");
			status.setStatus(StatusType.SUCCESS);
			return status;
			
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);
			return status;
		}
		
	}
	@GetMapping(path = "/viewUserDetails/{accountNo}")
	public ViewUserDetailsDto getUserDetails(@PathVariable(value = "accountNo") String accountNo) {
		return service.userDetails(accountNo);
	}
	
}

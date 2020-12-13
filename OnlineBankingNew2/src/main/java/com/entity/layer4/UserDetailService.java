package com.entity.layer4;

import java.util.List;

import com.entity.layer1.Userdetail;
import com.entity.layer3.CreateAccountStatusdto;
import com.entity.layer3.ViewUserDetailsDto;



public interface UserDetailService {
	void registerAccount(Userdetail account);
	List<Userdetail> getAllAccounts();
	Userdetail getAccountById(String referId);
	void addAccountStatus(CreateAccountStatusdto status);
	//ViewUserDetailsDto userDetails(String accNo);
	ViewUserDetailsDto userDetails(String accountNo);
}

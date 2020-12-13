package com.entity.layer4;



import com.entity.layer1.Admininput;
import com.entity.layer3.AdminCredentialsdto;

public interface AdminService {
	
	void registerAdmin(Admininput admin);
	Admininput adminLogin(AdminCredentialsdto adminCredentials);
	
}

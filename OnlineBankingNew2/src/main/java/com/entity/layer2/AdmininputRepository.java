package com.entity.layer2;



import com.entity.layer1.Admininput;

public interface AdmininputRepository {
	void save(Admininput admininputs);
	Admininput getAdminById(String userId);
	boolean isAdminAvailable(String adminuserid);
	String getAdminByIdAndPassword(String adminuserid, String adminpassword);
	
}


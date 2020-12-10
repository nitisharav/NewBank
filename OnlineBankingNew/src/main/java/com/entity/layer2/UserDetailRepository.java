package com.entity.layer2;

import java.math.BigDecimal;
import java.util.List;

import com.entity.layer1.Userdetail;





public interface UserDetailRepository {
	void save(Userdetail userdetail);
	Userdetail getAccountByAccoutNo(String accountno);
	BigDecimal totalnumberOfAccountPresent();
	String findMaxAccountNumber();
	String findMaxRefId();
	List<Userdetail> getAllRecords();
	String findAccountNoByRefId(String referid);
	void updateAdminApproval(String Approval, String adminremark, String accountno);
	int getBalance(String accountno);
	void updateBalance(String accountno,int balance);
}

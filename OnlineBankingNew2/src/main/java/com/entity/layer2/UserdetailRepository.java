package com.entity.layer2;

import java.math.BigDecimal;
import java.util.List;

import com.entity.layer1.Userdetail;

public interface UserdetailRepository {

//	void save(Userdetail userdetail);
	Userdetail getAccountByAccountNo(String accountno);
	BigDecimal totalnumberOfAccountPresent();
	String findMaxAccountNumber();
	String findMaxRefId();
	List<Userdetail> getAllRecords();
	String findAccountNoByRefId(String referid);
	void updateAdminApproval(String Approval, String adminremark, String accountno);
	int getBalance(String accountno);
	void updateBalance(String accountno,int balance);
	boolean isAccountActive(String acNo);
	boolean isAccountPresent(String userAcNumber, String userAcNumber2);
	void save(Userdetail userdetail);
	
}

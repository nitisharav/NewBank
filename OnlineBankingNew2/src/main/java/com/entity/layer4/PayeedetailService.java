package com.entity.layer4;

import java.util.List;

import com.entity.layer1.Payeedetail;
import com.entity.layer3.PayeedetailDTO;

import com.entity.layer3.viewPayeedetail;



public interface PayeedetailService {
	List<viewPayeedetail> getPayeeNameAndAccNo(String fromAcc);
	public void addPayeedetail(PayeedetailDTO payee) throws Exception;

	

}

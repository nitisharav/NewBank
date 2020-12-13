package com.entity.layer4;

import java.util.List;

import com.entity.layer1.Fundtransfer;
import com.entity.layer3.FundTransferDetailsDto;
import com.entity.layer3.FundTransferDto;

public interface FundTransferservice {
	
	
	
	
	List<Fundtransfer> accountstatement(String accNo);
	List<Fundtransfer> accounthistory(String fromDate,String toDate,String accountnumber);
	
      void Fundtransfer(FundTransferDetailsDto Dto) throws Exception; 
}

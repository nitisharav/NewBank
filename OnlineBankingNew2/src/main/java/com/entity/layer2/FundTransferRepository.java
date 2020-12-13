package com.entity.layer2;

import java.util.List;

import com.entity.layer1.Fundtransfer;


public interface FundTransferRepository {

	
	public List<Fundtransfer> getAll();
	
	void save(Fundtransfer fundtransfe);
	
	public long getAllRecords();
	//public long getTransactionId();

	
	List<Fundtransfer> getAllRecords(String accNumber);
	
	
	List<Fundtransfer> getFundtransferBetweenDates(String fromDate,String toDate,String accountnumber);
	
	boolean isfundtransferPresent();
	
}

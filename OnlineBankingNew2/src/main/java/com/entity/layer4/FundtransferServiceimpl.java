package com.entity.layer4;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.layer1.Fundtransfer;
import com.entity.layer2.FundTransferRepository;
import com.entity.layer2.LoginDetailRepository;
import com.entity.layer2.PayeedetailRepository;
import com.entity.layer2.UserdetailRepository;
import com.entity.layer3.FundTransferDetailsDto;


@Service
public class FundtransferServiceimpl implements FundTransferservice {
	
	@Autowired
	FundTransferRepository f;
	
	@Autowired
	UserdetailRepository u;
	
	@Autowired
	 LoginDetailRepository l;
	
	@Autowired
	PayeedetailRepository p;
	
	

	
	public List<Fundtransfer> accountstatement(String accNo) 
	{
	
	  List<Fundtransfer> tranfer= f.getAllRecords(accNo);
		
		return tranfer;
		 
	}

	
	public List<Fundtransfer> accounthistory(String fromDate,String toDate,String accountnumber) {
		
		List<Fundtransfer> transfer = f.getFundtransferBetweenDates(fromDate,toDate,accountnumber);
		
		return transfer;
		
		//return null;
	}
	
	public void Fundtransfer(FundTransferDetailsDto Dto) throws Exception
	{
		int trnid=1323;
		
		System.out.println("hello1");
		
		Fundtransfer fund=new Fundtransfer();
		
		System.out.println("hello2");
		
		String tnpass=l.getTransactionPassword(Dto.getFromaccno());
		
		System.out.println("hello3");
		
		System.out.println(tnpass);
		
	//	System.out.println(Dto.getTnpass());
		
		String tnpassed=Dto.getTnpass();
		
		System.out.println(tnpassed);
		
		System.out.println("hello4");
		
	//	if(tnpass != tnpassed)
	//	{
			//System.out.println("wrong password");
	//		throw new Exception ("Invalid password");
		
	//	}
		if(!u.isAccountPresent(Dto.getFromaccno(),Dto.getToaccno())) {
			
			throw new Exception("account not present");
			
		}
		
		
			
		
		System.out.println("hello5");
		
		
		if(Dto.getBalance()<=0)
		{
			throw new Exception ("Enter Valid Amount");
		//	System.out.println("enter valid amount");//throw new ServiceException("Benificiary not Found");)
		}
		
		
		
			
		
		
			System.out.println("hello6");
			
			
     WithdrawBalance(Dto.getFromaccno(),Dto.getBalance());
		DepositBalance(Dto.getToaccno(),Dto.getBalance());
		
		System.out.println("hello7");
		
		fund.setFromAccno(Dto.getFromaccno());
		fund.setToAccno(Dto.getToaccno());
		fund.setTransacMode(Dto.getFundmode());
		fund.setAmount(Dto.getBalance());
		
		System.out.println("hello8");
		
	//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	//	LocalDateTime now = LocalDateTime.now();
	//	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
		
	    int a=(int)f.getAllRecords()+1;
	    
	    System.out.println("hello9");
	    
	    
		fund.setTransacDate(date);
		
		//System.out.println(transaction);
		
		if(f.isfundtransferPresent()) {
			
			
			fund.setTransacId(trnid);
		}
		else {
			fund.setTransacId(a+1);
		}
		
		
		f.save(fund);
		
		}
			
	

	
	
	
	public void WithdrawBalance(String fromaccno, int balance) {
		// TODO Auto-generated method stub
		
		
		int curBalance=u.getBalance(fromaccno);
	
		
		if(curBalance<balance) {
		//
			throw new ServiceException("Insufficient Funds");
	
	//	System.out.println("insufficient funds");
		
		}
		
		
		curBalance=curBalance-balance;
		u.updateBalance(fromaccno, curBalance);
		
	}


	
	
	
	public void DepositBalance(String toaccno, int balance) {
		// TODO Auto-generated method stub
		int curBalance=u.getBalance(toaccno);
		curBalance+=balance;
		u.updateBalance(toaccno, curBalance);
	}


	//@Override
	//public void Fundtransfer(FundTransferDetailsDto Dto) {
		// TODO Auto-generated method stub
		
//	}

}

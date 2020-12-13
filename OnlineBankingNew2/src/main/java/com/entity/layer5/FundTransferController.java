package com.entity.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.layer1.Fundtransfer;
import com.entity.layer3.FundTransferDetailsDto;
import com.entity.layer3.FundTransferDto;
import com.entity.layer4.FundTransferservice;
import com.entity.layer6.FundTransferStatus;
import com.entity.layer6.FundTransferStatus.type;


//@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FundTransferController {
	
	
	@Autowired
	FundTransferservice fundtransservice;
	
	
	@PostMapping(path="/fundtransfer")
	public FundTransferStatus Fundtransfer(@RequestBody FundTransferDetailsDto fdtrans)
	{
		
		try
		{
			
			fundtransservice.Fundtransfer(fdtrans);
			
			FundTransferStatus funtra= new FundTransferStatus();
			
			funtra.setStatus(type.successfullycompleted);
			funtra.setMessage("transaction successful");
			
			return funtra;
			
			
			
		}
		catch(Exception e)
		{

			//fundtransservice.Fundtransfer(fdtrans);
			
			FundTransferStatus funtra= new FundTransferStatus();
			
			funtra.setStatus(type.oopstryagain);
			funtra.setMessage("not completed");
			
			return funtra;
			
		}
	}
	
	
//	@GetMapping(path="/miniStatement/{accountNumber}")
//	public List<Transaction> getMiniStatement(@PathVariable(value="accountNumber") String accNumber) {
//		return service.getMiniStatement(accNumber);
		
		@GetMapping(path="/accountstatement/{accno}")
		public List<Fundtransfer> gellAllRecords(@PathVariable(value="accno")String accNo)
		{
			return(fundtransservice.accountstatement(accNo));
			
	}
		
		
		@PostMapping(path="/acounthistory")
		public List<Fundtransfer> accounthistory(@RequestBody FundTransferDto FdTrans)
		{
			
		String frmdate=FdTrans.getFromdate();
		String todate=FdTrans.getTodate();
		String Accno=FdTrans.getAccountNumber();
		return(fundtransservice.accounthistory(frmdate, todate, Accno));
		
		
		}
		
	

}

package com.entity.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.layer1.Payeedetail;
import com.entity.layer3.PayeedetailDTO;
import com.entity.layer3.viewPayeedetail;
import com.entity.layer4.PayeedetailService;
import com.entity.layer4.PayeedetailServiceImpl;
import com.entity.layer6.Status;
import com.entity.layer6.Status.StatusType;




//@CrossOrigin(origins =  "http://localhost:4200")
@RestController
public class PayeedetailController {
	
	@Autowired
	PayeedetailService service;
	
	@GetMapping("/getPayeeNameAndAccountNo/{fromAcc}")
	public List<viewPayeedetail> getName(@PathVariable("fromAcc") String fromAcc) {
		return service.getPayeeNameAndAccNo(fromAcc);
	}
	
	@PostMapping(path = "/addPayee")
	public Status addNewPayee(@RequestBody PayeedetailDTO payee) {
		//System.out.println(payee);
		try {
			service.addPayeedetail(payee);
		
			Status status = new Status();
			status.setMessage("Payee Added");
			status.setStatus(StatusType.SUCCESS);
			return status;
		}
		catch(Exception e) 
		{
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);
			return status;
		}
}
}
package com.entity.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.layer1.Payeedetail;
import com.entity.layer2.PayeedetailRepository;
import com.entity.layer2.UserdetailRepository;
import com.entity.layer3.PayeedetailDTO;
import com.entity.layer3.viewPayeedetail;


@Service
public class PayeedetailServiceImpl implements PayeedetailService {
	
	@Autowired
	PayeedetailRepository repo;
	@Autowired
	UserdetailRepository userRepo;
	

	public List<viewPayeedetail> getPayeeNameAndAccNo(String fromAcc) {
		 return  repo.getPayeedetail(fromAcc);
	}


	@Override
	public void addPayeedetail(PayeedetailDTO payee) throws Exception {
	
		System.out.println(payee.getPayeeAcNumber());
 
		//System.out.println(payee.getPayeeAcNumber());
		//System.out.println(payee.getUserAcNumber());
		System.out.println(userRepo.isAccountActive(payee.getPayeeAcNumber()));
		System.out.println("payee3");
		try {
			if(!userRepo.isAccountActive(payee.getPayeeAcNumber())) 
			{
				throw new Exception("Payee account does not exist");
			}
			else {
				if(userRepo.isAccountPresent(payee.getUserAcNumber(), payee.getPayeeAcNumber()))
				{throw new Exception("Payee account already exist");
				} else {
					if(payee.getPayeeAcNumber().equals(payee.getUserAcNumber())) 
					{
						throw new Exception("Payee account yourself exist");
					} else {
						Payeedetail payeedetails = new Payeedetail();
						
					
						payeedetails.setPayeeaccountnumber(payee.getPayeeAcNumber());
						payeedetails.setPayeename(payee.getPayeename());
						payeedetails.setUseraccountnumber(payee.getUserAcNumber());
						System.out.println("hello4");
					//	System.out.println(payeedetails);
						repo.save(payeedetails);
					}
				}
			}
		}catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println("hello2");
		}
	}
}
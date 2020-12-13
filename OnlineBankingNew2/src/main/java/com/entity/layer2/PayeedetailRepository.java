package com.entity.layer2;

import java.util.List;

import com.entity.layer1.Payeedetail;

import com.entity.layer3.viewPayeedetail;
public interface PayeedetailRepository {
	

	//public List<Payeedetail> getAll();
	//	List<Payeedetail> getAllRecords();

		//void save(Payeedetail payeedetails);
	//public List<Payeedetail> getAll();
			//List<Payeedetail> getAllRecords();

			void save(Payeedetail payeedetails);

			List<viewPayeedetail> getPayeedetail(String fromAcc);

			//boolean isAccountPresent(String userAcNumber, String userAcNumber2);
			

}

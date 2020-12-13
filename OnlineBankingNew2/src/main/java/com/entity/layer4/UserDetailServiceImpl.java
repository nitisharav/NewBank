package com.entity.layer4;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.entity.layer1.Userdetail;
import com.entity.layer2.UserdetailRepository;
import com.entity.layer3.CreateAccountStatusdto;
import com.entity.layer3.ViewUserDetailsDto;



@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserdetailRepository userrepo;
    
	@Override
	public void registerAccount(Userdetail account) {
		// TODO Auto-generated method stub
		String initialAccNumber = "512";
		String initialRefId = "32";
		BigDecimal numOfAccount = userrepo.totalnumberOfAccountPresent();
		String maxAccountNumber = userrepo.findMaxAccountNumber();
		String maxRefId = userrepo.findMaxRefId();
		if(numOfAccount == BigDecimal.ZERO){
			account.setAccountno(initialAccNumber);
			account.setReferenceid(initialRefId);
		}else {
			int updatedMaxAccNo = Integer.parseInt(maxAccountNumber) + 1;
			int updatedRefId = Integer.parseInt(maxRefId) + 1;
			account.setAccountno(Integer.toString(updatedMaxAccNo));
			account.setReferenceid(Integer.toString(updatedRefId));
		}
		userrepo.save(account);
		
	}

	@Override
	public List<Userdetail> getAllAccounts() {
		return userrepo.getAllRecords();
		
	}

	@Override
	public Userdetail getAccountById(String referId) {
		try {
			System.out.println("referenceid is "+referId);
				String accountNo = userrepo.findAccountNoByRefId(referId);
				System.out.println("acc is "+accountNo);
				return userrepo.getAccountByAccountNo(accountNo);
			}
			catch (NullPointerException e) {
				// TODO: handle exception
				throw new ServiceException("Account doesn't exist");
			}
		
	}

	@Override
	public void addAccountStatus(CreateAccountStatusdto status) {
		try {
			System.out.println(status);
			userrepo.updateAdminApproval(status.getApprovedByAdmin(), status.getAdminRemark(), status.getAccountNumber());
		}
		catch (InvalidDataAccessApiUsageException e) {
			throw new ServiceException("Error !!!");
		}
		
	}

	@Override
	public ViewUserDetailsDto userDetails(String accountNo) {
		Userdetail account = userrepo.getAccountByAccountNo(accountNo);
		ViewUserDetailsDto details = new ViewUserDetailsDto();
		
		details.setAadharCard(account.getAdharcard());
		details.setEmail(account.getEmail());
		details.setFirstName(account.getFirstname());
		details.setLastName(account.getLastname());
		details.setMobileNumber(account.getMobileno());
		details.setPresAddress1(account.getPresaddressline1());
		details.setPresAddress2(account.getPresaddressline2());
		details.setPresCity(account.getPrescity());	
		details.setPresState(account.getPresstate());
		details.setPresPincode(account.getPreszipcode());
		details.setPermAddress1(account.getPermaddressline1());
		details.setPresAddress2(account.getPermaddressline2());
		details.setPermCity(account.getPermcity());	
		details.setPermState(account.getPermstate());
		details.setPermPincode(account.getPermzipcode());
		details.setOccupation(account.getOccupationtype());
		details.setAccountBalance(account.getAccountbalance());
		return details;
	}

}

package com.entity;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.layer1.Logindetail;
import com.entity.layer1.Userdetail;
import com.entity.layer2.LoginDetailRepository;
import com.entity.layer2.UserDetailRepository;

@SpringBootTest
class OnlineBankingNewApplicationTests {

	@Autowired
	 UserDetailRepository u;
	@Autowired
	LoginDetailRepository l;
	
	@Test
	void contextLoads() {
		Userdetail user=new Userdetail();
		
		user.setAccountno("1111");
		user.setReferenceid("1011");
		user.setAccountbalance(50001);
		user.setFirstname("Shubham1");
		user.setLastname("Gupta1");
		user.setFathersname("G1");
		user.setDob("15-08-1947");
		user.setMobileno("98765432101");
		user.setEmail("shubham@gmail.com1");
		user.setAdharcard("111111");
		user.setPresaddressline1("Mumbai");
		user.setPresaddressline2("Mumbai");
		user.setPrescity("Mumbai");
		user.setPresstate("Maharashtra");
		user.setPreszipcode("421204");
		user.setPermaddressline1("Mumbai");
		user.setPermaddressline2("Mumbai");
		user.setPermcity("Mumbai");
		user.setPermstate("Maharashtra");
		user.setPermzipcode("421204");
		user.setOccupationtype("Software Engineer");
		user.setSourceofincome("Full Time Job");
		user.setGrossannualincome("8 Lac");
		user.setApprovedbyadmin("Yes");
		user.setAdminremark("verified");
		
		
		
		u.save(user);
		
	}
	
	@Test
	void saveusertest2() {
		Userdetail user=new Userdetail();
		
		user.setAccountno("222");
		user.setReferenceid("202");
		user.setAccountbalance(5000);
		user.setFirstname("Vishal");
		user.setLastname("Dwane");
		user.setFathersname("D");
		user.setDob("15-08-1947");
		user.setMobileno("9876543210");
		user.setEmail("vishal@gmail.com");
		user.setAdharcard("22222");
		user.setPresaddressline1("Dehradun");
		user.setPresaddressline2("Dehradun");
		user.setPrescity("Dehradun");
		user.setPresstate("Uttrakhand");
		user.setPreszipcode("248007");
		user.setPermaddressline1("Dehradun");
		user.setPermaddressline2("Dehradun");
		user.setPermcity("Dehradun");
		user.setPermstate("Uttrakhand");
		user.setPermzipcode("248007");
		user.setOccupationtype("Software Engineer");
		user.setSourceofincome("Full Time Job");
		user.setGrossannualincome("10 Lac");
		user.setApprovedbyadmin("Yes");
		user.setAdminremark("verified");
		
		
		
		u.save(user);
		
	}
	@Test
	void Testgetalluser() {
	//	List<Fund_Transfer1> get= new ArrayList<Fund_Transfer1>();
	
		List<Userdetail> get=u.getAllRecords();
		for(Userdetail as:get)
		{ 
			System.out.println(as.getAccountno());
			System.out.println(as.getReferenceid());
			System.out.println((as.getAccountbalance()));
			System.out.println(as.getFirstname());
			System.out.println(as.getLastname());
			System.out.println(as.getFathersname());
			System.out.println(as.getDob());
			System.out.println(as.getMobileno());
			System.out.println(as.getEmail());
			System.out.println(as.getAdharcard());
			System.out.println(as.getPresaddressline1());
			System.out.println(as.getPresaddressline2());
			System.out.println(as.getPrescity());
			System.out.println(as.getPresstate());
			System.out.println(as.getPreszipcode());
			System.out.println(as.getPermaddressline1());
			System.out.println(as.getPermaddressline2());
			System.out.println(as.getPermcity());
			System.out.println(as.getPermstate());
			System.out.println(as.getPermzipcode());
			System.out.println(as.getAccountbalance());
			System.out.println(as.getApprovedbyadmin());
			System.out.println(as.getAccountbalance());
			System.out.println(as.getAdminremark());
		
			
		}
	}
		@Test
		void userbyAccountnoTest() {
			
			Userdetail f =u.getAccountByAccoutNo("111");
			
			
			{
				System.out.println(f.getAccountno());
				System.out.println(f.getReferenceid());
				System.out.println((f.getAccountbalance()));
				System.out.println(f.getFirstname());
				System.out.println(f.getLastname());
				System.out.println(f.getFathersname());
				System.out.println(f.getDob());
				System.out.println(f.getMobileno());
				System.out.println(f.getEmail());
				System.out.println(f.getAdharcard());
				System.out.println(f.getPresaddressline1());
				System.out.println(f.getPresaddressline2());
				System.out.println(f.getPrescity());
				System.out.println(f.getPresstate());
				System.out.println(f.getPreszipcode());
				System.out.println(f.getPermaddressline1());
				System.out.println(f.getPermaddressline2());
				System.out.println(f.getPermcity());
				System.out.println(f.getPermstate());
				System.out.println(f.getPermzipcode());
				System.out.println(f.getAccountbalance());
				System.out.println(f.getApprovedbyadmin());
				System.out.println(f.getAccountbalance());
				System.out.println(f.getAdminremark());
			}
			
		}
		@Test
		void getaCCOUNTnofromrefreIdTest6() {
			String id = "101";
		String r=	u.findAccountNoByRefId(id);	
			System.out.println(r);
		}
		
		@Test
		void updateUserStatus()
		{
			u.updateAdminApproval("BRejected", "Lack of Doc", "111");
		}
		
		@Test
		void getBalanceTest()
		{
			String acc = "111";
			int r=	u.getBalance(acc)	;
				System.out.println(r);	
		}
		
		
		@Test
		void updateBalance()
		{
			u.updateBalance("111", 6000);
			
		}
		
		@Test
		void totalaccountsTest()
		{
			BigDecimal totalacc=u.totalnumberOfAccountPresent();
			System.out.println(totalacc);
			
			
		}
		
		@Test
		void getmaxAccountTest()
		{
			String maxaccount=u.findMaxAccountNumber();
			System.out.println(maxaccount);
		}
		
		@Test
		void getmaxReferidTest()
		{
			String maxrefid=u.findMaxRefId();
			System.out.println(maxrefid);
		}
		
	
		@Test
		void getallLoginTest()
		{
			List<Logindetail> get=l.getAll();
			for(Logindetail as:get)
			{
				System.out.println(as.getUserid());
			    System.out.println(as.getTransactionPassword());
				System.out.println(as.getLoginPassword());
				System.out.println(as.getNumberofinvalidattempts());
				System.out.println(as.getLastlogin());
				System.out.println(as.getUserdetail2().getAccountno());
			}
		}
		
		
}

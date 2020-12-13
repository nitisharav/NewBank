package com.entity;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.layer1.Admininput;
import com.entity.layer1.Fundtransfer;
import com.entity.layer1.Logindetail;
import com.entity.layer1.Payeedetail;
import com.entity.layer1.Userdetail;
import com.entity.layer2.AdmininputRepository;
import com.entity.layer2.FundTransferRepository;
import com.entity.layer2.LoginDetailRepository;
import com.entity.layer2.PayeedetailRepository;
import com.entity.layer2.UserdetailRepository;

@SpringBootTest
class OnlineBankingNewApplicationTests {
	
	@Autowired
	 UserdetailRepository u;
	
	@Autowired
	FundTransferRepository f;
	
	@Autowired
	LoginDetailRepository l;

	//@Autowired
	//FundTransferRepository a;
	@Autowired
	PayeedetailRepository   p;
	@Autowired
	AdmininputRepository    a;
//	@Autowired
//	LoginRepository   d;

	@Test
	void contextLoads1() {
		
		List<Fundtransfer> x=f.getAllRecords("111");
		
		for(Fundtransfer ab:x)
		{
			System.out.println(ab.getAmount());
		}
		
	}

/*	@Test
	void contextLoads2() {
		List<Payeedetail> get=p.getAllRecords();
		for(Payeedetail pd:get)
		{ 
			System.out.println(pd.getPayeeid());
			System.out.println(pd.getPayeename());
			System.out.println(pd.getUseraccountnumber());
			System.out.println(pd.getPayeeaccountnumber());
					
		}
	}
	*/
	@Test
	void contextLoads3() {
	Payeedetail pd = new Payeedetail();
		
		pd.setPayeeaccountnumber("444");
	//	pd.setPayeeid("105");
		pd.setPayeename("sneha");
		pd.setUseraccountnumber("555");
		
		
		p.save(pd);
		
	}
	@Test
	void contextLoads4() {
	Admininput ai = new Admininput();
		
		ai.setAdminname("awtansh");
		ai.setAdminpassword("Awtansh@2");
		ai.setAdminuserid("2");
		
		a.save(ai);
}
	/*@Test
	void contextLoads5() {
		
		List<Admininput> f =a.getAdminById("2");
		
		for(Admininput ad:f)
		{
			System.out.println(ad.getAdminname());
			System.out.println(ad.getAdminpassword());
			
		}
		
	}*/
/*	@Test
	void contextLoads6() {
		
		List<Admininput> f =a.getAdminByIdAndPassword("2", "Awtansh@2");
		
		for(Admininput ad:f)
		{
			System.out.println(ad.getAdminname());
			
		}
	}
*/
	@Test
	void contextLoads7() {

		l.resetPassword("bbb", "'111'");

	
}
	@Test
	void contextLoads8() {
		
		List<Logindetail> get=l.getUserId();
		
		for(Logindetail ld:get)
		
		{ 
		
			System.out.println(ld.getUserid());
			//System.out.println(ld.getLoginPassword());
		
		}
	}
			
					
		
	/*	@Test
	void contextLoads9() {
	//Userdetail u = new Userdetail();
	//String a ="222";
	
	//List<Logindetail> f =d.getUserByAccNumber(a);
	List<Logindetail> f =d.getAll();
	for(Logindetail ld:f)
	{
		//System.out.println(f.getLastlogin());
		System.out.println(ld.getAccountno().getFirstname());
	}
	}
	
	
	/*	System.out.println(ld.getLoginPassword());
		System.out.println(ld.getTransactionPassword());
		System.out.println(ld.getUserid());
		System.out.println(ld.getNumberofinvalidattempts());
		//System.out.print(ld.get);
		
	

	/*@Test
void contextloads10() {
//	Userdetail u = 10001;
	Logindetail l =d.getUserByAccNumber("111");
	
	
	//{
//		System.out.println(l.getLastlogin());
//		System.out.println(l.getLoginPassword());
//		System.out.println(l.getTransactionPassword());
//		System.out.println(l.getUserid());
//		System.out.println(l.getNumberofinvalidattempts());
		
	//}
	
}*/

	

	@Test
	void contextLoads11() {
		
		List<Fundtransfer> x=f.getAllRecords("111");
		
		for(Fundtransfer ab:x)
		{
			System.out.println(ab.getAmount());
		}
		
	}
	
	@Test
	void contextLoads12() {
		
		List<Fundtransfer> x=f.getFundtransferBetweenDates("22-Nov-00","01-Dec-20","111");
		
		for(Fundtransfer ab:x)
		{
			System.out.println(ab.getAmount());
		}
		
	}
	
	
//1
//	@Test
	//void contextloads13()
//	{
	//	System.out.println("hello");
		//long f=f.getTransactionId();
	//	System.out.println(f); 
	//}
	
	
	@Test
	void contextload14()
	{
	
			Fundtransfer user=new Fundtransfer();
			
			user.setAmount(2000);
			user.setFromAccno("111");
			user.setToAccno("222");
			user.setTransacId(10004);
			
			f.save(user);
			
	}
	
	@Test
	void contextload15()
	{
	
				List<Fundtransfer> get=f.getAll();
			
			for(Fundtransfer as:get)
			{ 
				System.out.println(as.getTransacId());
				System.out.println(as.getToAccno());
				System.out.println(as.getTransacMode());
			
				//System.out.println(as);
			}
		}
//	2
//@Test
//void contextloads16()
//{
	

	//long fd=a.getAllRecords();
	
//	System.out.println(fd);
	

//}

@Test
void contextloads17()
{
	//Userdetail u=new Userdetail();
	//u.setAccountno("11111112");
	
//	Logindetail f=new Logindetail();
//	f.setUserdetail2(u);
//	f.setTransactionPassword("abc#11");
//	f.setLoginPassword("abs@1");
//	f.setUserid("1000091111");
	
//	s.save(f);
}
@Test
void contextloads18()
{

//	insert into login details (userid,login_password,transaction_password) values ('1023','abc@1',.'asd@12')
	
		Userdetail user=new Userdetail();
		Logindetail sd=new Logindetail();
		
	
		user.setAccountno("11m");
		user.setReferenceid("1111111123");
		user.setAccountbalance(6000);
		user.setFirstname("Shubham1");
		user.setLastname("Gupta1");
		user.setFathersname("G1");
		user.setDob("15-08-1947");
		user.setMobileno("9876543210");
		user.setEmail("shubham@gmail.com");
		user.setAdharcard("11111111");
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
	//	user.setApprovedbyadmin("Yes");
	//	user.setAdminremark("verified");
		
		System.out.println("hello");
		
		sd.setUserdetail2(user);
		
		System.out.println("heloo2");
		
		
		sd.setUserid("12w");
		
		System.out.println("hello3");
		
	//	u.save(user);
		l.save(sd);
				
	
}


//@Autowired
//LoginDetailRepository l;

@Test
void contextLoads19() {
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
void contextloads20() {
	
	Userdetail user=new Userdetail();
	
	user.setAccountno("2212");
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
	//user.set
	
	
	u.save(user);
	
}
@Test
void contextloads21() {
//	List<Fund_Transfer1> get= new ArrayList<Fund_Transfer1>();

	List<Userdetail> get=u.getAllRecords();
	for(Userdetail as:get)
	{ 
		System.out.println(as.getAccountno());
		System.out.println(as.getReferenceid());
	//System.out.println((as.getAccountBalance()));
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
	//	System.out.println(as.getAccountbalance());
		System.out.println(as.getApprovedbyadmin());
	//	System.out.println(as.getAccountbalance());
		System.out.println(as.getAdminremark());
	
		//u.getAllRecords(as)
	}
}
/*	@Test
	void contextloads22() {
		
		Userdetail f =u.getAccountByAccoutNo("111");
		
		
		
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
		//	System.out.println(f.getAccountbalance());
			System.out.println(f.getApprovedbyadmin());
		//	System.out.println(f.getAccountbalance());
			System.out.println(f.getAdminremark());
			
			
		
		
	}*/
	@Test
	void contextloads23() {
		String id = "101";
	String r=	u.findAccountNoByRefId(id);	
		System.out.println(r);
	}
	
	@Test
	void contextloads24()
	{
		u.updateAdminApproval("BRejected", "Lack of Doc", "'111'");
	}
	//2
	@Test
	void contextloads25()
	{
		//String acc = "'111'";
		//int r=	u.getBalance("111")	;
			System.out.println(u.getBalance("'111'"));	
	}
	
	
	@Test
	void contextloads26()
	{
		u.updateBalance("'111'",6000);
		
	}
	//3
	//@Test
/*	void contextloads27()
	{
		int totalacc=u.totalnumberOfAccountPresent();
		System.out.println(totalacc);
		
		
	}
	*/
	@Test
	void contextloads28()
	{
		String maxaccount=u.findMaxAccountNumber();
		System.out.println(maxaccount);
	}
	
	@Test
	void contextloads29()
	{
		String maxrefid=u.findMaxRefId();
		System.out.println(maxrefid);
	}
	

	@Test
	void contextloads30()
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
	@Test
	void contextloads31()
	{
		
		List<Fundtransfer> x=f.getAllRecords("111");
		
		for(Fundtransfer ab:x)
		{
			System.out.println(ab.getAmount());
		}
		
	}
//	@Test
//	void contextloads32()
//	{
//		String f= .getUserId();
//		System.out.println (f);
//	}
@Test	
void contextloads33() {
		
		List<Logindetail> g=l.getUserByAccNumber("'222'");
		
		for(Logindetail ac:g)
		{
			System.out.println(ac.getUserid());
		}
}
@Test
void contextloads34()
{
	l.resetPassword("aaa", "'111'");
}

//4 removed single quote "ak###1"
@Test
void contextloads35()
{
	l.resetTransactionPassword("'10001'", "ak###1");
}




@Test
void contextloads36() {
	
	List<Fundtransfer> x=f.getAllRecords("111");
	
	for(Fundtransfer ab:x)
	{
		System.out.println(ab.getAmount());
	}
	
}
/*
@Test
void contextloads37() {
	List<Payeedetail> get=p.getAllRecords();
	for(Payeedetail pd:get)
	{ 
		System.out.println(pd.getPayeeid());
		System.out.println(pd.getPayeename());
		System.out.println(pd.getUseraccountnumber());
		System.out.println(pd.getPayeeaccountnumber());
				
	}
}
*/
@Test
void contextloads38() {
Payeedetail pd = new Payeedetail();
	
	pd.setPayeeaccountnumber("444");
	pd.setPayeeid("105");
	pd.setPayeename("sneha");
	pd.setUseraccountnumber("555");
	
	
	p.save(pd);
	
}

@Test
void contextloads39() {
Admininput ai = new Admininput();
	
	ai.setAdminname("awtansh");
	ai.setAdminpassword("Awtansh@2");
	ai.setAdminuserid("2");
	
	a.save(ai);
}
/*@Test
void contextLoads40() {
	
	List<Admininput> f =a.getAdminById("2");
	
	for(Admininput ad:f)
	{
		System.out.println(ad.getAdminname());
		System.out.println(ad.getAdminpassword());
		
	}
	
}
@Test
void contextLoads41() {
	
	List<Admininput> f =a.getAdminByIdAndPassword("2", "Awtansh@2");
	
	for(Admininput ad:f)
	{
		System.out.println(ad.getAdminname());
		
	}
}
*/
@Test
void contextLoads42() {

	l.resetPassword("bbb", "'111'");

}

@Test
void contextLoads43() {
	List<Logindetail> get=l.getUserId();
	for(Logindetail ld:get)
	{ 
		System.out.println(ld.getUserid());
	}
}
		
				
	}
/*	@Test
void contextLoads7() {
//Userdetail u = new Userdetail();
//String a ="222";

//List<Logindetail> f =d.getUserByAccNumber(a);
List<Logindetail> f =d.getAll();
for(Logindetail ld:f)
{
	//System.out.println(f.getLastlogin());
	System.out.println(ld.getAccountno().getFirstname());
}
}


/*	System.out.println(ld.getLoginPassword());
	System.out.println(ld.getTransactionPassword());
	System.out.println(ld.getUserid());
	System.out.println(ld.getNumberofinvalidattempts());
	//System.out.print(ld.get);
	


/*@Test
void userbyAccountnoTest() {
//Userdetail u = 10001;
Logindetail l =d.getUserByAccNumber("111");


//{
//	System.out.println(l.getLastlogin());
//	System.out.println(l.getLoginPassword());
//	System.out.println(l.getTransactionPassword());
//	System.out.println(l.getUserid());
//	System.out.println(l.getNumberofinvalidattempts());
	
//}

}*/


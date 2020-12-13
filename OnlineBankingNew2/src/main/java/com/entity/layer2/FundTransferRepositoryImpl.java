package com.entity.layer2;

import java.math.BigDecimal;
import java.util.List;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.layer1.Fundtransfer;
//import com.lti.pojo.accNumber;
//import com.lti.pojo.from;
//import com.lti.pojo.select;
//import com.lti.pojo.t;


@Repository
public class FundTransferRepositoryImpl implements FundTransferRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	
    @Transactional
	public void save(Fundtransfer fundtransfe) {
   
    
    		em.persist(fundtransfe);
    		
    	}
    
		
		
		
	

@Transactional
public long getAllRecords() {
		
	//	System.out.println("hello1");
//		Query query = em.createNativeQuery("select max(TRANSAC_ID) from fundtransfer",Fundtransfer.class);
		                                   //  "select max(u.TRANSAC_ID) from fundtransfer u"
		//System.out.println("hello2");
		  Query query = em.createQuery("select max(transacId) from Fundtransfer");
			  long c = (long)query.getSingleResult();
		
			//  System.out.println("hello3");
	//	long sdf=query;		
	//	System.out.println("hello4");
	//	return sdf;
		
		return c;
		//return 0;
	}

	@Transactional
	public List<Fundtransfer> getAllRecords(String accNumber) {
		
		Query query= em.createNativeQuery("select * from fundtransfer t where t.FROM_ACCNO="+accNumber+" or t.TO_ACCNO="+accNumber,
		
				Fundtransfer.class);

				List<Fundtransfer> items = query.getResultList(); 

			//List<fundTransfer> f=query.getResultList();
		                          //  select * from fundtransfer t where t.FROM_ACCNO=111 OR t.TO_ACCNO=111;
		
		
		//("getMiniStatement").setParameter("accNumber",accNumber)
		return items;
	}

	@Transactional
	public List<Fundtransfer> getFundtransferBetweenDates(String fromDate, String toDate, String accountnumber) {
		
		System.out.println(fromDate);
		System.out.println(toDate);
		System.out.println(accountnumber);
		
		
	Query query= em.createNativeQuery("select * from fundtransfer t where (t.FROM_ACCNO="+accountnumber+" or t.TO_ACCNO="+accountnumber+") AND ( t.TRANSAC_DATE between '"+fromDate+"' AND '"+toDate+"')",Fundtransfer.class);
	                           //        select t from fundtransfer t where (t.FROM_ACCNO=:'111' or t.TO_ACCNO='111') and t.TRANSAC_DATE between '20-Nov-00' and '21-Dec-20';
	
	List<Fundtransfer> items = query.getResultList();
			
		return items;
	}


	@Transactional
	public List<Fundtransfer> getAll() {
		String s="from Fundtransfer";
		Query query = em.createQuery(s);
		List<Fundtransfer> Fund_transfer=query.getResultList();
		return Fund_transfer;

		
	}
	@Override
	public boolean isfundtransferPresent() {
		// TODO Auto-generated method stub
		
	//	String s="select count(*) from Fundtransfer";
		Query q=em.createNativeQuery("select count(*) from fundtransfer");
		BigDecimal a=(BigDecimal) q.getSingleResult();
		if(a==BigDecimal.ZERO)
		{
			return true;
			
		}
		else
		{
		return false;	
		}
	
	}
}

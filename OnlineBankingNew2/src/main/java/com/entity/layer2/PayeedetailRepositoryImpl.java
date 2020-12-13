package com.entity.layer2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entity.layer1.Payeedetail;
import com.entity.layer3.viewPayeedetail;


@Repository
public class PayeedetailRepositoryImpl implements PayeedetailRepository{

	



	@PersistenceContext
	EntityManager entityManager;
	
	
	
	@Transactional
	public List<Payeedetail> getAllRecords() {
		
	/*	Query query= em.createNativeQuery("select * from fundtransfer t where t.FROM_ACCNO="+accNumber+" or t.TO_ACCNO="+accNumber,
			Fundtransfer.class);
		List<Payeedetail> f=query.getResultList();
        //  select * from fundtransfer t where t.FROM_ACCNO=111 OR t.TO_ACCNO=111;
		return em.createNamedQuery("getMiniStatement").setParameter("accNumber",accNumber).getResultList();

		List<viewBeneficiary> beneficiaryList = entityManager.createNamedQuery("getNameAndAccountNumber")
				.setParameter("acno", accNo).getResultList();
		return beneficiaryList;*/
		

				Query q = entityManager.createNativeQuery("select * from Payeedetails ", Payeedetail.class);
				List<Payeedetail> f = q.getResultList();
				return f;
	}
				

	
	/*@Transactional
	public List<Payeedetail> getAll() {
		
		String s="from Payeedetail";
		Query query = entityManager.createQuery(s);
		List<Payeedetail> payeedetail =query.getResultList();
		return payeedetail;
	}*/
	@Transactional
	public void save(Payeedetail payeedetail) {
		entityManager.persist(payeedetail);
	}



	@Override
	public List<viewPayeedetail> getPayeedetail(String accNo) {
		//return PayeeList;
		Query q = entityManager.createNativeQuery("select * from Payeedetails where useraccountnumber="+accNo, Payeedetail.class );
		List<viewPayeedetail> f =q.getResultList();
		return f;
	}


}





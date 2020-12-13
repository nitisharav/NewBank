package com.entity.layer2;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.layer1.Userdetail;

@Repository
public class UserDetailRepositoryImpl implements UserdetailRepository {
	
@PersistenceContext
private EntityManager em;


	@Transactional
	public void save(Userdetail userdetail) {
		em.persist(userdetail);
		
	}

	

/*	@Override
	@Transactional
	public void save(Userdetail userdetail) {
		entityManager.persist(userdetail);
		
	}
*/
	@Override
	public Userdetail getAccountByAccountNo(String accountno) {
		return em.find(Userdetail.class, accountno);
	
	}

	@Override
	public List<Userdetail> getAllRecords() {
		Query query= em.createNativeQuery("select * from  Userdetails", Userdetail.class);
		
		 List<Userdetail> user= query.getResultList();
		return user;
	}

	@Override
	public String findAccountNoByRefId(String referid) {
		//Query query= entityManager.createNativeQuery("select AccountNo from  Userdetails where ReferenceId="+referid, Userdetail.class);
		//Query query= entityManager.createNativeQuery("select AccountNo from  Userdetails where ReferenceId="+referid, Userdetail.class);
		//Userdetail acc = (Userdetail)query.getSingleResult();
	
		//return acc.toString();
		
		String query = "select accountno from Userdetail where referenceid=:x";
		Query  q = (Query) this.em.createQuery(query);
		q.setParameter("x", referid);
		String r= (String) q.getSingleResult();
		return r;
	}
    
	
	@Transactional
	public void updateAdminApproval(String Approval, String adminremark, String accountno) {
		// TODO Auto-generated method stub
		//System.out.println(Approval+" "+adminremark+" "+accountno);
	//	entityManager.createNamedQuery("updateAccountStatusByAdmin")
	//	.setParameter("status", Approval)
		//.setParameter("remark", adminremark)
	//	.setParameter("acc", accountno)
		//.executeUpdate();
		//System.out.println(Approval);
		//System.out.println(adminremark);
		//System.out.println(accountno);
		
		Query query = em.createNativeQuery("update Userdetails set approvedByAdmin ='"+Approval+"',adminRemark = '"+adminremark+"' where accountno ="+accountno,Userdetail.class);
		query.executeUpdate();

	}

	@Transactional
	public int getBalance(String accountno) {
		
		
	//	  Query query = em.createQuery("select max(transacId) from Fundtransfer");
		//  long c = (long)query.getSingleResult();
		//String query = "select accountBalance from Userdetail where accountno=:x";
		Query  q = em.createNativeQuery("select u.ACCOUNTBALANCE from Userdetails u where u.accountno="+accountno);//(Query) this.em.createQuery(query);
	//	q.setParameter("x", accountno);
		int r= (int) q.getSingleResult();
		return r;
		
	}

	
	@Transactional
	public void updateBalance(String accountno, int balance) {
		Query query = em.createNativeQuery("update Userdetails set accountbalance ="+balance+" where accountno ="+accountno,Userdetail.class);
		query.executeUpdate();
		

		
	}

	@Transactional
	public BigDecimal totalnumberOfAccountPresent() {
		//return (Long) entityManager.createNamedQuery("countTotalAccounts")
		//.getSingleResult();
		//select count(*) from OpenAccount t
		//String query = "select count(*) from Userdetail";
		//Query  q = (Query) this.entityManager.createQuery(query);
		BigDecimal v= (BigDecimal) em.createNativeQuery("select count(*) from Userdetails").getSingleResult();
		
		return(v);
	}

	@Override
	public String findMaxAccountNumber() {
		return (String)em.createNativeQuery("select max(accountno) from Userdetails").getSingleResult();
		
	}

	@Override
	public String findMaxRefId() {
		return (String) em.createNativeQuery("select max(referenceid) from Userdetails").getSingleResult();

	}
	@Override
	public boolean isAccountActive(String acNo) {
		Query q = em.createNativeQuery("Select count(*) from userdetails where accountno='"+acNo+"'");
		BigDecimal a = (BigDecimal)q.getSingleResult();
		System.out.println("hello1.1");
		if(a==(BigDecimal.ZERO)  )
			
			return false;
		//	System.out.println("hello1.2");
		else 
			return true;
		
	}
	public boolean isAccountPresent(String fromAcc, String toAcc) {
		Query q = em.createNativeQuery("select count(*) from Payeedetails where useraccountnumber='"+fromAcc+"'and payeeaccountnumber='"+toAcc+"'");
		BigDecimal a = (BigDecimal)q.getSingleResult();
		if(a==(BigDecimal.ZERO))
			return false;
		else 
			return true;	
		}	






	
	
	
	/*Query query = entityManager.createNativeQuery(
    "SELECT * FROM items WHERE initialPrice > 10000", Item.class);
List<Item> items = query.getResultList();
for (Item item : items)
System.out.println(item);
*/

}



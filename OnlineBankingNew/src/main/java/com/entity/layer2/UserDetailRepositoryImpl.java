package com.entity.layer2;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entity.layer1.Userdetail;


@Repository
public class UserDetailRepositoryImpl implements UserDetailRepository {
	
	@PersistenceContext
	EntityManager entityManager;


	@Override
	@Transactional
	public void save(Userdetail userdetail) {
		entityManager.persist(userdetail);
		
	}

	@Override
	public Userdetail getAccountByAccoutNo(String accountno) {
		return entityManager.find(Userdetail.class, accountno);
	
	}

	@Override
	public List<Userdetail> getAllRecords() {
		Query query= entityManager.createNativeQuery("select * from  Userdetails", Userdetail.class);
		
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
		Query  q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", referid);
		String r= (String) q.getSingleResult();
		return r;
	}
    
	@Override
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
		
		Query query = entityManager.createNativeQuery("update Userdetails set approvedByAdmin ='"+Approval+"',adminRemark = '"+adminremark+"' where accountno ="+accountno,Userdetail.class);
		query.executeUpdate();

	}

	@Override
	public int getBalance(String accountno) {
		
		String query = "select accountbalance from Userdetail where accountno=:x";
		Query  q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", accountno);
		int r= (int) q.getSingleResult();
		return r;
		
	}

	@Override
	@Transactional
	public void updateBalance(String accountno, int balance) {
		Query query = entityManager.createNativeQuery("update Userdetails set accountbalance ='"+balance+"' where accountno ="+accountno,Userdetail.class);
		query.executeUpdate();
		

		
	}

	@Override
	public BigDecimal totalnumberOfAccountPresent() {
		//return (Long) entityManager.createNamedQuery("countTotalAccounts")
		//.getSingleResult();
		//select count(*) from OpenAccount t
		//String query = "select count(*) from Userdetail";
		//Query  q = (Query) this.entityManager.createQuery(query);
		return (BigDecimal) entityManager.createNativeQuery("select count(*) from Userdetails").getSingleResult();
	}

	@Override
	public String findMaxAccountNumber() {
		return (String) entityManager.createNativeQuery("select max(accountno) from Userdetails").getSingleResult();
		
	}

	@Override
	public String findMaxRefId() {
		return (String) entityManager.createNativeQuery("select max(referenceid) from Userdetails").getSingleResult();

	}
	
	
	/*Query query = entityManager.createNativeQuery(
    "SELECT * FROM items WHERE initialPrice > 10000", Item.class);
List<Item> items = query.getResultList();
for (Item item : items)
System.out.println(item);
*/

}

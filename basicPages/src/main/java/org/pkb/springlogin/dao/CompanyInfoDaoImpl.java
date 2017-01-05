package org.pkb.springlogin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.pkb.springlogin.entity.AddressEntity;
import org.pkb.springlogin.entity.CompanyEntity;
import org.pkb.springlogin.entity.UserRole;
import org.pkb.springlogin.model.CompanyRegVO;
import org.pkb.springlogin.util.HibernateUtil;
import org.pkb.springlogin.util.ServiceUtil;
import org.springframework.stereotype.Repository;

@Repository("companyInfoDao")

public class CompanyInfoDaoImpl implements CompanyInfoDao {
	SessionFactory sessionFacotry=HibernateUtil.getSessionFactory();
	

	public CompanyRegVO findUserInfo(String username) {
		
		return null;
	}

	public List<String> getUserRoles(String username) {
		Session session=sessionFacotry.openSession();
		Criteria cr=session.createCriteria(UserRole.class);
		cr.add(Restrictions.eq("username", username));
		cr.setProjection(Projections.property("user_role"));
		List<String> list=cr.list();
		session.close();
		
		return list;
	}

	public boolean isExistingUser(String email) {
		Session session=sessionFacotry.openSession();
		Criteria cr=session.createCriteria(CompanyEntity.class);
		cr.add(Restrictions.eq("email", email));
		if(cr.list()==null || cr.list().isEmpty() ){
			return true;
		};
		return false;
	}

	public Integer saveUserInfo(CompanyRegVO user) {
		Session session=sessionFacotry.openSession();
		Transaction tx=session.beginTransaction();
		CompanyEntity comp=new CompanyEntity();
		AddressEntity address=new AddressEntity();
		UserRole userRole=new UserRole();
		/*address.setCountry(user.getAddress().getCountry());
		address.setLine1(user.getAddress().getLine1());
		address.setLine2(user.getAddress().getLine2());
		address.setState(user.getAddress().getState());
		address.setZipCode(user.getAddress().getZipCode());*/
		session.persist(address);
		comp.setAcitve(false);
		comp.setAddress(address);
		comp.setDob(ServiceUtil.stringToDateConverter(user.getDob()));
		comp.setEmail(user.getEmail());
		comp.setPassword(user.getPassword());
		comp.setName(user.getCompanyName());
		comp.setRegNumber(user.getRegNumber());
		session.save(comp);
		userRole.setCompany(comp);
		userRole.setUserRole(user.getType());
		session.persist(userRole);
		tx.commit();
		session.close();
		return comp.getRegId();
	}

	public void setVerificationData(Integer id, String verificationToken) {
		
		
	}

	public Integer getUserId(String verificationValue) {
		
		return null;
	}

	public void enableUser(Integer id) {
		
		
	}

}

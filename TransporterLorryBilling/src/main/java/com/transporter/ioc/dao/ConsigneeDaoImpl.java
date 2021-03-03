package com.transporter.ioc.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporter.ioc.domain.Consignee;


@Repository("consigneeDao")
public class ConsigneeDaoImpl implements ConsigneeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addConsignee(Consignee consignee) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(consignee);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Consignee> getConsigneeList(long shipperId) {
		String query = "from Consignee c where c.shipperId = :shipperId";

		try {
			return sessionFactory.getCurrentSession().createQuery(query).setParameter("shipperId", shipperId).list();

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			
			return null;
		}
	}

	public Consignee getConsignee(long consigneeId) {
		try {
			return (Consignee) sessionFactory.getCurrentSession().get(Consignee.class, consigneeId);

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Consignee> getAllConsigneeList() {
		try {
			return sessionFactory.getCurrentSession().createCriteria(Consignee.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			
			return null;
		}
	}

}

package com.transporter.ioc.dao;

import com.transporter.ioc.domain.Receipt;

	import java.io.PrintWriter;
	import java.io.StringWriter;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	

	@Repository("ReceiptDao")
	public class ReceiptDaoImpl implements ReceiptDao {
		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public int addReceipt(Receipt Receipt) {
			try {
				return (int) sessionFactory.getCurrentSession().save(Receipt);

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
			}
			return 0;
		}

		@Override
		public boolean updateReceipt(Receipt Receipt) {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(Receipt);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return false;
			}
		}

	}




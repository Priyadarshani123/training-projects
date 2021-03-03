package com.transporter.ioc.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporter.ioc.domain.Shipper;

	@Repository("shipperDao")
	public class ShipperDaoImpl implements ShipperDao {
		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public boolean addShipper(Shipper shipper) {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(shipper);
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				

				return false;
			}
		}

		@SuppressWarnings({ "unchecked", "deprecation" })
		@Override
		public List<Shipper> getShipperList() {
			try {
				return sessionFactory.getCurrentSession().createCriteria(Shipper.class).list();

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
			
				return null;
			}
		}

		@Override
		public Shipper getShipper(long shipperId) {
			try {
				return (Shipper) sessionFactory.getCurrentSession().get(Shipper.class, shipperId);

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return null;
			}
		}

	}




package com.transporter.ioc.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporter.ioc.domain.Load;

	
	@Repository("loadDao")
	public class LoadDaoImpl implements LoadDao {
		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public boolean addLoad(Load load) {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(load);
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				

				return false;
			}
		}
		@Override
		public Load getLoad(Long loadId) {
			try {
				return (Load) sessionFactory.getCurrentSession().get(Load.class, loadId);

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				

				return null;
			}
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<Load> getUnAssignedLoads() {
			String query = "from Load l where l.tripId = 0 or l.status = :status";

			try {

				return sessionFactory.getCurrentSession().createQuery(query).setParameter("status", "Created").list();

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				

				return null;
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Load> getAssignedLoads() {
			String query = "from Load l where l.tripId != 0 or l.status != :status";

			try {

				return sessionFactory.getCurrentSession().createQuery(query).setParameter("status", "Created").list();

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return null;
			}
		}

	}




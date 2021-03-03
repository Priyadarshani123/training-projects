package com.transporter.ioc.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporter.ioc.domain.Location;
import com.transporter.ioc.domain.States;


	@Repository("locationDao")
	public class LocationDaoImpl implements LocationDao {

		@Autowired
		private SessionFactory sessionFactory;
		
		public String addLocation(Location location) {

			try {
				if (location != null)
					sessionFactory.getCurrentSession().saveOrUpdate(location);

				return "done";
			} catch (Exception e) {
				e.printStackTrace();
				
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				

				return "fail";
			}
		}

		@SuppressWarnings({ "unchecked", "deprecation" })
		public List<Location> listLocations() {
			try {

				
				return (List<Location>) sessionFactory.getCurrentSession().createCriteria(Location.class).list();
			} catch (Exception e) {

				
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return null;
			}
		}

		public Location getLocation(String locationId) {
			try {
				
				return (Location) sessionFactory.getCurrentSession().get(Location.class, locationId);
			} catch (Exception e) {

				
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return null;
			}
		}

		@Override
		public boolean addStates(States states) {
			
			try {
				if (states != null)
					sessionFactory.getCurrentSession().saveOrUpdate(states);

				return true;
			} catch (Exception e) {
			
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				

				return false;
			}
		}

		@SuppressWarnings({ "unchecked", "deprecation" })
		@Override
		public List<States> listStates() {
			try {

				return (List<States>) sessionFactory.getCurrentSession().createCriteria(States.class).list();
			} catch (Exception e) {

				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				return null;
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Location> getLocationInState(long stateId) {
			String query = "from Location l where l.stateId = :stateId";

			try {
				return sessionFactory.getCurrentSession().createQuery(query).setParameter("stateId", stateId).list();

			} catch (Exception e) {
				e.printStackTrace();
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				

				return null;
			}
		}

	}

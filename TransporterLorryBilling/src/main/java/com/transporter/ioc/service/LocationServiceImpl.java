package com.transporter.ioc.service;

import java.util.List;

import com.transporter.ioc.dao.LocationDao;
import com.transporter.ioc.domain.Location;
import com.transporter.ioc.domain.States;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	
	@Service("locationService")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public class LocationServiceImpl implements LocationService {

		@Autowired
		private LocationDao locationDao;

		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public String addLocation(Location location) {
			return locationDao.addLocation(location);
			
		}

		public List<Location> listLocations() {
			return locationDao.listLocations();
		}

		public Location getLocation(String locationId) {
			return locationDao.getLocation(locationId);
		}

		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public boolean addStates(States states) {
			return locationDao.addStates(states);
		}

		@Override
		public List<States> listStates() {
			return locationDao.listStates();
		}

		@Override
		public List<Location> getLocationInState(long stateId) {
			return locationDao.getLocationInState(stateId);
		}

	}

	
package com.transporter.ioc.service;

	import java.util.List;

import com.transporter.ioc.domain.Location;
import com.transporter.ioc.domain.States;
	
	public interface LocationService {
		public String addLocation(Location location);

		public List<Location> listLocations();
		
		public List<Location> getLocationInState(long stateId);

		public Location getLocation(String locationId);

		public boolean addStates(States states);

		public List<States> listStates();

	}



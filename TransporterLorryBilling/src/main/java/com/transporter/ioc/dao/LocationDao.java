package com.transporter.ioc.dao;

	import java.util.List;

import com.transporter.ioc.domain.Location;
import com.transporter.ioc.domain.States;

	public interface LocationDao {

		public String addLocation(Location location);

		public List<Location> listLocations();

		List<Location> getLocationInState(long stateId);

		public Location getLocation(String locationId);

		public boolean addStates(States states);

		public List<States> listStates();

}

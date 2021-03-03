package com.transporter.ioc.service;

	import java.util.List;

import com.transporter.ioc.domain.Shipper;

	public interface ShipperService {
		public boolean addShipper(Shipper shipper);

		public List<Shipper> getShipperList();

		public Shipper getShipper(long shipperId);
	}



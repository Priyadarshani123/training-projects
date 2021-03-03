package com.transporter.ioc.service;

import java.util.List;

import com.transporter.ioc.dao.ShipperDao;
import com.transporter.ioc.domain.Shipper;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	
	@Service("shipperService")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public class ShipperServiceImpl implements ShipperService {
		@Autowired
		ShipperDao shipperDao;

		@Override
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public boolean addShipper(Shipper shipper) {
			return shipperDao.addShipper(shipper);
		}

		@Override
		public List<Shipper> getShipperList() {
			return shipperDao.getShipperList();
		}

		@Override
		public Shipper getShipper(long shipperId) {
			return shipperDao.getShipper(shipperId);
		}

	}




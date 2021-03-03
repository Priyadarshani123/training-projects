package com.transporter.ioc.service;

import com.transporter.ioc.domain.Receipt;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	
	@Service("ReceiptService")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public class ReceiptServiceImpl implements ReceiptService {

		@Autowired
		com.transporter.ioc.dao.ReceiptDao ReceiptDao;

		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public int addReceipt(Receipt Receipt) {
			return ReceiptDao.addReceipt(Receipt);
		}

		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public boolean updateReceipt(Receipt Receipt) {
			return ReceiptDao.updateReceipt(Receipt);
		}

		@Override
		public Long addLorryReceipt(Receipt Receipt) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean updateLorryReceipt(Receipt Receipt) {
			// TODO Auto-generated method stub
			return false;
		}

	

	}




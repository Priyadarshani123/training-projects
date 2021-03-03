package com.transporter.ioc.dao;

import com.transporter.ioc.domain.Receipt;

public interface ReceiptDao {
	
		public int addReceipt(Receipt Receipt);
		public boolean updateReceipt(Receipt Receipt);
}

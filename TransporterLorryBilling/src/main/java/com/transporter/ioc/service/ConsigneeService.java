package com.transporter.ioc.service;

	import java.util.List;

import com.transporter.ioc.domain.Consignee;

	public interface ConsigneeService {
		public boolean addConsignee(Consignee consignee);
		public List<Consignee> getConsigneeList(long shipperId);
		public List<Consignee> getAllConsigneeList();
		public Consignee getConsignee(long consigneeId);
		public boolean deleteConsignee(long consigneeId);
	}



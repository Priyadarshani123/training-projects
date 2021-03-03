package com.transporter.ioc.service;

import com.transporter.ioc.dao.ConsigneeDao;
import com.transporter.ioc.domain.Consignee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("consigneeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public  class ConsigneeServiceImpl implements ConsigneeService {
	@Autowired
	ConsigneeDao consigneeDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addConsignee(Consignee consignee) {
		return ConsigneeDao.addConsignee(consignee);
	}

	public List<Consignee> getConsigneeList(long shipperId) {
		return ConsigneeDao.getConsigneeList(shipperId);
	}

	@Override
	public Consignee getConsignee(long consigneeId) {
		return ConsigneeDao.getConsignee(consigneeId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean deleteConsignee(long consigneeId) {
		return ConsigneeDao.deleteConsignee(consigneeId);
	}

	@Override
	public List<Consignee> getAllConsigneeList() {
		return ConsigneeDao.getAllConsigneeList();
	}

}


	
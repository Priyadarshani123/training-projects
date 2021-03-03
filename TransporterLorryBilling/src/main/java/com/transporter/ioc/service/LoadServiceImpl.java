package com.transporter.ioc.service;

import java.util.List;

import com.transporter.ioc.dao.LoadDao;
import com.transporter.ioc.domain.Load;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;

	
	@Service("loadService")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public class LoadServiceImpl implements LoadService {
		@Autowired
		LoadDao loadDao;

		@Override
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public boolean addLoad(Load load) {
			return loadDao.addLoad(load);
		}

		@Override
		public List<Load> getUnAssignedLoads() {
			return loadDao.getUnAssignedLoads();
		}

		@Override
		public List<Load> getAssignedLoads() {
			return loadDao.getAssignedLoads();
		}

		@Override
		public Load getLoad(Long loadId) {
			return loadDao.getLoad(loadId);
		}

	}




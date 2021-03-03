package com.transporter.ioc.service;

	import java.util.List;

import com.transporter.ioc.domain.Load;

	public interface LoadService {
		public boolean addLoad(Load load);
		public Load getLoad(Long loadId);
		public List<Load> getUnAssignedLoads();
		public List<Load> getAssignedLoads();
		
	}



package com.transporter.ioc.dao;

	import java.util.List;

import com.transporter.ioc.domain.Load;

	public interface LoadDao {
		
		public boolean addLoad(Load load);
		public Load getLoad(Long loadId);
		public List<Load> getUnAssignedLoads();
		public List<Load> getAssignedLoads();


}

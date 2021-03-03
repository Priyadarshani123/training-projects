package com.transporter.ioc.dao;

	import java.util.List;
import com.transporter.ioc.domain.Shipper;

	public interface ShipperDao {

		public boolean addShipper(Shipper shipper);

		public List<Shipper> getShipperList();

		public Shipper getShipper(long shipperId);

}

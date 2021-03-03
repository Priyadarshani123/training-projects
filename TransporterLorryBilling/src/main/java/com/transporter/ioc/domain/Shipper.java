package com.transporter.ioc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Shipper  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long shipperId;

	@Column(name = "shipper_name")
	private String shipperName;

	@Column(name = "shipper_owner_name")
	private String shipperOwnerName;

	@Column(name = "shipper_address")
	private String shipperAddress;

	@Column(name = "shipper_state")
	private long shipperStateId;

	@Column(name = "shipper_city")
	private long shipperCityId;

	@Column(name = "shipper_pincode")
	private String shipperPincode;

	@Column(name = "shipper_phone_no")
	private String shipperPhoneNo;

	@Column(name = "shipper_emailid")
	private String shipperEmailId;

	@Column(name = "shipper_panno")
	private String shipperPanNo;

	@Column(name = "shipper_gstno")
	private String shipperGstNo;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipper_state", referencedColumnName = "id", insertable = false, updatable = false)
	private States states;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipper_city", referencedColumnName = "id", insertable = false, updatable = false)
	private Location location;

	public Long getShipperId() {
		return shipperId;
	}

	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getShipperOwnerName() {
		return shipperOwnerName;
	}

	public void setShipperOwnerName(String shipperOwnerName) {
		this.shipperOwnerName = shipperOwnerName;
	}

	public String getShipperAddress() {
		return shipperAddress;
	}

	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}

	public long getShipperStateId() {
		return shipperStateId;
	}

	public void setShipperStateId(long shipperStateId) {
		this.shipperStateId = shipperStateId;
	}

	public long getShipperCityId() {
		return shipperCityId;
	}

	public void setShipperCityId(long shipperCityId) {
		this.shipperCityId = shipperCityId;
	}

	public String getShipperPincode() {
		return shipperPincode;
	}

	public void setShipperPincode(String shipperPincode) {
		this.shipperPincode = shipperPincode;
	}

	public String getShipperPhoneNo() {
		return shipperPhoneNo;
	}

	public void setShipperPhoneNo(String shipperPhoneNo) {
		this.shipperPhoneNo = shipperPhoneNo;
	}

	public String getShipperEmailId() {
		return shipperEmailId;
	}

	public void setShipperEmailId(String shipperEmailId) {
		this.shipperEmailId = shipperEmailId;
	}

	public String getShipperPanNo() {
		return shipperPanNo;
	}

	public void setShipperPanNo(String shipperPanNo) {
		this.shipperPanNo = shipperPanNo;
	}

	public String getShipperGstNo() {
		return shipperGstNo;
	}

	public void setShipperGstNo(String shipperGstNo) {
		this.shipperGstNo = shipperGstNo;
	}

	public States getStates() {
		return states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}



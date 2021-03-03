package com.transporter.ioc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Consignee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long consigneeId;

	@Column(name = "shipper_id")
	private long shipperId;

	@Column(name = "consignee_name")
	private String consigneeName;

	@Column(name = "consignee_state")
	private long consigneeStateId;

	@Column(name = "consignee_city")
	private long consigneeCityId;

	@Column(name = "consignee_address")
	private String consigneeAddress;

	@Column(name = "consignee_pincode")
	private String consigneePincode;

	@Column(name = "consignee_phone_no")
	private String consigneePhoneNo;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consignee_state", referencedColumnName = "id", insertable = false, updatable = false)
	private States states;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consignee_city", referencedColumnName = "id", insertable = false, updatable = false)
	private Location location;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipper_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Shipper shipper;

	public long getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(long consigneeId) {
		this.consigneeId = consigneeId;
	}

	public long getShipperId() {
		return shipperId;
	}

	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public long getConsigneeStateId() {
		return consigneeStateId;
	}

	public void setConsigneeStateId(long consigneeStateId) {
		this.consigneeStateId = consigneeStateId;
	}

	public long getConsigneeCityId() {
		return consigneeCityId;
	}

	public void setConsigneeCityId(long consigneeCityId) {
		this.consigneeCityId = consigneeCityId;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneePincode() {
		return consigneePincode;
	}

	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
	}

	public String getConsigneePhoneNo() {
		return consigneePhoneNo;
	}

	public void setConsigneePhoneNo(String consigneePhoneNo) {
		this.consigneePhoneNo = consigneePhoneNo;
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

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

}


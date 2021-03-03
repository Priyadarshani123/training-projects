package com.transporter.ioc.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "load_details")
public class Load implements Serializable {
	private static final long serialVersionUID = -677169409842302561L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long loadId;
	// fields related to pickup address
	@Column(name = "shipper_id")
	private long shipperId;

	@Column(name = "pickup_address")
	private String pickUpAddress;

	@Column(name = "pickup_state_id")
	private long pickUpStateId;

	@Column(name = "pickup_city_id")
	private long pickUpCityId;

	@Column(name = "pickup_pincode")
	private String pickUpPinCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pickup_dte")
	private Date pickUpDate;

	@Column(name = "pickup_instruction")
	private String pickUpInstructions;

	@Column(name = "load_weight")
	private String loadWeight;

	@Column(name = "load_weight_unit")
	private String loadWeightUnit;

	@Column(name = "load_quantity")
	private String loadQuantity;

	@Column(name = "load_quantity_unit")
	private String quantityUnit;

	@Column(name = "notes")
	private String notes;

	@Column(name = "commodity")
	private String commodity;
	// fields related to delivery location

	@Column(name = "consignee_id")
	private long consigneeId;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "delivery_state_id")
	private long deliveryStateId;

	@Column(name = "delivery_city_id")
	private long deliveryCityId;

	@Column(name = "delivery_pincode")
	private String deliveryPinCode;
	
	@Column(name = "load_type")
	private String type;//partial or full, partial load will have multiple pickup locations
	

	@Temporal(TemporalType.DATE)
	@Column(name = "delivery_dte")
	private Date deliveryDate;

	@Column(name = "delivery_instruction")
	private String deliveryInstrutions;
	// legal disclaimer if any
	@Column(name = "legal_disclaimer")
	private String legalDisclaimer;
	
	@Column(name = "trip_id")
	private long tripId = 0;
	
	@Column(name = "load_status")
	private String status = "Created"; //created, Trip Assigned, In Transit, Delivered, Invoiced
	
	@Column(name = "lr_available")
	private String lrAvailable = "N";
	
	@Column(name = "is_invoiced")
	private String invoiced = "N";
			
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "delivery_state_id", referencedColumnName = "id", insertable = false, updatable = false)
	private States deliveryState;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "delivery_city_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Location deliveryCity;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipper_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Shipper shipper;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pickup_state_id", referencedColumnName = "id", insertable = false, updatable = false)
	private States pickUpState;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pickup_city_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Location pickUpCity;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consignee_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Consignee consignee;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "load")	
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<PackageDetails> packages;

	public long getLoadId() {
		return loadId;
	}

	public void setLoadId(long loadId) {
		this.loadId = loadId;
	}

	public long getShipperId() {
		return shipperId;
	}

	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}

	public String getPickUpAddress() {
		return pickUpAddress;
	}

	public void setPickUpAddress(String pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}

	public long getPickUpStateId() {
		return pickUpStateId;
	}

	public void setPickUpStateId(long pickUpStateId) {
		this.pickUpStateId = pickUpStateId;
	}

	public long getPickUpCityId() {
		return pickUpCityId;
	}

	public void setPickUpCityId(long pickUpCityId) {
		this.pickUpCityId = pickUpCityId;
	}

	public String getPickUpPinCode() {
		return pickUpPinCode;
	}

	public void setPickUpPinCode(String pickUpPinCode) {
		this.pickUpPinCode = pickUpPinCode;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public String getPickUpInstructions() {
		return pickUpInstructions;
	}

	public void setPickUpInstructions(String pickUpInstructions) {
		this.pickUpInstructions = pickUpInstructions;
	}

	public String getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(String loadWeight) {
		this.loadWeight = loadWeight;
	}

	public String getLoadWeightUnit() {
		return loadWeightUnit;
	}

	public void setLoadWeightUnit(String loadWeightUnit) {
		this.loadWeightUnit = loadWeightUnit;
	}

	public String getLoadQuantity() {
		return loadQuantity;
	}

	public void setLoadQuantity(String loadQuantity) {
		this.loadQuantity = loadQuantity;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public long getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(long consigneeId) {
		this.consigneeId = consigneeId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public long getDeliveryStateId() {
		return deliveryStateId;
	}

	public void setDeliveryStateId(long deliveryStateId) {
		this.deliveryStateId = deliveryStateId;
	}

	public long getDeliveryCityId() {
		return deliveryCityId;
	}

	public void setDeliveryCityId(long deliveryCityId) {
		this.deliveryCityId = deliveryCityId;
	}

	public String getDeliveryPinCode() {
		return deliveryPinCode;
	}

	public void setDeliveryPinCode(String deliveryPinCode) {
		this.deliveryPinCode = deliveryPinCode;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryInstrutions() {
		return deliveryInstrutions;
	}

	public void setDeliveryInstrutions(String deliveryInstrutions) {
		this.deliveryInstrutions = deliveryInstrutions;
	}

	public String getLegalDisclaimer() {
		return legalDisclaimer;
	}

	public void setLegalDisclaimer(String legalDisclaimer) {
		this.legalDisclaimer = legalDisclaimer;
	}

	public States getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(States deliveryState) {
		this.deliveryState = deliveryState;
	}

	public Location getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(Location deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public States getPickUpState() {
		return pickUpState;
	}

	public void setPickUpState(States pickUpState) {
		this.pickUpState = pickUpState;
	}

	public Location getPickUpCity() {
		return pickUpCity;
	}

	public void setPickUpCity(Location pickUpCity) {
		this.pickUpCity = pickUpCity;
	}

	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public long getTripId() {
		return tripId;
	}

	public void setTripId(long tripId) {
		this.tripId = tripId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Set<PackageDetails> getPackages() {
		return packages;
	}

	public void setPackages(Set<PackageDetails> packages) {
		this.packages = packages;
	}

	public String getLrAvailable() {
		return lrAvailable;
	}

	public void setLrAvailable(String lrAvailable) {
		this.lrAvailable = lrAvailable;
	}

	public String getInvoiced() {
		return invoiced;
	}

	public void setInvoiced(String invoiced) {
		this.invoiced = invoiced;
	}
	
	

}

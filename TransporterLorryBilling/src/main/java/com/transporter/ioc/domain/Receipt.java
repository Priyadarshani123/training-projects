package com.transporter.ioc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Receipt  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long lrId;

	@Column(name = "trip_id")
	private long tripId;

	@Column(name = "load_id")
	private long loadId;

	@Column(name = "lr_number")
	private String lrNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;

	@Column(name = "comments")
	private String comments;

	@Column(name = "type")
	private String type; // System Generated or User Uploaded signed copy etc.

	public long getLrId() {
		return lrId;
	}

	public void setLrId(long lrId) {
		this.lrId = lrId;
	}

	public long getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public long getLoadId() {
		return loadId;
	}

	public void setLoadId(long loadId) {
		this.loadId = loadId;
	}

	public String getLrNumber() {
		return lrNumber;
	}

	public void setLrNumber(String lrNumber) {
		this.lrNumber = lrNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

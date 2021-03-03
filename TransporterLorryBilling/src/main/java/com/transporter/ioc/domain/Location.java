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
	public class Location  {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Long id;

		@Column(name = "state_id")
		private Long stateId;

		@Column(name = "location_name")
		private String locationName;

		@Column(name = "location_code")
		private String locationCode;

		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "state_id", referencedColumnName = "id", insertable = false, updatable = false)
		private States states;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getStateId() {
			return stateId;
		}

		public void setStateId(Long stateId) {
			this.stateId = stateId;
		}

		public String getLocationName() {
			return locationName;
		}

		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}

		public String getLocationCode() {
			return locationCode;
		}

		public void setLocationCode(String locationCode) {
			this.locationCode = locationCode;
		}

		public States getStates() {
			return states;
		}

		public void setStates(States states) {
			this.states = states;
		}

	}



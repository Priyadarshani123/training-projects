package com.transporter.ioc.domain;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	
	@Entity
	public class PackageDetails {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private long pkgId;

		@Column(name = "load_id")
		private Long loadId;

		@Column(name = "trip_id")
		private Long tripId;

		@Column(name = "package_count")
		private Double packageCount;

		@Column(name = "description")
		private String description;

		@Column(name = "actual_weight")
		private Double actualWeight;

		@Column(name = "weight_charge")
		private Double weightCharge;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "load_id", referencedColumnName = "id", insertable = false, updatable = false)
		private Load load;

		public long getPkgId() {
			return pkgId;
		}

		public void setPkgId(long pkgId) {
			this.pkgId = pkgId;
		}

		public Long getLoadId() {
			return loadId;
		}

		public void setLoadId(Long loadId) {
			this.loadId = loadId;
		}

		public Long getTripId() {
			return tripId;
		}

		public void setTripId(Long tripId) {
			this.tripId = tripId;
		}

		public Double getPackageCount() {
			return packageCount;
		}

		public void setPackageCount(Double packageCount) {
			this.packageCount = packageCount;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getActualWeight() {
			return actualWeight;
		}

		public void setActualWeight(Double actualWeight) {
			this.actualWeight = actualWeight;
		}

		public Double getWeightCharge() {
			return weightCharge;
		}

		public void setWeightCharge(Double weightCharge) {
			this.weightCharge = weightCharge;
		}
		
		

	}



package com.example.property_tax.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(
		name="SumTotal",
		query="select r from ZonalWiseReport r where r.status=:status_id and r.zones=:zone_id"
			)
public class ZonalWiseReport {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private AllZones zones;
	
	@ManyToOne
	private Status status;
	
	private String zoneName;
	
	private String statusName;
	
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AllZones getZones() {
		return zones;
	}

	public void setZones(AllZones zones) {
		this.zones = zones;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status, statusName, total, zoneName, zones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZonalWiseReport other = (ZonalWiseReport) obj;
		return id == other.id && Objects.equals(status, other.status) && Objects.equals(statusName, other.statusName)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total)
				&& Objects.equals(zoneName, other.zoneName) && Objects.equals(zones, other.zones);
	}

	public ZonalWiseReport(int id, AllZones zones, Status status, String zoneName, String statusName, double total) {
		super();
		this.id = id;
		this.zones = zones;
		this.status = status;
		this.zoneName = zoneName;
		this.statusName = statusName;
		this.total = total;
	}

	public ZonalWiseReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ZonalWiseReport [id=" + id + ", zones=" + zones + ", status=" + status + ", zoneName=" + zoneName
				+ ", statusName=" + statusName + ", total=" + total + "]";
	}
	
	

}

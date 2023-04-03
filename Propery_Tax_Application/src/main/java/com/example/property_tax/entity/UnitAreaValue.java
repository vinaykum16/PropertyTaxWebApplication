package com.example.property_tax.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(
		name="uaValue",
		query="select r from UnitAreaValue r where r.status=:status_id and r.desccript= :desccript_id and r.zone=:zone_id"
			)
public class UnitAreaValue {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Description desccript;
	
	@ManyToOne
	private Status status;
	
	@ManyToOne
	private AllZones zone;
	
	private double uaValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Description getDesccript() {
		return desccript;
	}

	public void setDesccript(Description desccript) {
		this.desccript = desccript;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public AllZones getZone() {
		return zone;
	}

	public void setZone(AllZones zone) {
		this.zone = zone;
	}

	public double getUaValue() {
		return uaValue;
	}

	public void setUaValue(double uaValue) {
		this.uaValue = uaValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(desccript, id, status, uaValue, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitAreaValue other = (UnitAreaValue) obj;
		return Objects.equals(desccript, other.desccript) && id == other.id && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(uaValue) == Double.doubleToLongBits(other.uaValue)
				&& Objects.equals(zone, other.zone);
	}

	public UnitAreaValue(int id, Description desccript, Status status, AllZones zone, double uaValue) {
		super();
		this.id = id;
		this.desccript = desccript;
		this.status = status;
		this.zone = zone;
		this.uaValue = uaValue;
	}

	public UnitAreaValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

package com.example.property_tax.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;

@NamedNativeQuery(name = "QUERY_FOR_ZOne",
query = "SELECT * FROM AllZones d WHERE d.id=:id")
@Entity
public class AllZones {
	
	@Id
	@GeneratedValue
	private int id;
	private String zones;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZones() {
		return zones;
	}
	public void setZones(String zones) {
		this.zones = zones;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, zones);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllZones other = (AllZones) obj;
		return id == other.id && Objects.equals(zones, other.zones);
	}
	public AllZones(int id, String zones) {
		super();
		this.id = id;
		this.zones = zones;
	}
	public AllZones() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

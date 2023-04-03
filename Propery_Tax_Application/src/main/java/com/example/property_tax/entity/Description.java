package com.example.property_tax.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Description {
	
	@Id
	@GeneratedValue
	private int id;
	private String descr;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescribe() {
		return descr;
	}
	public void setDescribe(String describe) {
		this.descr = describe;
	}
	@Override
	public int hashCode() {
		return java.util.Objects.hashCode(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Description other = (Description) obj;
		return Objects.equals(descr, other.descr) && id == other.id;
	}
	public Description(int id, String describe) {
		super();
		this.id = id;
		this.descr = describe;
	}
	public Description() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

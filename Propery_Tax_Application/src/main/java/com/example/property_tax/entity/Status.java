package com.example.property_tax.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Status {
	
	@Id
	@GeneratedValue
	private int id;
	private String status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return java.util.Objects.hashCode(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return id == other.id && Objects.equals(status, other.status);
	}
	public Status(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

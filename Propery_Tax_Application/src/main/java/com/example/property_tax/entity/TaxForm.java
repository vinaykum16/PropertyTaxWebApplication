package com.example.property_tax.entity;

import java.time.Year;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
public class TaxForm {
	
	@Id
	@GeneratedValue
	private int id;
	
	@PastOrPresent
	@Column(name="TaxYear")
	private Year year;
	
	
	@NotBlank(message="name not blank")
	private String name;
	
	@NotBlank(message="email not blank")
	private String email;
	
	
	@NotBlank(message="address not blank")
	private String address;
	
	@NotBlank(message="zone not blank")
	@Column(name="zones")
	private String zone;
	
	
	@NotBlank(message="desc not blank")
	private String description;
	
	@NotBlank(message="status not blank")
	private String status;
	
	@Past(message="must be past")
	private Year constructedYear;
	
	@Positive(message="area cannot be negative")
	private int area;
	
	@Positive(message="calulate the tax pls")
	private double tax;
	
	
	public TaxForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxForm(int id, @PastOrPresent Year year, @NotBlank(message = "name not blank") String name,
			@NotBlank(message = "email not blank") String email,
			@NotBlank(message = "address not blank") String address, @NotBlank(message = "zone not blank") String zone,
			@NotBlank(message = "desc not blank") String description,
			@NotBlank(message = "status not blank") String status, @Past(message = "must be past") Year constructedYear,
			@Positive(message = "area cannot be negative") int area,
			@Positive(message = "calulate the tax pls") double tax) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.email = email;
		this.address = address;
		this.zone = zone;
		this.description = description;
		this.status = status;
		this.constructedYear = constructedYear;
		this.area = area;
		this.tax = tax;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, area, constructedYear, description, email, id, name, status, tax, year, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxForm other = (TaxForm) obj;
		return Objects.equals(address, other.address) && area == other.area
				&& Objects.equals(constructedYear, other.constructedYear)
				&& Objects.equals(description, other.description) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(tax) == Double.doubleToLongBits(other.tax)
				&& Objects.equals(year, other.year) && Objects.equals(zone, other.zone);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Year getConstructedYear() {
		return constructedYear;
	}

	public void setConstructedYear(Year constructedYear) {
		this.constructedYear = constructedYear;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}



}

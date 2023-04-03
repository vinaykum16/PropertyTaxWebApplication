package com.example.property_tax.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue				
	@Column(name="personId")
	private long personId;

	@Column(name="userId")
	private String userId;
	
	@Column(name="password")	
	private String password;
	
	@Transient
	private String rememberMe;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")	
	private String lastName;
	
	@Column(name="dob")	
	private Date dob;

	@Column(name="email")	
	private String email;
	
	@Column(name="phone")	
	private long phone;

	@Column(name="street")	
	private String street;

	@Column(name="city")	
	private String city;

	@Column(name="state")	
	private String state;

	@Column(name="zip")	
	private String zip;

	@Column(name="userType")	
	private String userType;

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, dob, email, firstName, lastName, password, personId, phone, rememberMe, state, street,
				userId, userType, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(city, other.city) && Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && personId == other.personId && phone == other.phone
				&& Objects.equals(rememberMe, other.rememberMe) && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street) && Objects.equals(userId, other.userId)
				&& Objects.equals(userType, other.userType) && Objects.equals(zip, other.zip);
	}

	public User(long personId, String userId, String password, String rememberMe, String firstName, String lastName,
			Date dob, String email, long phone, String street, String city, String state, String zip, String userType) {
		super();
		this.personId = personId;
		this.userId = userId;
		this.password = password;
		this.rememberMe = rememberMe;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.userType = userType;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

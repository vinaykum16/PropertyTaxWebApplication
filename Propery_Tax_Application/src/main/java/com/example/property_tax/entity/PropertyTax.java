package com.example.property_tax.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_data")
public class PropertyTax {
	
	@Id
    @GeneratedValue
    @NotNull(message = "User Id shouldn't be null")
    private int id;

    @Column(name = "name")
    @NotNull(message = "Username shouldn't be null")
    private String name;

    @Column(name = "year")
    @Min(1947)
    @Max(2023)
    private int yearAssessment;

    @Column(name = "email")
    @Email(message = "Invalid email address")
    private String emailAddress;

    @Column(name = "address")
    @NotNull(message = "Address shouldn't be null")
    private String address;

    @Column(name = "zone")
    @NotNull(message = "Zone shouldn't be null")
    private String zone;

    @Column(name = "description")
    @NotNull(message = "Description shouldn't be null")
    private String description;

    @Column(name = "status")
    @NotNull(message = "Status shouldn't be null")
    private String status;

    @Column(name = "constructed_year")
    @Min(1947)
    @Max(2023)
    private int constructedYear;

    @Column(name = "area")
    @NotBlank
    private Float squareFeet;

    @Column(name = "total")
    @NotBlank
    private Float total;
    
    @ManyToOne(targetEntity = AllZones.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "zw_fk",referencedColumnName = "id")
    private AllZones zoneWise;
    
    
    
    
    @Override
	public int hashCode() {
		return Objects.hash(address, constructedYear, description, emailAddress, id, name, squareFeet, status, total,
				yearAssessment, zone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyTax other = (PropertyTax) obj;
		return Objects.equals(address, other.address) && constructedYear == other.constructedYear
				&& Objects.equals(description, other.description) && Objects.equals(emailAddress, other.emailAddress)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(squareFeet, other.squareFeet)
				&& Objects.equals(status, other.status) && Objects.equals(total, other.total)
				&& yearAssessment == other.yearAssessment && Objects.equals(zone, other.zone);
	}

}



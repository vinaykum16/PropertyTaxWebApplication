package com.example.property_tax.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@NotNull(message = "User Id shouldn't be null")
    private int id;

    @NotNull(message = "Username shouldn't be null")
    private String name;

    @Min(1947)
    @Max(2023)
    private int yearAssessment;

    @Email(message = "Invalid email address")
    private String emailAddress;

    @NotNull(message = "Address shouldn't be null")
    private String address;

    @NotNull(message = "Zone shouldn't be null")
    private String zone;

    @NotNull(message = "Description shouldn't be null")
    private String description;

    @NotNull(message = "Status shouldn't be null")
    private String status;

    @Min(1947)
    @Max(2023)
    private int constructedYear;

    @NotBlank
    private Float squareFeet;

    @NotBlank
    private Float total;

}

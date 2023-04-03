package com.example.property_tax.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.property_tax.entity.PropertyTax;
import com.example.property_tax.exception.DataNotFoundException;
import com.example.property_tax.exception.EntryNotValidException;
import com.example.property_tax.exception.NumberNotValidException;
import com.example.property_tax.repository.PropertyTaxRepo;

@Service
public class PropertyTaxService {

	@Autowired
	private PropertyTaxRepo ptRepo;

	public PropertyTax getUserById(int id) {
		try {
			if (id <= 0) {
				throw new NumberNotValidException("Invalid Id");
			}
		} catch (NumberNotValidException e) {
			System.out.println("Enter a Valid Number");
		}
		return ptRepo.findById(id).orElse(null);
	}

	public PropertyTax savePropertyTaxFormData(PropertyTax propertyTax) {
		try {
			if (propertyTax == null) {
				throw new EntryNotValidException("Please Check your Entry");
			}
		} catch (EntryNotValidException e) {
			System.out.println("Enter a Valid Data");
		}
		return ptRepo.save(propertyTax);
	}

	public List<PropertyTax> getPropertyTaxFormData() {
		return ptRepo.findAll();
	}

	public String deleteUserId(int id) {
		try {
			if (id < 0) {
				throw new DataNotFoundException("Data can't be Negative");
			}
		} catch (DataNotFoundException e) {
			System.out.println("Enter a valid Id");
		}
		ptRepo.deleteById(id);
		return "Deleted User Record" + id;
	}

}

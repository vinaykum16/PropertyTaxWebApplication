package com.example.property_tax.services;

import java.util.List;

import com.example.property_tax.entity.AllZones;
import com.example.property_tax.entity.Description;
import com.example.property_tax.entity.Status;
import com.example.property_tax.entity.TaxForm;
import com.example.property_tax.entity.ZonalWiseReport;

public interface TaxFormService {
	
public void save(TaxForm t);
	
	AllZones gezoneByID(int id);

	Description getdescByID(int id);

	Status getStatusByID(int id);

	double getUav(Status a, Description b, AllZones c);

	ZonalWiseReport setImp(Status a, AllZones c);

	void update(int id, double tax);

	List<ZonalWiseReport> getall();

}

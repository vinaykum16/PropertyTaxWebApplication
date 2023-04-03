package com.example.property_tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.property_tax.entity.AllZones;
import com.example.property_tax.entity.Status;
import com.example.property_tax.entity.ZonalWiseReport;

@Repository
public interface ZonalWiseReportRepo extends JpaRepository<ZonalWiseReport, Integer> {
	
	public ZonalWiseReport findByZonesAndStatus(AllZones zones,Status status);

}

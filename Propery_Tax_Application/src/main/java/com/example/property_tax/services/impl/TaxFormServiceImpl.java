package com.example.property_tax.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.property_tax.entity.AllZones;
import com.example.property_tax.entity.Description;
import com.example.property_tax.entity.Status;
import com.example.property_tax.entity.TaxForm;
import com.example.property_tax.entity.UnitAreaValue;
import com.example.property_tax.entity.ZonalWiseReport;
import com.example.property_tax.exception.DataNotFoundException;
import com.example.property_tax.repository.AllZonesRepo;
import com.example.property_tax.repository.DescriptionRepo;
import com.example.property_tax.repository.StatusRepo;
import com.example.property_tax.repository.TaxFormRepo;
import com.example.property_tax.repository.ZonalWiseReportRepo;
import com.example.property_tax.services.TaxFormService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class TaxFormServiceImpl implements TaxFormService {

	@Autowired
	private TaxFormRepo txRepo;

	@Autowired
	private DescriptionRepo dRepo;

	@Autowired
	private StatusRepo sRepo;

	@Autowired
	private AllZonesRepo azRepo;

	@Autowired
	private ZonalWiseReportRepo zwRepo;

	@Autowired
	private EntityManager em;

	Logger logger = LoggerFactory.getLogger(TaxFormServiceImpl.class);

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public double getUav(Status a, Description b, AllZones c) {
		TypedQuery<UnitAreaValue> query = em.createNamedQuery("uaValue", UnitAreaValue.class);
		query.setParameter("status_id", a);
		query.setParameter("description_id", b);
		query.setParameter("zone_id", c);
		List<UnitAreaValue> list = query.getResultList();
		return list.get(0).getUaValue();

	}

	@Override
	public Description getdescByID(int id) {
		return dRepo.findById(id).get();
	}

	@Override
	public AllZones gezoneByID(int id) {
		return azRepo.findById(id).get();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void update(int id, double tax) {
		ZonalWiseReport zwr = zwRepo.findById(id).get();
		zwr.setTotal(zwr.getTotal() + tax);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ZonalWiseReport> getall() {
		List<ZonalWiseReport> zwr = zwRepo.findAll();
		try {

			if (zwr.size() == 0) {
				throw new DataNotFoundException("Invalid Data");
			}

		} catch (DataNotFoundException e) {
			logger.error("Data is not found or " + e.getMessage());
		}
		return zwr;
	}

	@Override
	public void save(TaxForm t) {
		txRepo.save(t);
	}

	@Override
	public Status getStatusByID(int id) {
		return sRepo.findById(id).get();
	}

	@Override
	public ZonalWiseReport setImp(Status a, AllZones c) {
		ZonalWiseReport zwr = zwRepo.findByZonesAndStatus(c, a);
		return zwr;
	}

}

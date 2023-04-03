package com.example.property_tax.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.property_tax.entity.PropertyTax;

@Repository
public interface PropertyTaxRepo extends JpaRepository<PropertyTax, Integer> {
	
	public PropertyTax findByName(String name);

    @Query("SELECT c.zone, c.total FROM PropertyTax c JOIN c.zone")
    public List<PropertyTax> getJoinTableInformation();

    @Query("SELECT s.name FROM PropertyTax s")
    List<String> findAllByName();

    @Query("SELECT s.emailAddress FROM PropertyTax s")
    Set<String> findByEmailId();

    @Query("SELECT s.yearAssessment FROM PropertyTax s")
    List<String> findByYear();

}

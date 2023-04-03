package com.example.property_tax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.property_tax.entity.TaxForm;

@Repository
public interface TaxFormRepo extends JpaRepository<TaxForm, Integer> {

}

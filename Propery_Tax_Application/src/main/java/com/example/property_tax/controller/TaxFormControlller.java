package com.example.property_tax.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.property_tax.entity.TaxForm;
import com.example.property_tax.entity.ZonalWiseReport;
import com.example.property_tax.services.TaxFormService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/tax")
public class TaxFormControlller {
	
	@Autowired
	private TaxFormService service;

    Logger logger= LoggerFactory.getLogger(TaxFormControlller.class);

	@GetMapping("/login")
	@ResponseBody
	public String login()
	{
		return "welcome";
	}
	
	@GetMapping("/taxing")
	@ResponseBody
	public String taxforming(Model m)
	{
		m.addAttribute("taxForm",new TaxForm());
		return "TaxForm";
	}
	
	
	@GetMapping("/savetax")
	@ResponseBody
	public String taxed(@Valid @ModelAttribute("taxForm")TaxForm t,BindingResult br)
	{
		if(br.hasErrors())
		{
			logger.error("Form is not filled correctly please ensure with validator conditions");
			return "TaxForm";
		}
		else
		{
			service.save(t);
			return "welcome";
			
		}
	}
	
	@GetMapping("/reports")
	public String reports(ModelMap m)
	{
		List<ZonalWiseReport> k=service.getall();
		m.put("all",k);
		return "zonalreport";
	}

}

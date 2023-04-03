package com.example.property_tax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.property_tax.entity.PropertyTax;
import com.example.property_tax.services.PropertyTaxService;

@Controller
@RequestMapping("property")
public class PropertyTaxController {
	
	@Autowired
    private PropertyTaxService ptService;

	@ResponseBody
	@GetMapping("/sayWelcome")
    public String redirect()  
    {  
        return "error";  
    }     

    @PostMapping("/taxPropertyForm")
    @ResponseBody
    public PropertyTax saveTaxFormData(@RequestBody PropertyTax propertyTax){
        return ptService.savePropertyTaxFormData(propertyTax);
    }

    @GetMapping("/getAllUserData")
    @ResponseBody
    public List<PropertyTax> findAllUserData(){
        return ptService.getPropertyTaxFormData();
    }

    @GetMapping("/getUserId/{id}")
    @ResponseBody
    public PropertyTax findUserById(@PathVariable int id){
        return ptService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteUserForm(@PathVariable int id){
        return ptService.deleteUserId(id);
    }


    @GetMapping("/home")//Home Page
    @ResponseBody
    public String welcomePageDisplay(){
        return "WelcomePage";
    }

    @GetMapping("/zone")//Zone Wise Report
    @ResponseBody
    public String showDisplay(Model model){
        List<PropertyTax> allList = ptService.getPropertyTaxFormData();
        model.addAttribute("allData", allList);
        return "Zone Wise Report";
    }

}

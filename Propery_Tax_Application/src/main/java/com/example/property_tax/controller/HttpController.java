package com.example.property_tax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.property_tax.entity.AllZones;
import com.example.property_tax.entity.Description;
import com.example.property_tax.entity.Status;
import com.example.property_tax.entity.ZonalWiseReport;
import com.example.property_tax.exception.DescNotFoundException;
import com.example.property_tax.exception.StatusNotFoundException;
import com.example.property_tax.exception.ZonalNotFoundException;
import com.example.property_tax.services.TaxFormService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HttpController extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;

	    @Autowired
	    private TaxFormService service;
	    
	    Logger logger= LoggerFactory.getLogger(HttpController.class);

	   
	    @RequestMapping("/AjaxController")
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	response.setContentType("text/plain ");

	        PrintWriter out =  response.getWriter();
	        String action = request.getParameter("action");

	       if (action.equals("demo2")){
	    	   Description d=null;
	    	   AllZones z=null;
	    	   Status s = null;
	            int a = Integer.parseInt(request.getParameter("status_id"));
	            int b = Integer.parseInt(request.getParameter("description_id"));
	            int c =Integer.parseInt(request.getParameter("zone_id"));
	            int area=Integer.parseInt(request.getParameter("area"));
	            int constructedyear=Integer.parseInt(request.getParameter("constructedyear"));
	            try
	            {
	            d=service.getdescByID(b);
	            if(d==null)
	            {
	            	throw new DescNotFoundException("No description found");
	            }
	            
	            
	            z=service.gezoneByID(c);
	            if(z==null)
	            {
	            	throw new ZonalNotFoundException("No zone found");
	            }
	            s=service.getStatusByID(a);
	            if(d==null)
	            {
	            	throw new StatusNotFoundException("No status found");
	            }
	            }
	            catch(StatusNotFoundException | DescNotFoundException | ZonalNotFoundException e)
	            {
	            	logger.error("Data Not FOund Please FInd the Mistake at"+e.getMessage());
	            }
	            double xx=service.getUav(s,d,z);
	            int diff=2023-constructedyear;
	            double total1=10*area*xx;
	            
	            double depreciation;
	            if(diff>=60)
	            {
	            	depreciation=total1*(0.6);
	            }
	            else
	            {
	            	depreciation=total1*(diff)/100;
	            }
	            
	            double tota12=total1-depreciation;
				double total3=tota12*(0.2);
				double total4=total3*(0.24);
				double tax=total3+total4;
				ZonalWiseReport r=service.setImp(s, z);
				service.update(r.getId(), tax);
	            out.println(total3+total4);

	            logger.info("total tax to pay is"+total3+total4);
	    }
	    
	    }

}

package com.egen.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egen.model.AlertVO;
import com.egen.model.WeightVO;
import com.egen.service.WeightService;


@RestController
public class WeightController {
		
	
	private static final Logger log = LoggerFactory.getLogger(WeightController.class);
	
		    @POST
		    @RequestMapping("/")
		    @Consumes({MediaType.APPLICATION_JSON})
		    public void createEntry(@RequestBody WeightVO weight) {
		    	 System.out.println("hi in weight"+weight);
		    	 System.out.println("hi weight::"+weight.getValue() +" time:: "+weight.getTimeStamp());
		    	 WeightService ws = new WeightService();
		    	 ws.addWeight(weight);
		    }
		    
		    @GET
		    @RequestMapping("/getAllWeights")
		    @Consumes({MediaType.APPLICATION_JSON})
		    public List<WeightVO> getAllWeigths() {
		    	 WeightService ws = new WeightService();
		    	 return ws.getAllWeights();
		    }
		    
		    @GET
		    @RequestMapping("/getAllAlerts")
		    @Consumes({MediaType.APPLICATION_JSON})
		    public List<AlertVO> getAllAlerts() {
		    	 WeightService ws = new WeightService();
		    	 return ws.getAllAlerts();
		    }
		    
		    @GET
		    @RequestMapping("/getWeights/{startDate}/{endDate}")
		    @Consumes({MediaType.APPLICATION_JSON})
		    public List<WeightVO> getAllWeigths(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
		    	 WeightService ws = new WeightService();
		    	 System.out.println(startDate);
		    	 System.out.println(endDate);
		    	 return ws.getAllWeights(startDate,  endDate);
		    }
	}

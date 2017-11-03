package com.egen.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.egen.model.AlertVO;
import com.egen.model.WeightVO;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Criteria;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.mongodb.Mongo;


public class WeightDAO {

	public void addWeight(WeightVO weight) {
		String dbName = new String("WeightVO");
	     Mongo mongo = new Mongo();
	     Morphia morphia = new Morphia();
	     Datastore datastore = morphia.createDatastore(mongo, dbName);      
	 
	     morphia.mapPackage("com.egen.model");
	     
	     Key<WeightVO> savedCustomer = datastore.save(weight);   
	     if(Integer.parseInt(weight.getValue())>165) {
	    	 AlertVO av= new AlertVO();
	    	 av.setBaseWeightvalue(150);
	    	 av.setTimeStamp(weight.getTimeStamp());
	    	 av.setWeightDeviation("overweight");
	    	 av.setWeight(Integer.parseInt(weight.getValue()));
	    	 Key<AlertVO> savedAlert = datastore.save(av);
	     }else if(Integer.parseInt(weight.getValue())<135) {
	    	 AlertVO av= new AlertVO();
	    	 av.setBaseWeightvalue(150);
	    	 av.setTimeStamp(weight.getTimeStamp());
	    	 av.setWeightDeviation("underweight");
	    	 av.setWeight(Integer.parseInt(weight.getValue()));
	    	 Key<AlertVO> savedAlert = datastore.save(av);
	     }
	     System.out.println(savedCustomer.getId());
	}
	
	public List<WeightVO> getAllWeights(){
		String dbName = new String("WeightVO");
		  Mongo mongo = new Mongo();
		     Morphia morphia = new Morphia();
		     Datastore datastore = morphia.createDatastore(mongo, dbName);      
		     BasicDAO x = new WeightBasicDAO(morphia,mongo,dbName);
		     morphia.mapPackage("com.egen.model");
		     Query<WeightVO> query = datastore.createQuery(WeightVO.class);
		         
		     List<WeightVO> weightVOList = new ArrayList<WeightVO>();
		     QueryResults<WeightVO> retrievedCustomers =  x.find(query);  
		 
		     for (WeightVO retrievedWeight : retrievedCustomers) {
		         
		         weightVOList.add(retrievedWeight);
		     } 
		     return weightVOList;
	}
	
	public List<AlertVO> getAllAlerts(){
		String dbName = new String("WeightVO");
		  Mongo mongo = new Mongo();
		     Morphia morphia = new Morphia();
		     Datastore datastore = morphia.createDatastore(mongo, dbName);      
		     BasicDAO x = new WeightBasicDAO(morphia,mongo,dbName);
		     morphia.mapPackage("com.egen.model");
		     Query<AlertVO> query = datastore.createQuery(AlertVO.class);
		         
		     List<AlertVO> weightVOList = new ArrayList<AlertVO>();
		     QueryResults<AlertVO> retrievedCustomers =  x.find(query);  
		 
		     for (AlertVO retrievedWeight : retrievedCustomers) {
		         
		         weightVOList.add(retrievedWeight);
		     } 
		     return weightVOList;
	}

	public List<WeightVO> getAllWeights(String startDate, String endDate) {
		String dbName = new String("WeightVO");
		Date startDate1 = new Date(Long.parseLong(startDate));
		Date endDate1 = new Date(Long.parseLong(endDate));
		  Mongo mongo = new Mongo();
		     Morphia morphia = new Morphia();
		     Datastore datastore = morphia.createDatastore(mongo, dbName);      
		     BasicDAO x = new WeightBasicDAO(morphia,mongo,dbName);
		     morphia.mapPackage("com.egen.model");
		     Query<WeightVO> query = datastore.createQuery(WeightVO.class);
//		     query.filter("timeStamp >=", startDate1);
//		     query.filter("timeStamp <=", endDate1);    
		     query.criteria("timeStamp").greaterThan(startDate1).add(query.criteria("timeStamp").lessThan(endDate1));
		     List<WeightVO> weightVOList = new ArrayList<WeightVO>();
		     QueryResults<WeightVO> retrievedCustomers =  x.find(query);  
		 
		     for (WeightVO retrievedWeight : retrievedCustomers) {
		         
		         weightVOList.add(retrievedWeight);
		     } 
		     return weightVOList;
	}
}

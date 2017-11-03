package com.egen.service;

import java.util.List;

import com.egen.dao.WeightDAO;
import com.egen.model.AlertVO;
import com.egen.model.WeightVO;

public class WeightService {

	public void addWeight(WeightVO weight) {
		WeightDAO wd = new WeightDAO();
		wd.addWeight(weight);
	}
	
	public List<WeightVO> getAllWeights() {
		WeightDAO wd = new WeightDAO();
		return wd.getAllWeights();
	}

	public List<AlertVO> getAllAlerts() {
		WeightDAO wd = new WeightDAO();
		return wd.getAllAlerts();
	}

	public List<WeightVO> getAllWeights(String startDate, String endDate) {
		WeightDAO wd = new WeightDAO();
		return wd.getAllWeights(startDate,endDate);
	}
}

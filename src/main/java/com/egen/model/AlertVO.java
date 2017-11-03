package com.egen.model;

import java.util.Date;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class AlertVO {
	Date timeStamp;
	int baseWeightvalue;
	int weight;
	String weightDeviation;
	public String getWeightDeviation() {
		return weightDeviation;
	}
	public void setWeightDeviation(String weightDeviation) {
		this.weightDeviation = weightDeviation;
	}
	@Id
	String alertId;
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getBaseWeightvalue() {
		return baseWeightvalue;
	}
	public void setBaseWeightvalue(int baseWeightvalue) {
		this.baseWeightvalue = baseWeightvalue;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}

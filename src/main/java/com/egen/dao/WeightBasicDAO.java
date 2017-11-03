package com.egen.dao;

import com.egen.model.WeightVO;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class WeightBasicDAO extends BasicDAO<WeightVO, String>{

	public WeightBasicDAO(Morphia morphia, Mongo mongo, String dbName) {       
        super(mongo, morphia, dbName);   
    }
}

package com.cs.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.Class1Repository;
import com.cs.model.Class1;
import com.cs.services.IClass1Service;

@Service
public class Class1ServiceImpl implements IClass1Service {
	@Autowired
	private Class1Repository class1Repository;

	@Override
	public Iterable<Class1> findAll() {
		Iterable<Class1> list = class1Repository.findAll();
		return list;
	}

}

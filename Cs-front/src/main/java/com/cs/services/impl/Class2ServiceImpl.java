package com.cs.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.Class2Repository;
import com.cs.model.Class2;
import com.cs.services.IClass2Service;

@Service
@Transactional
public class Class2ServiceImpl implements IClass2Service{

	@Autowired
	private Class2Repository class2Repository;
	public List<Class2> findAll() {
		
		return (List<Class2>) class2Repository.findAll();
	}
	public List<Class2> findByClass1Id(int class1Id) {
		
		return class2Repository.findByClass1Id(class1Id);
	}

}

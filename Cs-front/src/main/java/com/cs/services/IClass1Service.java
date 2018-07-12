package com.cs.services;

import com.cs.model.Class1;

public interface IClass1Service {
	/**
	 * 查询所有一级分类
	 * 
	 * @return
	 */
	Iterable<Class1> findAll();
}

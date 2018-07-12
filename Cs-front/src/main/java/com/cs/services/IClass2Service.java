package com.cs.services;

import java.util.List;

import com.cs.model.Class2;

public interface IClass2Service {
	/**
	 * 查询所有二级分类
	 * 
	 * @return
	 */
	List<Class2> findAll();

	/**
	 * 根据一级分类id查询所有二级分类
	 * 
	 * @param class1Id
	 *            一级分类id
	 * @return
	 */
	List<Class2> findByClass1Id(int class1Id);
}

package com.cs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs.model.Class2;

/**
 * 二级分类仓库
 * 
 * @author fan 创建时间：2018年7月12日
 */
@Repository
public interface Class2Repository extends CrudRepository<Class2, Integer> {
	/**
	 * 根据一级分类id查询所有二级分类
	 * 
	 * @param class1Id
	 *            一级分类id
	 * @return
	 */
	List<Class2> findByClass1Id(int class1Id);

}

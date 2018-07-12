package com.cs.dao;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cs.model.Class1;
/**
 * 一级分类仓库
 * @author fan
 * 创建时间：2018年7月12日
 */
@Repository
public interface Class1Repository extends CrudRepository<Class1, Integer>{


}

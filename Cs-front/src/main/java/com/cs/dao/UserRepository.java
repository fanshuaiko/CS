package com.cs.dao;

import com.cs.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户仓库
 * 
 * @author fanshui
 * @date 18-7-8 下午6:10
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public User findByUserNameAndUserPassword(String userName, String userPassword);

	/**
	 * g根据用户名和电话查询用户
	 * 
	 * @param username
	 * @param tel
	 * @return
	 */
	public User findByUserNameAndUserTel(String username, String tel);
}

package com.cs.services;

import java.util.Optional;

import com.cs.model.User;

/**
 * @author fanshui
 * @date 18-7-8 下午4:55
 */
public interface IUserService {
	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	User save(User user);

	/**
	 * 根据id查询User
	 * 
	 * @param id
	 *            用户id
	 * @return
	 */
	Optional<User> findById(Integer id);

	/**
	 * 重置密码
	 * 
	 * @param username
	 *            用户名
	 * @param tel
	 *            电话号码
	 * @return
	 */
	User resetPassword(String username, String tel);// 重置密码
}

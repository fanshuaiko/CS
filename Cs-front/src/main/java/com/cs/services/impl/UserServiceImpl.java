package com.cs.services.impl;

import com.cs.dao.UserRepository;
import com.cs.model.User;
import com.cs.services.IUserService;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanshui
 * @date 18-7-8 下午4:55
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepostory;

	public User login(User user) {
		User u = userRepostory.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		System.out.println("------------"+u);
		if(u != null) {
			if(u.getUserState() == 1) {
				throw new RuntimeException("用户已被冻结");
			}else {
				return u;
			}
		}else {
			throw new RuntimeException("用户名或密码错误！");
		}
	}

	public User save(User user) {
		return userRepostory.save(user);

	}

	@Override
	public Optional<User> findById(Integer id) {

		return userRepostory.findById(id);
	}

	public User resetPassword(String username, String tel) {
		return userRepostory.findByUserNameAndUserTel(username, tel);
	}

	// @Override
	// public List<User> findAll() {
	// return (List<User>) userRepostory.findAll();
	// }

}

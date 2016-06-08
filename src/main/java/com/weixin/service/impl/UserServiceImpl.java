package com.weixin.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weixin.entity.mongo.User;
import com.weixin.exception.MyException;
import com.weixin.repository.mongo.UserRepository;
import com.weixin.service.iface.UserService;
import com.weixin.vo.UserVo;

/**
 * @author jay
 * @since 2016年6月8日
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserVo findByUserName(String userName) {
		User user = userRepository.findByUserName(userName);

		UserVo userVo = new UserVo();
		userVo.setId(user.getId());
		userVo.setUserName(user.getUserName());
		userVo.setPassword(user.getPassword());

		return userVo;
	}

	@Override
	public Set<UserVo> findAllUsers() {
		List<User> users = userRepository.findAll();

		Set<UserVo> userVoList = new HashSet<>();

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserVo userVo = new UserVo();
			userVo.setId(user.getId());
			userVo.setUserName(user.getUserName());

			userVoList.add(userVo);
		}

		return userVoList;
	}

	@Override
	public void addUser(UserVo userVo) {

		// check userName exist
		if( findByUserName(userVo.getUserName()) != null ){
			throw  new MyException(100,"用户名已存在！");
		}
		
		User user = new User();
		user.setUserName(userVo.getUserName());
		user.setPassword(userVo.getPassword());

		userRepository.save(user);

	}

}

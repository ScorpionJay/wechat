package com.weixin.repository.mongo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.weixin.entity.mongo.User;

/**
 * @author Jay
 * @time 2015年5月21日
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

	/**
	 * 根据用户id获取用户
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	User findByUserName(String userName );

	/**
	 * 根据用户名获取用户
	 * 
	 * @param usreName
	 *            用户名
	 * @return
	 */
	List<User> findAll();
}
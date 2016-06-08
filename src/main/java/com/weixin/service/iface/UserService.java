package com.weixin.service.iface;

import java.util.Set;

import com.weixin.vo.UserVo;

/**
 * @author jay
 * @since 2016年6月8日
 */
public interface UserService {

	
	/**
	 * 新增用户
	 * @param user
	 */
	void addUser(UserVo userVo);
	
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	UserVo findByUserName(String userName);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	Set<UserVo> findAllUsers();
	
}

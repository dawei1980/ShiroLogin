package com.shiro.login.dao;

import com.github.pagehelper.Page;
import com.shiro.login.constant.BaseDao;
import com.shiro.login.entity.UUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UUserDao extends BaseDao<UUser, Long> {

	/**
	 * 增加对象
	 * @param obj
	 */
	UUser findByName(String name);

	UUser findById(Long id);

	Page<UUser> findAllUserByPage();

	int addUser(UUser uUser);

	int updateUser(UUser uUser);

	int deleteUser(Long id);

	int deleteUserAndRole(Long id);
 }

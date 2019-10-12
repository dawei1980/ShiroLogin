package com.shiro.login.dao;

import com.shiro.login.constant.BaseDao;
import com.shiro.login.entity.URole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface URoleDao extends BaseDao<URole, Long> {

	/**
	 * 根据用户ID获取该用户所在组的角色权限
	 * @param obj
	 */
	List<URole> findRoleByUid(Long obj);

	URole findOndRoleByUid(Long uid);
}

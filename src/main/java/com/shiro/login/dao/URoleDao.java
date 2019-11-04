package com.shiro.login.dao;

import com.github.pagehelper.Page;
import com.shiro.login.constant.BaseDao;
import com.shiro.login.entity.URole;
import com.shiro.login.entity.UUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface URoleDao extends BaseDao<URole, Long> {

	/**
	 * 根据用户ID获取该用户所在组的角色权限
	 * @param obj
	 */
	Page<URole> findAllRoleByPage();
	List<URole> findRoleByUid(long id);

	int addRole(URole uRole);
	int deleteRole(long id);
	int updateRole(URole uRole);
}

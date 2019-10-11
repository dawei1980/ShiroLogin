package com.shiro.login.dao;

import com.shiro.login.constant.BaseDao;
import com.shiro.login.entity.UUserRole;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UUserRoleDao extends BaseDao<UUserRole, Long> {

   /**
    * 增加对象
    * @param obj
    */
   //public void add(SysMessageTep	 obj);
}

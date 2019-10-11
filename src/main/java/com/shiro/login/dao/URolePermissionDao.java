package com.shiro.login.dao;

import com.shiro.login.constant.BaseDao;
import com.shiro.login.entity.URolePermission;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface URolePermissionDao extends BaseDao<URolePermission, Long> {

   /**
    * 增加对象
    * @param obj
    */
   //public void add(SysMessageTep	 obj);
}

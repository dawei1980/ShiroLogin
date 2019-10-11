package com.shiro.login.dao;

import com.github.pagehelper.Page;
import com.shiro.login.constant.BaseDao;
import com.shiro.login.entity.UPermission;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UPermissionDao extends BaseDao<UPermission, Long> {
   /**
    * 根据用户id获取用户权限
    * @param obj
    */
    List<UPermission> findPermissionByUid(Long id);

    UPermission findById(Long id);

    Page<UPermission> findByPaging();

    int addPermission(UPermission uPermission);

    int deletePermission(Long id);

    int updatePermission(UPermission uPermission);
}

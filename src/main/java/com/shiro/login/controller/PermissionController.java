package com.shiro.login.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiro.login.dao.UPermissionDao;
import com.shiro.login.entity.UPermission;
import com.shiro.login.result.JsonObjectResult;
import com.shiro.login.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shiro")
public class PermissionController {

    @Autowired
    UPermissionDao uPermissionDao;

    /**
     * 权限列表包含分页
     * */
    @GetMapping(value = "/permissionPageList")
    public Object findByPaging(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<UPermission> data = uPermissionDao.findByPaging();
        if(data.size() != 0){
            return new JsonObjectResult(ResultCode.SUCCESS, "更新数据成功", data);
        }else {
            return new JsonObjectResult(ResultCode.NO_DATA, "没有数据");
        }
    }

    @PostMapping(value = "/addPermission")
    public Object addPermission(UPermission uPermission){
        UPermission checkedPermission = uPermissionDao.findById(uPermission.getId());

        if(null != checkedPermission){
            return new JsonObjectResult(ResultCode.HAVE_PERMISSION, "权限名已存在", checkedPermission.getName());
        }
        if(null != checkedPermission){
            return new JsonObjectResult(ResultCode.HAVE_PERMISSION, "权限名已存在", checkedPermission.getUrl());
        }

        uPermissionDao.addPermission(uPermission);
        return new JsonObjectResult(ResultCode.SUCCESS, "权限添加成功");
    }

    @PostMapping(value = "/deletePermission")
    public Object deletePermission(Long id){
        uPermissionDao.deletePermission(id);
        return new JsonObjectResult(ResultCode.SUCCESS, "删除权限成功");
    }

    @PostMapping(value = "/updatePermission")
    public Object updatePermission(UPermission uPermission){
        uPermissionDao.updatePermission(uPermission);
        return new JsonObjectResult(ResultCode.SUCCESS, "更新权限成功");
    }
}

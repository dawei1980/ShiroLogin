package com.shiro.login.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiro.login.dao.URoleDao;
import com.shiro.login.entity.UPermission;
import com.shiro.login.entity.URole;
import com.shiro.login.entity.UUser;
import com.shiro.login.result.JsonObjectResult;
import com.shiro.login.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/shiro")
public class RoleController {
    @Autowired
    private URoleDao uRoleDao;

    @GetMapping(value = "rolePageList")
    public Object rolePageList(@RequestParam(value = "page_num") Integer pageNum,
                               @RequestParam(value = "page_size") Integer pageSize){

        if(pageNum == 0){
            return new JsonObjectResult(ResultCode.PAGE_NUM_NOT_EMPTY, "页数不能为空");
        }else if(pageSize == 0){
            return new JsonObjectResult(ResultCode.PAGE_SIZE_NOT_EMPTY, "行数不能为空");
        }else {
            PageHelper.startPage(pageNum,pageSize);
            Page<URole> data = uRoleDao.findAllRoleByPage();
            if(data.size() != 0){
                return new JsonObjectResult(ResultCode.SUCCESS, "获取数据成功", data);
            }else {
                return new JsonObjectResult(ResultCode.NO_DATA, "没有数据");
            }
        }
    }

    @PostMapping(value = "addRole")
    public Object addRole(URole uRole){
        if(uRole != null){
            uRoleDao.addRole(uRole);
            return new JsonObjectResult(ResultCode.SUCCESS, "添加数据成功", uRole);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }

    @PostMapping(value = "deleteRole")
    public Object deleteRole(@RequestParam(value = "role_id") String roleId){
        long id = Integer.parseInt(roleId);

        if(id != 0){
            uRoleDao.deleteRole(id);
            return new JsonObjectResult(ResultCode.SUCCESS, "删除数据成功", id);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }

    @PostMapping(value = "/updateRole")
    public Object updateUser(URole uRole){
        if(uRole != null){
            uRoleDao.updateRole(uRole);
            return new JsonObjectResult(ResultCode.SUCCESS, "更新成功");
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }
}

package com.shiro.login.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiro.login.dao.UPermissionDao;
import com.shiro.login.entity.UPermission;
import com.shiro.login.result.JsonObjectResult;
import com.shiro.login.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shiro")
public class PermissionController {

    @Autowired
    UPermissionDao uPermissionDao;

    @GetMapping(value = "/permissionPageList")
    public Object findByPaging(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<UPermission> data = uPermissionDao.findByPaging();
//        JSONObject result = new JSONObject();
//        result.put("employees",data);
//        //获取页面总数
//        result.put("pages",data.getPages());
//        //获取数据总数
//        result.put("total",data.getTotal());
//        return ResultMsg.getMsg(result);
        return new JsonObjectResult(ResultCode.SUCCESS, "更新数据成功", data);
    }

}

package com.shiro.login.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiro.login.dao.UUserDao;
import com.shiro.login.entity.UUser;
import com.shiro.login.result.JsonObjectResult;
import com.shiro.login.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shiro")
public class UserController {
    @Autowired
    UUserDao uUserDao;

    /**
     * 权限列表包含分页
     * */
    @GetMapping(value = "/userPageList")
    public Object findByPaging(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<UUser> data = uUserDao.findAllUserByPage();
        if(data.size() != 0){
            return new JsonObjectResult(ResultCode.SUCCESS, "获取数据成功", data);
        }else {
            return new JsonObjectResult(ResultCode.NO_DATA, "没有数据", data);
        }
    }
}
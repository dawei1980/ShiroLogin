package com.shiro.login.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiro.login.dao.UUserDao;
import com.shiro.login.dao.UUserRoleDao;
import com.shiro.login.entity.UPermission;
import com.shiro.login.entity.UUser;
import com.shiro.login.result.JsonObjectResult;
import com.shiro.login.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/shiro")
public class UserController {
    @Autowired
    UUserDao uUserDao;
    @Autowired
    UUserRoleDao uUserRoleDao;

    /**
     * 权限列表包含分页
     * */
    @GetMapping(value = "/userPageList")
    public Object findByPaging(Integer pageNum, Integer pageSize){

        if(pageNum == 0){
            return new JsonObjectResult(ResultCode.PAGE_NUM_NOT_EMPTY, "页数不能为空");
        }else if(pageSize == 0){
            return new JsonObjectResult(ResultCode.PAGE_SIZE_NOT_EMPTY, "行数不能为空");
        }else{
            PageHelper.startPage(pageNum,pageSize);
            Page<UUser> data = uUserDao.findAllUserByPage();
            if(data.size() != 0){
                return new JsonObjectResult(ResultCode.SUCCESS, "获取数据成功", data);
            }else {
                return new JsonObjectResult(ResultCode.NO_DATA, "没有数据");
            }
        }
    }

    @PostMapping(value = "/addUser")
    public Object addUser(UUser uUser,
                          @RequestParam(value = "role_type") String roleType){
        UUser checkedUser = uUserDao.findById(uUser.getId());

        if(null != checkedUser){
            return new JsonObjectResult(ResultCode.HAVE_PERMISSION, "用户名已存在", checkedUser.getNickname());
        }

        long roleId = Long.valueOf(roleType);

        uUserDao.addUser(uUser);
        uUserRoleDao.add(roleId);
        return new JsonObjectResult(ResultCode.SUCCESS, "用户名添加成功");
    }

    @PostMapping(value = "/deleteUser")
    public Object deleteUser(@RequestParam(value = "user_id") long userId){
        uUserDao.deleteUser(userId);
        return new JsonObjectResult(ResultCode.SUCCESS, "删除成功");
    }

    @PostMapping(value = "/updateUser")
    public Object updateUser(UUser uUser){
        uUserDao.updateUser(uUser);
        return new JsonObjectResult(ResultCode.SUCCESS, "更新成功");
    }

    @PostMapping(value = "/deleteUserAndRole")
    public Object deleteUserAndRole(@RequestParam(value = "user_id") long userId){
        if(userId != 0){
            uUserDao.deleteUser(userId);
            return new JsonObjectResult(ResultCode.SUCCESS, "删除成功");
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }
}

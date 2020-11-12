package com.pingan.pahm.controller;

import com.pingan.pahm.entity.T_User;
import com.pingan.pahm.service.T_UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "调用webservice接口")
@RequestMapping("performance/")
public class T_UserController {

    @Autowired
    private T_UserService t_UserService;

    @GetMapping("gettuse")
    @ApiOperation("获取用戶数据")
    public List<T_User> getTUser(){
        List<T_User> list = t_UserService.getTUser();
        return list;
    }
}

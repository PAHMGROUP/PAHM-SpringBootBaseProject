package com.pingan.pahm.service;

import com.pingan.pahm.dao.postgre.T_UserMapper;
import com.pingan.pahm.entity.T_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class T_UserService {

    @Autowired
    private T_UserMapper t_UserMapper;

    public List<T_User> getTUser(){
        return t_UserMapper.getTUser();
    }
}

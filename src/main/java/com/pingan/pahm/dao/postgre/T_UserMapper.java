package com.pingan.pahm.dao.postgre;

import com.pingan.pahm.entity.T_User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface T_UserMapper {

    public List<T_User> getTUser();
}

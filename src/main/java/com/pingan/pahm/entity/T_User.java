package com.pingan.pahm.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class T_User {

    private int id;
    private String name;
    private String password;
    private String gender;
    private Date birthday;
    private Timestamp create_time;
}

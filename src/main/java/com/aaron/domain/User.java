package com.aaron.domain;

import lombok.Data;

/**
 * Created by shiyongxiang on 16/10/21.
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int age;

    public User(){
    }

    public User(int id,String username,String password,int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }
}


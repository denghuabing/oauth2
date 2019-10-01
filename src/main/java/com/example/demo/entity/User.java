package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User extends BaseBean implements Serializable {

    private static final long serialVersionUID = 8561604290295314180L;

    private String userName;

    private String password;
}

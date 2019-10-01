package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class BaseBean implements Serializable {

    private static final long serialVersionUID = 8130278046219852264L;
    private String id = UUID.randomUUID().toString();
}

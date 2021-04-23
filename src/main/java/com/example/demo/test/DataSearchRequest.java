package com.example.demo.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
class DataSearchRequest {

    private String id;
    private Date updatedBefore;
    private int length;
}
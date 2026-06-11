package com.demowechat.data;

import org.springframework.stereotype.Component;

@Component
public class Animal {

    public void eat(){
        System.out.println("动物在吃");
    }
    public void sleep(){
        System.out.println("动物在睡觉");
    }
}

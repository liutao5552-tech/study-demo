package com.demowechat.test;

public class Dog extends Animal{
    @Override
    public void eat(){
        System.out.println("重写狗在吃");
    }

    @Override
    public void sleep(){
        System.out.println("重写狗在睡觉");
    }
}

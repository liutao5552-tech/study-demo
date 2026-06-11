package com.demowechat.data;

public class Cat extends Animal {

    @Override
    public void eat(){
        System.out.println("重写猫在吃");
    }

    @Override
    public void sleep(){
        System.out.println("重写猫在睡觉");
    }
}

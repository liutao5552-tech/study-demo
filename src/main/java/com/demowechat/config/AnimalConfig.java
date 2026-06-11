package com.demowechat.config;

import com.demowechat.data.Animal;
import com.demowechat.data.Cat;
import com.demowechat.data.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AnimalConfig {

    @Bean
    public Animal animal1(){
        return new Dog();
    }


    @Bean
    public Animal animal2(){
        return new Cat();
    }
}

package com.demowechat.controller;

import com.demowechat.dto.WechatDTO;
import com.demowechat.service.TestService;
import com.demowechat.service.WechtService;
import com.demowechat.service.impl.TestServiceImpl;
import com.demowechat.service.impl.TestServiceImpl2;
import com.demowechat.data.Animal;
import com.demowechat.data.Dog;
import com.demowechat.util.SpringContextUtil;
import com.demowechat.util.WebSocketServer;
import com.demowechat.vo.WechatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/wechat")
@RestController
public class WechatController {

    @Autowired
    private WechtService wechtService;


    @Autowired
    private SpringContextUtil springContextUtil;

    @Autowired
    private Animal animal;

    @PostMapping("/signature")
    public WechatVO signature(@RequestBody WechatDTO wechatDTO) throws Exception{
        String url=wechatDTO.getUrl();
        WechatVO wechatVO=wechtService.signature(url);
        System.out.println(wechatVO);
        return wechatVO;
    }

    @GetMapping("/getPayType")
    public String getPayType(String type){
        TestService testService=new TestServiceImpl();
        TestService testService2=new TestServiceImpl2();

        return testService.getPayType(type)+testService2.getPayType(type);
    }

    @GetMapping("/getWhoEat")
    public void getWhoEat(){
        Animal animal=new Animal();
        Animal dog=new Dog();
        Animal dogSleep=new Dog();
        animal.eat();
        animal.sleep();
        dog.eat();
        dogSleep.sleep();
    }


    @GetMapping("/test")
    public String test(){
        return "test啊哈哈哈哈哈哈";
    }

    @GetMapping("/test2")
    public void test2(){
        animal.sleep();
        animal.eat();

        System.out.println(springContextUtil.getProperty("spring.application.name"));
        try {
            WebSocketServer.sendToUser("1001", "测试发送消息");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

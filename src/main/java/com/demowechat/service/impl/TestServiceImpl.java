package com.demowechat.service.impl;

import com.demowechat.service.TestService;
import com.demowechat.test.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public String getPayType(String type) {
        return type;
    }


}

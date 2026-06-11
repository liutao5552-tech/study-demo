package com.demowechat.service.impl;

import com.demowechat.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public String getPayType(String type) {
        return type;
    }


}

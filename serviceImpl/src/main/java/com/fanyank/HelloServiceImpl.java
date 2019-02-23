package com.fanyank;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String msg) {
        System.out.println(msg);
    }
}

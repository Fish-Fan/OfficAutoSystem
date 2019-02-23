package com.fanyank;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
        HelloService service = (HelloService) ctx.getBean("helloService");
        service.sayHello("hahaa");
        System.in.read();
    }
}

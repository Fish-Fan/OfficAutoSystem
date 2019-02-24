package com.fanyank;

import com.fanyank.service.AttendanceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:application*.xml");
        System.in.read();
    }
}

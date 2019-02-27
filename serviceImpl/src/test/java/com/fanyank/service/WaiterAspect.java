package com.fanyank.service;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WaiterAspect {
    @AfterReturning(value = "target(com.fanyank.service.NotifyService)")
    public void afterGreet() {
        System.out.println("after()======");
    }
}

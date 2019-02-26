package com.fanyank.service;

public class NaiveWaiter implements Waiter {
    @Override
    public String greetTo(String name) {
        System.out.println("navie waiter is greet to guest:" + name);
        return name;
    }
}

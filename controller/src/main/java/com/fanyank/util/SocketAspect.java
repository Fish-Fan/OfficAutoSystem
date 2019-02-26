package com.fanyank.util;

import com.alibaba.fastjson.JSON;
import com.fanyank.pojo.Notify;
import com.fanyank.socket.SocketHandler;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;

@Aspect
public class SocketAspect {
    @Autowired
    private SocketHandler socketHandler;

    @AfterReturning(value="target(com.fanyank.util.NotifySocketHelper)",returning="notify")
    public void sendMessageToUser(Notify notify) {
        System.out.println("abcdef");
        socketHandler.sendMessageToUser(notify.getUserId(),new TextMessage(JSON.toJSONString(notify)));
    }

    @Before("target(com.fanyank.controller.UserController)")
    public void test() {
        System.out.println("Before userController ... ");
    }
}

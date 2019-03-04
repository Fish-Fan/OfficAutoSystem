package com.fanyank.util;

import com.alibaba.fastjson.JSON;
import com.fanyank.pojo.Notify;
import com.fanyank.socket.SocketHandler;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

@Aspect
@Component
public class SocketAspect {
    @Autowired
    private SocketHandler socketHandler;

    @AfterReturning(value="target(com.fanyank.service.NotifyService)",returning="notify")
    public void sendMessageToUser(Notify notify) {
        socketHandler.sendMessageToUser(notify.getUserId(),new TextMessage(JSON.toJSONString(notify)));
    }
}

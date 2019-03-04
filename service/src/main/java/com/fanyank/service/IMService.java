package com.fanyank.service;

import com.fanyank.pojo.Department;
import com.fanyank.pojo.IMMessage;
import com.fanyank.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketMessage;

import java.util.List;

@Service
public interface IMService {
    /**
     * 获取主面板个人信息
     * @param id
     * @return
     */
    public User getOwnMessage(Integer id);

    /**
     * 获取主面板成员信息
     * @param id
     * @return
     */
    public List<Department> getMemberMessage(Integer id);

    /**
     * 处理私聊信息
     * @param webSocketMessage
     * @return
     */
    public IMMessage handleFriendMessage(WebSocketMessage<?> webSocketMessage);
}

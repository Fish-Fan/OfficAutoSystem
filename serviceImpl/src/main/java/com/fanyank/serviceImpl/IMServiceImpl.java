package com.fanyank.serviceImpl;

import com.fanyank.mapper.DepartmentMapper;
import com.fanyank.mapper.IMMessageMapper;
import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.Department;
import com.fanyank.pojo.IMMessage;
import com.fanyank.pojo.User;
import com.fanyank.service.IMService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.WebSocketMessage;

import java.util.Date;
import java.util.List;

@Repository
public class IMServiceImpl implements IMService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private IMMessageMapper imMessageMapper;

    @Override
    public User getOwnMessage(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<Department> getMemberMessage(Integer id) {
        List<Department> departmentList = departmentMapper.getDepartmentMessage();
        for(Department department : departmentList) {
            //设置主面板分组名
            department.setGroupname(department.getDepartment());
            //主面板好友列表排除自己
            List<User> currentUserList = department.getList();
            User forRemove = null;
            for(User user : currentUserList) {
                if(user.getId() == id) {
                    forRemove = user;
                    break;
                }
            }
            if(forRemove != null) {
                currentUserList.remove(forRemove);
                department.setList(currentUserList);
            }
        }
        return departmentList;
    }

    @Override
    public IMMessage handleFriendMessage(WebSocketMessage<?> webSocketMessage) {
        Gson gson = new Gson();
        IMMessage imMessage = gson.fromJson(webSocketMessage.getPayload().toString(),IMMessage.class);
        imMessage.setTimestamp(new Date().getTime());
        imMessageMapper.insert(imMessage);

        //消息反转
        IMMessage newMessage = new IMMessage();
        newMessage.setContent(imMessage.getContent());
        newMessage.setFromid(imMessage.getId());
        newMessage.setAvatar(imMessage.getAvatar());
        newMessage.setType("friend");
        newMessage.setId(imMessage.getFromid());
        newMessage.setUsername(imMessage.getUsername());
        newMessage.setTimestamp(new Date().getTime());
        newMessage.setMine(false);
        return newMessage;
    }
}

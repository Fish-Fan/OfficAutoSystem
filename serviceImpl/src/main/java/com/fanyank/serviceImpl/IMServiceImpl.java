package com.fanyank.serviceImpl;

import com.fanyank.mapper.DepartmentMapper;
import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.Department;
import com.fanyank.pojo.User;
import com.fanyank.service.IMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IMServiceImpl implements IMService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

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
}

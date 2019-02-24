package com.fanyank.serviceImpl;

import com.fanyank.mapper.DepartmentMapper;
import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.DepartmentInfo;
import com.fanyank.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/3/7.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    private User user;

    public int insertUser(User user){
        int r1 = userMapper.insertUser(user);
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());
        return 0;
    }
    public User selectUserByUsername(String username){
        return userMapper.selectUserByUsername(username);
    }
    public int updateSignByUsername(String username){
        return userMapper.updateSignByUsername(username);
    }
    public User selectMessageByUsername(String username){
       return userMapper.selectMessageByUsername(username);
    }
    public int updateMessageByUsername(User user){return userMapper.updateMessageByUsername(user);}
    public int exitSignByUsername(String username){return userMapper.exitSignByUsername(username);}
    public User selectUserByEmail(String email){return userMapper.selectUserByEmail(email);}
    public  int updatePasswordByEmail(User user){return userMapper.updatePasswordByEmail(user);}
    public int updatePasswordByUsername(User user){return userMapper.updatePasswordByUsername(user);}
    /**
     * created by fanyank
     * @param id
     * @return
     */
    public List<User> findByLikeId(int id) {
        return userMapper.findByLikeId(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(int id){
        return userMapper.findById(id);
    }

    /**
     * 获取用户的上级
     */
    public User getUserLeader(User user) {
        Integer departmentId = user.getDepartmentId();
        DepartmentInfo info = departmentMapper.findByDepartmentId(departmentId);
        if(user.getPositionId() == 1) {
            return info.getManager();
        } else {
            return info.getBoss();
        }
    }
}

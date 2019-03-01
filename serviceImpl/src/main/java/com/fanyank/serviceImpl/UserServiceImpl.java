package com.fanyank.serviceImpl;

import com.fanyank.mapper.DepartmentMapper;
import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.DepartmentInfo;
import com.fanyank.pojo.User;
import com.fanyank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService{
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
    public int setOnlineStatusByUsername(String username){
        return userMapper.setOnlineStatusByUsername(username);
    }
    public User selectMessageByUsername(String username){
       return userMapper.selectMessageByUsername(username);
    }
    public int updateMessageByUsername(User user){return userMapper.updateMessageByUsername(user);}
    public int setExitStatusByUsername(String username){return userMapper.setExitStatusByUsername(username);}
    public int setHideStatusByUsername(String username) {
        return userMapper.setHideStatusByUsername(username);
    }
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

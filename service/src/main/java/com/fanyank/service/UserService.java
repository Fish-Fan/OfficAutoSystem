package com.fanyank.service;

import com.fanyank.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public int insertUser(User user);

    public User selectUserByUsername(String username);

    public int updateSignByUsername(String username);

    public User selectMessageByUsername(String username);

    public int updateMessageByUsername(User user);

    public int exitSignByUsername(String username);

    public User selectUserByEmail(String email);

    public  int updatePasswordByEmail(User user);

    public int updatePasswordByUsername(User user);

    public List<User> findByLikeId(int id);

    public List<User> findAll();

    public User findById(int id);

    /**
     * 获取用户的上级
     */
    public User getUserLeader(User user);
}

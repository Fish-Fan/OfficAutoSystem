package com.fanyank.mapper;

import com.fanyank.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lenovo on 2018/3/7.
 */
@Component
public interface UserMapper {
    int insertUser(User user);
    User selectUserByUsername(String username);
    User selectMessageByUsername(String username);
    int updateMessageByUsername(User user);
    int  setOnlineStatusByUsername(String username);
    int setExitStatusByUsername(String username);
    int setHideStatusByUsername(String username);
    User selectUserByEmail(String email);
    int updatePasswordByEmail(User user);
    int updatePasswordByUsername(User user);
    /**
     * created by fanyank
     * @param id
     * @return
     */
    List<User> findByLikeId(int id);

    List<User> findAll();
    User findById(int id);

    /**
     * 更新职员职位信息
     * @param user
     * @return
     */
    void updateUserPosition(User user);

    List<User> findUserByDepartment(Integer departmentId);
}

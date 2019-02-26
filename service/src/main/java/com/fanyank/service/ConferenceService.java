package com.fanyank.service;

import com.fanyank.pojo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ConferenceService {

    /**
     * 获取所有会议室
     * @return
     */
    public List<ConferenceRoom> getAllRoom();
    /**
     * 获取所有会议类型
     * @return
     */
    public List<ConferenceType> getAllType();

    /**
     * 存储会议
     */
    public Conference saveConference(Conference conference);

    /**
     * 查找所有会议
     */
    public List<Conference> findAll();
    /**
     * 变更会议状态
     */
    public void updateConferenceStatus(Conference conference);

    /**
     * 根据ID查找会议
     */
    public Conference findById(Integer id);

    /**
     * 获取用户的上级
     */
    public User getUserLeader(User user);

    /**
     * 查找会议相关成员
     * @param conferenceId
     * @return
     */
    public List<ConferenceMember> findAttendMember(Integer conferenceId);
}

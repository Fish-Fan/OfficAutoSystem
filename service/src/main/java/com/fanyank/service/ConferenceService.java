package com.littlepig.service;

import com.alibaba.fastjson.JSON;
import com.littlepig.mapper.ConferenceMapper;
import com.littlepig.mapper.DepartmentMapper;
import com.littlepig.mapper.UserMapper;
import com.littlepig.pojo.*;
import com.littlepig.socket.SocketHandler;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceService {
    @Autowired
    private ConferenceMapper conferenceMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NotifyService notifyService;

    /**
     * 获取所有会议室
     * @return
     */
    public List<ConferenceRoom> getAllRoom() {
        return conferenceMapper.getAllRoom();
    }

    /**
     * 获取所有会议类型
     * @return
     */
    public List<ConferenceType> getAllType() {
        return conferenceMapper.getAllType();
    }

    /**
     * 存储会议
     */
    public void saveConference(Conference conference) {
        String[] members = conference.getPersons().split(",");
        List<ConferenceMember> memberList = new ArrayList<>();

        User user = userMapper.findById(conference.getUserId());
        User leader = getUserLeader(user);
        conference.setRespondentId(leader.getId());
        conference.setDate(LocalDate.now().toString());
        conference.setStatusId(0);
        conference.setCreateTime(DateTime.now().toString("yyyy/MM/dd HH:mm:ss"));
        conferenceMapper.saveConference(conference);
        for(int i = 0;i < members.length;i++) {
            Integer memberId = Integer.parseInt(members[i]);
            memberList.add(new ConferenceMember(conference.getId(),memberId));
        }
        conferenceMapper.saveMember(memberList);
    }

    /**
     * 查找所有会议
     */
    public List<Conference> findAll() {
        return conferenceMapper.findAll();
    }

    /**
     * 变更会议状态
     */
    public void updateConferenceStatus(Conference conference) {
        if(conference.getStatusId() == 1) {
            conferenceMapper.updateConferenceStatus(conference);
            List<ConferenceMember> memberList = findAttendMember(conference.getId());
            for(ConferenceMember member : memberList) {
                notifyService.memberAttendConference(member.getMemberId(),conference);
            }
        } else {
            conferenceMapper.updateConferenceStatus(conference);
        }

    }

    /**
     * 根据ID查找会议
     */
    public Conference findById(Integer id) {
        return conferenceMapper.findById(id);
    }

    /**
     * 获取用户的上级
     */
    public User getUserLeader(User user) {
        Integer departmentId = user.getDepartment().getId();
        DepartmentInfo info = departmentMapper.findByDepartmentId(departmentId);
        if(user.getPositionId() == 1) {
            return info.getManager();
        } else {
            return info.getBoss();
        }
    }

    /**
     * 查找会议相关成员
     * @param conferenceId
     * @return
     */
    public List<ConferenceMember> findAttendMember(Integer conferenceId) {
        return conferenceMapper.findAttendMember(conferenceId);
    }
}

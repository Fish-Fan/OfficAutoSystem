package com.littlepig.service;

import com.alibaba.fastjson.JSON;
import com.littlepig.mapper.DepartmentMapper;
import com.littlepig.mapper.PositionMapper;
import com.littlepig.mapper.UserMapper;
import com.littlepig.pojo.*;
import com.littlepig.socket.SocketHandler;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private SocketHandler socketHandler;

    /**
     * 主管，经理进行职位调度
     */
    public int insertPositionApply(PositionApplication positionApplication,User current_user) {
        //如果当前用户是经理，直接通过
        //如果是主管，还需经经理审批
        if(current_user.getPosition().getId() == 3) {
            positionApplication.setConclusion("成功");
            positionApplication.setBossResultTime(DateTime.now().toString("yyyy:MM:dd HH:mm:ss"));
            positionMapper.insertPositionApply(positionApplication);
            User user = userMapper.findById(positionApplication.getUserId());
            user.setPositionId(positionApplication.getPositionId());
            userMapper.updateUserPosition(user);
        } else {
            positionApplication.setDepartmentManagerAdvice(1);
            positionApplication.setReason("主管直接提拔");
            positionApplication.setManagerResultTime(DateTime.now().toString("yyyy:MM:dd HH:mm:ss"));
            positionMapper.insertPositionApply(positionApplication);
        }
        return positionApplication.getId();
    }

    /**
     * 万能的(反正就是插入apply信息)
     */
    public void memberApplyPosition(PositionApplication positionApplication,User applyMember) {
        User leader = getUserLeader(applyMember);
        positionApplication.setRespondentId(leader.getId());
        positionMapper.insertPositionApply(positionApplication);
    }

    /**
     * 查找所有职位
     */
    public List<Position> findAllPosition() {
        return positionMapper.findAllPosition();
    }

    /**
     * 查看某部门职位申请信息
     * @param user -> 当前用户
     * @return
     */
    public List<PositionApplication> findPositionApply(User user) {
        return positionMapper.findPositionApply(user);
    }

    /**
     * 根据ID查找职位申请信息
     * @param id
     * @return
     */
    public PositionApplication findApplyById(Integer id) {
        return positionMapper.findApplyById(id);
    }

    /**
     * 经理同意职位变动
     * @param positionApplication
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void bossAgreePositionApply(PositionApplication positionApplication) {
        //更新applyInfo表
        positionApplication.setDepartmentBossAdvice(1);
        positionApplication.setConclusion("成功");
        positionApplication.setBossResultTime(DateTime.now().toString("yyyy:MM:dd HH:mm:ss"));
        positionMapper.updateApplyInfo(positionApplication);

        //更新departmentInfo表
        DepartmentInfo info = departmentMapper.findByDepartmentId(positionApplication.getDepartmentId());
        if(positionApplication.getPositionId() == 2) {
            info.setDepartmentManagerId(positionApplication.getUserId());
        } else {
            info.setDepartmentBossId(positionApplication.getUserId());
        }
        departmentMapper.updateDepartmentInfo(info);

        //更新user表
        User user = positionApplication.getUser();
        user.setPositionId(positionApplication.getPositionId());
        userMapper.updateUserPosition(user);
    }

    /**
     * 经理拒绝职位变动
     * @param positionApplication
     */
    public void bossRejectPositionApply(PositionApplication positionApplication) {
        positionApplication.setDepartmentBossAdvice(0);
        positionApplication.setConclusion("失败");
        positionApplication.setBossResultTime(DateTime.now().toString("yyyy:MM:dd HH:mm:ss"));
        positionMapper.updateApplyInfo(positionApplication);
    }

    /**
     * 主管同意职位变动
     * @param positionApplication
     */
    public void managerAgreePositionApply(PositionApplication positionApplication) {
        positionApplication.setDepartmentManagerAdvice(1);
        positionApplication.setManagerResultTime(DateTime.now().toString("yyyy:MM:dd HH:mm:ss"));
        positionMapper.updateApplyInfo(positionApplication);
    }

    /**
     * 经理拒绝职位变动
     * @param positionApplication
     */
    public void managerRejectPositionApply(PositionApplication positionApplication) {
        positionApplication.setDepartmentManagerAdvice(0);
        positionApplication.setManagerResultTime(DateTime.now().toString("yyyy:MM:dd HH:mm:ss"));
        positionMapper.updateApplyInfo(positionApplication);
    }

    /**
     * 根据respondentId查找申请信息
     * @param respondentId
     * @return
     */
    public List<PositionApplication> findApplyInfoByRespondentId(Integer respondentId) {
        return positionMapper.findByRespondentId(respondentId);
    }

    /**
     * 获取用户的上级
     */
    public User getUserLeader(User user) {
        Integer departmentId = user.getDepartment().getId();
        DepartmentInfo info = departmentMapper.findByDepartmentId(departmentId);
        if(user.getPosition().getId() == 1) {
            return info.getManager();
        } else {
            return info.getBoss();
        }
    }



}

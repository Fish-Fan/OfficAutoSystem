package com.fanyank.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.fanyank.mapper.NotifyMapper;
import com.fanyank.pojo.Conference;
import com.fanyank.pojo.Notify;
import com.fanyank.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotifyServiceImpl implements NotifyService{
    @Autowired
    private NotifyMapper notifyMapper;

    /**
     * 会议申请通知
     * @param targetId
     */
    public Notify conferenceApplyRequest(Integer targetId) {
        Notify notify = Notify.conferenceApplyRequest(targetId);
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }

    /**
     * 会议申请状态变更通知
     * @param targetId
     * @param url
     */
    public Notify conferenceApplyResponse(Integer targetId,String url) {
        Notify notify = Notify.conferenceApplyResponse(targetId,url);
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }

    /**
     * 通知成员参加会议
     * @param targetId
     * @param conference
     */
    public Notify memberAttendConference(Integer targetId, Conference conference) {
        Notify notify = Notify.notifyMemberAttendConference(targetId,conference);
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }

    /**
     * 管理层对成员进行职位调整
     * @param targetId
     */
    public Notify managerAdjustMemberPosition(Integer targetId) {
        Notify notify = Notify.positionAdjustByManagerResponse(targetId,"/personal_message");
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }

    /**
     * 用户申请职位升迁
     * @param targetId
     * @param respondPositionId
     */
    public Notify positionApplyRequest(Integer targetId,Integer respondPositionId) {
        Notify notify;
        if(respondPositionId == 2) {
            notify = Notify.positionApplyRequest(targetId,"/position/applyinfo/manager");
        } else {
            notify = Notify.positionApplyRequest(targetId,"/position/applyinfo/boss");
        }
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }

    /**
     * 管理层对职位申请作出相应
     * @param targetId
     * @param url
     */
    public Notify positionApplyResponse(Integer targetId,String url) {
        Notify notify = Notify.positionApplyResponse(targetId,url);
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }

    //申请请假通知
    public Notify leaveApplyRequest(Integer targetId) {
        Notify notify = Notify.leaveApplyRequest(targetId);
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }
    //请假批准通知
    public Notify leaveApplyResponse(Integer targetId) {
        Notify notify = Notify.leaveApplyResponse(targetId);
        notifyMapper.insertIntoNotify(notify);
        notify.setUserId(targetId);
        return notify;
    }

    public void updateNotify(Integer id) {
        notifyMapper.updateById(id);
    }

    public List<Notify> getNotifyListByUserId(Integer userId) {
        return notifyMapper.findByUserId(userId);
    }
}

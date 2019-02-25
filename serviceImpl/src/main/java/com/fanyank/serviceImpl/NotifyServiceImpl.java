package com.fanyank.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.fanyank.mapper.NotifyMapper;
import com.fanyank.pojo.Conference;
import com.fanyank.pojo.Notify;
import com.fanyank.service.NotifyService;
import com.fanyank.socket.SocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.List;

@Service
public class NotifyServiceImpl implements NotifyService{
    @Autowired
    private NotifyMapper notifyMapper;

    /**
     * 会议申请通知
     * @param targetId
     */
    public void conferenceApplyRequest(Integer targetId,SocketHandler socketHandler) {
        Notify notify = Notify.conferenceApplyRequest(targetId);
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }

    /**
     * 会议申请状态变更通知
     * @param targetId
     * @param url
     */
    public void conferenceApplyResponse(Integer targetId,String url,SocketHandler socketHandler) {
        Notify notify = Notify.conferenceApplyResponse(targetId,url);
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }

    /**
     * 通知成员参加会议
     * @param targetId
     * @param conference
     */
    public void memberAttendConference(Integer targetId, Conference conference,SocketHandler socketHandler) {
        Notify notify = Notify.notifyMemberAttendConference(targetId,conference);
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }

    /**
     * 管理层对成员进行职位调整
     * @param targetId
     */
    public void managerAdjustMemberPosition(Integer targetId,SocketHandler socketHandler) {
        Notify notify = Notify.positionAdjustByManagerResponse(targetId,"/personal_message");
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }

    /**
     * 用户申请职位升迁
     * @param targetId
     * @param respondPositionId
     */
    public void positionApplyRequest(Integer targetId,Integer respondPositionId,SocketHandler socketHandler) {
        Notify notify;
        if(respondPositionId == 2) {
            notify = Notify.positionApplyRequest(targetId,"/position/applyinfo/manager");
        } else {
            notify = Notify.positionApplyRequest(targetId,"/position/applyinfo/boss");
        }
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }

    /**
     * 管理层对职位申请作出相应
     * @param targetId
     * @param url
     */
    public void positionApplyResponse(Integer targetId,String url,SocketHandler socketHandler) {
        Notify notify = Notify.positionApplyResponse(targetId,url);
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }

    //申请请假通知
    public void leaveApplyRequest(Integer targetId,SocketHandler socketHandler) {
        Notify notify = Notify.leaveApplyRequest(targetId);
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }
    //请假批准通知
    public void leaveApplyResponse(Integer targetId,SocketHandler socketHandler) {
        Notify notify = Notify.leaveApplyResponse(targetId);
        notifyMapper.insertIntoNotify(notify);
        socketHandler.sendMessageToUser(targetId,new TextMessage(JSON.toJSONString(notify)));
    }

    public void updateNotify(Integer id) {
        notifyMapper.updateById(id);
    }

    public List<Notify> getNotifyListByUserId(Integer userId) {
        return notifyMapper.findByUserId(userId);
    }
}

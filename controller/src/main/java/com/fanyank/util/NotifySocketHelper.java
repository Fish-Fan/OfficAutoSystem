package com.fanyank.util;

import com.fanyank.pojo.Conference;
import com.fanyank.pojo.Notify;
import com.fanyank.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 由于RPC框架的限制，使得原本的AOP增强失效，故在此做一层service的封装为AOP服务
 */
@Component
public class NotifySocketHelper {
    @Autowired
    private NotifyService notifyService;

    /**
     * 会议申请通知
     * @param targetId
     */
    public Notify conferenceApplyRequest(Integer targetId) {
       return notifyService.conferenceApplyRequest(targetId);
    }

    /**
     * 会议申请状态变更通知
     * @param targetId
     * @param url
     */
    public Notify conferenceApplyResponse(Integer targetId,String url) {
        return notifyService.conferenceApplyResponse(targetId,url);
    }

    /**
     * 通知成员参加会议
     * @param targetId
     * @param conference
     */
    public Notify memberAttendConference(Integer targetId, Conference conference) {
        return notifyService.memberAttendConference(targetId,conference);
    }

    /**
     * 管理层对成员进行职位调整
     * @param targetId
     */
    public Notify managerAdjustMemberPosition(Integer targetId) {
        return notifyService.managerAdjustMemberPosition(targetId);
    }

    /**
     * 用户申请职位升迁
     * @param targetId
     * @param respondPositionId
     */
    public Notify positionApplyRequest(Integer targetId,Integer respondPositionId) {
        return notifyService.positionApplyRequest(targetId,respondPositionId);
    }

    /**
     * 管理层对职位申请作出相应
     * @param targetId
     * @param url
     */
    public Notify positionApplyResponse(Integer targetId,String url) {
       return notifyService.positionApplyResponse(targetId,url);
    }

    //申请请假通知
    public Notify leaveApplyRequest(Integer targetId) {
        return notifyService.leaveApplyRequest(targetId);
    }
    //请假批准通知
    public Notify leaveApplyResponse(Integer targetId) {
        return notifyService.leaveApplyResponse(targetId);
    }
}

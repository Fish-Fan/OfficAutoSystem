package com.fanyank.service;


import com.fanyank.pojo.Conference;
import com.fanyank.pojo.Notify;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface NotifyService {

    /**
     * 会议申请通知
     * @param targetId
     */
    public Notify conferenceApplyRequest(Integer targetId);

    /**
     * 会议申请状态变更通知
     * @param targetId
     * @param url
     */
    public Notify conferenceApplyResponse(Integer targetId,String url);

    /**
     * 通知成员参加会议
     * @param targetId
     * @param conference
     */
    public Notify memberAttendConference(Integer targetId, Conference conference);

    /**
     * 管理层对成员进行职位调整
     * @param targetId
     */
    public Notify managerAdjustMemberPosition(Integer targetId);

    /**
     * 用户申请职位升迁
     * @param targetId
     * @param respondPositionId
     */
    public Notify positionApplyRequest(Integer targetId,Integer respondPositionId);

    /**
     * 管理层对职位申请作出相应
     * @param targetId
     * @param url
     */
    public Notify positionApplyResponse(Integer targetId,String url);

    //申请请假通知
    public Notify leaveApplyRequest(Integer targetId);

    //请假批准通知
    public Notify leaveApplyResponse(Integer targetId);

    public void updateNotify(Integer id);

    public List<Notify> getNotifyListByUserId(Integer userId);
}

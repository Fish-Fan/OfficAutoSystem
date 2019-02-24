package com.fanyank.service;


import com.fanyank.pojo.Conference;
import com.fanyank.pojo.Notify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface NotifyService {

    /**
     * 会议申请通知
     * @param targetId
     */
    public void conferenceApplyRequest(Integer targetId);

    /**
     * 会议申请状态变更通知
     * @param targetId
     * @param url
     */
    public void conferenceApplyResponse(Integer targetId,String url);

    /**
     * 通知成员参加会议
     * @param targetId
     * @param conference
     */
    public void memberAttendConference(Integer targetId, Conference conference);

    /**
     * 管理层对成员进行职位调整
     * @param targetId
     */
    public void managerAdjustMemberPosition(Integer targetId);

    /**
     * 用户申请职位升迁
     * @param targetId
     * @param respondPositionId
     */
    public void positionApplyRequest(Integer targetId,Integer respondPositionId);

    /**
     * 管理层对职位申请作出相应
     * @param targetId
     * @param url
     */
    public void positionApplyResponse(Integer targetId,String url);

    //申请请假通知
    public void leaveApplyRequest(Integer targetId);

    //请假批准通知
    public void leaveApplyResponse(Integer targetId);

    public void updateNotify(Integer id);

    public List<Notify> getNotifyListByUserId(Integer userId);
}

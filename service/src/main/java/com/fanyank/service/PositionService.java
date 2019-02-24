package com.fanyank.service;


import com.fanyank.pojo.Position;
import com.fanyank.pojo.PositionApplication;
import com.fanyank.pojo.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PositionService {

    /**
     * 主管，经理进行职位调度
     */
    public int insertPositionApply(PositionApplication positionApplication, User current_user);

    /**
     * 万能的(反正就是插入apply信息)
     */
    public void memberApplyPosition(PositionApplication positionApplication,User applyMember);

    /**
     * 查找所有职位
     */
    public List<Position> findAllPosition();
    /**
     * 查看某部门职位申请信息
     * @param user -> 当前用户
     * @return
     */
    public List<PositionApplication> findPositionApply(User user);

    /**
     * 根据ID查找职位申请信息
     * @param id
     * @return
     */
    public PositionApplication findApplyById(Integer id);

    /**
     * 经理同意职位变动
     * @param positionApplication
     */
    public void bossAgreePositionApply(PositionApplication positionApplication);

    /**
     * 经理拒绝职位变动
     * @param positionApplication
     */
    public void bossRejectPositionApply(PositionApplication positionApplication);
    /**
     * 主管同意职位变动
     * @param positionApplication
     */
    public void managerAgreePositionApply(PositionApplication positionApplication);

    /**
     * 经理拒绝职位变动
     * @param positionApplication
     */
    public void managerRejectPositionApply(PositionApplication positionApplication);

    /**
     * 根据respondentId查找申请信息
     * @param respondentId
     * @return
     */
    public List<PositionApplication> findApplyInfoByRespondentId(Integer respondentId);
    /**
     * 获取用户的上级
     */
    public User getUserLeader(User user);



}

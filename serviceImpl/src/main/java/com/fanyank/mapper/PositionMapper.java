package com.littlepig.mapper;

import com.littlepig.pojo.Position;
import com.littlepig.pojo.PositionApplication;
import com.littlepig.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lenovo on 2018/3/12.
 */
@Component
public interface PositionMapper {
    Position selectPositionById(int id);

    /**
     * 职位调度
     */
    void insertPositionApply(PositionApplication positionApplication);

    /**
     * 查找所有职位
     */
    List<Position> findAllPosition();

    /**
     * 查看某部门申请信息
     */
    List<PositionApplication> findPositionApply(User user);

    /**
     * 根据ID查找职位申请信息
     */
    PositionApplication findApplyById(Integer id);

    /**
     * 更新职位申请信息
     * @param positionApplication
     */
    void updateApplyInfo(PositionApplication positionApplication);

    /**
     * 根据respondentId查找申请信息
     * @param respondentId
     * @return
     */
    List<PositionApplication> findByRespondentId(Integer respondentId);
}

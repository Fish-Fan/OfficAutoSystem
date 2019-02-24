package com.fanyank.mapper;

import com.fanyank.pojo.Leave;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LeaveMapper {
	int insertLeave(Leave leave);
	int updateLeave(Leave leave);
	int deleteLeave(int userId);
	List<Leave> selectLeave(Leave leave);
	Leave selectLeaveById(Leave leave);
    int insertLeaveDraft(Leave leave);
	List<Leave> selectLeaveByStateAndDepartId(int departmentId);
}

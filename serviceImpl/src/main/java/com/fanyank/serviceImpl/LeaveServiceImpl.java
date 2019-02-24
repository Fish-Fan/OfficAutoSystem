package com.fanyank.serviceImpl;

import com.fanyank.mapper.LeaveMapper;
import com.fanyank.pojo.Leave;
import com.fanyank.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService{
    @Autowired
    LeaveMapper leaveMapper;

    public void InsertLeave(Leave leave){
        leaveMapper.insertLeave(leave);
    }
    public void deleteLeave(int userId){
        leaveMapper.deleteLeave(userId);
    }
    public void updateLeave(Leave leave){
        leaveMapper.updateLeave(leave);
    }
    public List<Leave> selectLeave(Leave leave){
        List<Leave> leaveList = leaveMapper.selectLeave(leave);
        return leaveList;
    }
    public Leave selectLeaveById(Leave leave){
        Leave leave1 = leaveMapper.selectLeaveById(leave);
        return leave1;
    }
    public void insertLeaveDraft(Leave leave) {
        leaveMapper.insertLeaveDraft(leave);
    }

    public List<Leave> selectLeaveByStateAndDepartId(int departmentId) {
        List<Leave> leaveList = leaveMapper.selectLeaveByStateAndDepartId(departmentId);
        return leaveList;
    }
}

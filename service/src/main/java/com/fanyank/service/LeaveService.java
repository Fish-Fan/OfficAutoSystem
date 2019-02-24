package com.fanyank.service;


import com.fanyank.pojo.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeaveService {

    public void InsertLeave(Leave leave);

    public void deleteLeave(int userId);

    public void updateLeave(Leave leave);

    public List<Leave> selectLeave(Leave leave);

    public Leave selectLeaveById(Leave leave);

    public void insertLeaveDraft(Leave leave);

    public List<Leave> selectLeaveByStateAndDepartId(int departmentId);
}

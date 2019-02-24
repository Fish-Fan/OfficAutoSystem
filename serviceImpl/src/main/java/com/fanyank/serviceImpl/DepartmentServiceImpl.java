package com.fanyank.serviceImpl;

import com.fanyank.mapper.DepartmentMapper;
import com.fanyank.pojo.DepartmentInfo;
import com.fanyank.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;

    public void insertDepartmentInfo(DepartmentInfo departmentInfo) {
        departmentMapper.insertDepartmentInfo(departmentInfo);
    }

    public void updateDepartmentInfo(DepartmentInfo departmentInfo) {
        departmentMapper.updateDepartmentInfo(departmentInfo);
    }

    public DepartmentInfo findByDepartmentId(Integer departmentId) {
        return departmentMapper.findByDepartmentId(departmentId);
    }

}

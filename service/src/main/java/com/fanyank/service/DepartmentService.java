package com.littlepig.service;

import com.littlepig.mapper.DepartmentMapper;
import com.littlepig.pojo.DepartmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
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

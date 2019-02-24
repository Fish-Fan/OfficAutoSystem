package com.fanyank.service;


import com.fanyank.pojo.DepartmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    public void insertDepartmentInfo(DepartmentInfo departmentInfo);

    public void updateDepartmentInfo(DepartmentInfo departmentInfo);

    public DepartmentInfo findByDepartmentId(Integer departmentId);

}

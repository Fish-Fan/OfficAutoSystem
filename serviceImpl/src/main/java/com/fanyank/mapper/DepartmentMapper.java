package com.littlepig.mapper;

import com.littlepig.pojo.Department;
import com.littlepig.pojo.DepartmentInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lenovo on 2018/3/12.
 */
@Component
public interface DepartmentMapper {
    Department selectDepartmentById(int id);

    void insertDepartmentInfo(DepartmentInfo departmentInfo);

    void updateDepartmentInfo(DepartmentInfo departmentInfo);

    DepartmentInfo findByDepartmentId(int departmentId);
}

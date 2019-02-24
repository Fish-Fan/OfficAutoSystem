package com.fanyank.service;

import com.fanyank.pojo.AttendanceStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceStandardService {


    public void insertAttendanceStandard(AttendanceStandard attendanceStandard);

    public void updateAttendanceStandard(AttendanceStandard attendanceStandard);

    public void deleteAttendanceStandard(int id);

    /*根据季节查找签到标准*/
    public AttendanceStandard selectAttendanceStandard(AttendanceStandard attendanceStandard);

    /*查找全部签到标准*/
    public List<AttendanceStandard> selectAllAttendanceStandard();

    /*根绝id查找签到标准*/
    public AttendanceStandard selectAttendanceStandardById(int id);
}

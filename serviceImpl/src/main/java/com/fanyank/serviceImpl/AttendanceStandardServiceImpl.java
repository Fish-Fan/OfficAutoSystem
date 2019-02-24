package com.fanyank.serviceImpl;

import com.fanyank.mapper.AttendanceStandardMapper;
import com.fanyank.pojo.AttendanceStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceStandardService {
    @Autowired
    AttendanceStandardMapper attendanceStandardMapper;

    public void insertAttendanceStandard(AttendanceStandard attendanceStandard){
        attendanceStandardMapper.insertAttendanceStandard(attendanceStandard);
    }
    public void updateAttendanceStandard(AttendanceStandard attendanceStandard){
        attendanceStandardMapper.updateAttendanceStandard(attendanceStandard);
    }
    public void deleteAttendanceStandard(int id){
        attendanceStandardMapper.deleteAttendanceStandard(id);
    }
    /*根据季节查找签到标准*/
    public AttendanceStandard selectAttendanceStandard(AttendanceStandard attendanceStandard){
        AttendanceStandard attendanceStandard1 = attendanceStandardMapper.selectAttendanceStandard(attendanceStandard);
        return attendanceStandard1;
    }
    /*查找全部签到标准*/
    public List<AttendanceStandard> selectAllAttendanceStandard(){
        List<AttendanceStandard> attendanceStandards = attendanceStandardMapper.selectAllAttendanceStandard();
        return attendanceStandards;
    }
    /*根绝id查找签到标准*/
    public AttendanceStandard selectAttendanceStandardById(int id){
        AttendanceStandard attendanceStandard = attendanceStandardMapper.selectAttendanceStandardById(id);
        return attendanceStandard;
    }
}

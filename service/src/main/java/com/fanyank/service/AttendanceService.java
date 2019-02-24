package com.fanyank.service;


import com.fanyank.pojo.Attendance;
import com.fanyank.pojo.AttendanceStandard;
import com.fanyank.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public interface AttendanceService {

    public void insertAttendance(Attendance attendance);

    public void updateAttendance(Attendance attendance);

    public List<Attendance> selectAttendance(Attendance attendance);

    public Attendance selectAttendanceBySignTime(Attendance attendance);

    public Attendance selectAttendanceBySignoutTime(Attendance attendance);

    public Integer selectMaxId();

    public Attendance selectAttendanceById(int id);


    //匹配成功进行员工签到
    public void executeUser(User user);

    /**
     * 获取签到标准
     * @param time
     * @return
     */
    public AttendanceStandard getSignStandard(Date time);

    /**
     * 用户进行签到操作
     * @param startTime
     * @param user
     */
    public void memberSignin(Date startTime,User user);

    /**
     * 用户进行签退操作
     * @param id
     * @param user
     */
    public void memberSignout(Integer id,User user);
}

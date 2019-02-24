package com.fanyank.serviceImpl;

import com.littlepig.mapper.AttendanceMapper;
import com.littlepig.pojo.Attendance;
import com.littlepig.pojo.AttendanceStandard;
import com.littlepig.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    AttendanceMapper attendanceMapper;
    @Autowired
    AttendanceStandardService attendanceStandardService;


    public void insertAttendance(Attendance attendance){
        attendanceMapper.insertAttendance(attendance);
    }
    public void updateAttendance(Attendance attendance){
        attendanceMapper.updateAttendance(attendance);
    }
    public List<Attendance> selectAttendance(Attendance attendance){
        List<Attendance> attendanceList =  attendanceMapper.selectAttendance(attendance);
        return attendanceList;
    }
    public Attendance selectAttendanceBySignTime(Attendance attendance){
        attendance = attendanceMapper.selectAttendanceBySignTime(attendance);
        return attendance;
    }
    public Attendance selectAttendanceBySignoutTime(Attendance attendance){
        attendance = attendanceMapper.selectAttendanceBySignoutTime(attendance);
        return attendance;
    }
    public Integer selectMaxId(){
        return attendanceMapper.selectMaxId();
    }

    public Attendance selectAttendanceById(int id) {
        return attendanceMapper.selectAttendanceById(id);
    }


    //匹配成功进行员工签到
    public void executeUser(User user){
        Date startTime = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Integer id = selectMaxId();
        if(id == null) {
            //执行签到操作
            memberSignin(startTime,user);
        } else {
            Attendance attendance1 = selectAttendanceById(id);
            System.out.println("::::::::::::"+attendance1.getAttendanceTime());

            String b=attendance1.getAttendanceTime().substring(0,10);
            memberSignin(startTime,user);
//            if(df1.format(startTime).equals(b)){
//                //执行签退操作
//                memberSignout(id,user);
//            }else{
//               //执行签到操作
//          memberSignin(startTime,user);
//            }
        }
    }

    /**
     * 获取签到标准
     * @param time
     * @return
     */
    public AttendanceStandard getSignStandard(Date time) {
        //员工是否迟到判断
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int month = cal.get(Calendar.MONTH) + 1;
        AttendanceStandard attendanceStandard = new AttendanceStandard();
        if(3<=month && month<=5){
            attendanceStandard.setSeason("spring");
        }else if(6<=month && month<=8){
            attendanceStandard.setSeason("summer");
        }else if(9<=month && month<=11){
            attendanceStandard.setSeason("autumn");
        }else if(12 == month || month<=2){
            attendanceStandard.setSeason("winter");
        }
        return attendanceStandardService.selectAttendanceStandard(attendanceStandard);
    }

    /**
     * 用户进行签到操作
     * @param startTime
     * @param user
     */
    public void memberSignin(Date startTime,User user) {
        //这是签到操作
        Attendance attendance = new Attendance();
        //员工签到时间获取
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        attendance.setAttendanceTime(df.format(startTime));
        //员工是否迟到判断
        AttendanceStandard attendanceStandard = getSignStandard(startTime);
        String workTime = attendanceStandard.getWorkTime();
        //比较签到时间startTime和签到标准workTime
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String st = sdf.format(startTime);//将签到时间startTime转换成String
        if (st.compareTo(workTime) < 0) {
            attendance.setStartStatusId(9);
        } else {
            attendance.setStartStatusId(5);
        }
        attendance.setUserId(user.getId());
        insertAttendance(attendance);
        //弹出签到成功消息
    }

    /**
     * 用户进行签退操作
     * @param id
     * @param user
     */
    public void memberSignout(Integer id,User user) {
        //这是签退操作
        Attendance attendance = new Attendance();
        //员工签退时间获取
        Date departureTime = new Date();
        SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        attendance.setDepartureTime(df.format(departureTime));
        //获取签到标准
        AttendanceStandard attendanceStandard = getSignStandard(departureTime);
        String closingTime = attendanceStandard.getClosingTime();
        //比较签退时间departureTime和签退标准closingTime
        SimpleDateFormat  sdf = new SimpleDateFormat("HH:mm:ss");
        String dt = sdf.format(departureTime);//将签退时间closingTime转换成String

        if(dt.compareTo(closingTime)<0){
            attendance.setDepartureStatusId(6);
        }else{
            attendance.setDepartureStatusId(9);
        }
        attendance.setId(id);
        attendance.setUserId(user.getId());
        updateAttendance(attendance);
    }
}

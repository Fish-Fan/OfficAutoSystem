package com.fanyank.controller;


import com.fanyank.pojo.Attendance;
import com.fanyank.pojo.AttendanceStandard;
import com.fanyank.pojo.User;
import com.fanyank.service.AttendanceService;
import com.fanyank.service.AttendanceStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AttendanceController {
	@Autowired
    AttendanceService attendanceService;
	@Autowired
    AttendanceStandardService attendanceStandardService;


	@GetMapping("/attendance")
    public String leave(Model model){
        Date startTime = new Date();
        //一天只能签到一次
        SimpleDateFormat  df1 = new SimpleDateFormat("yyyy-MM-dd");
        Integer id = attendanceService.selectMaxId();
        if(id != null) {
            Attendance attendance1 = attendanceService.selectAttendanceById(id);
            if(attendance1.getAttendanceTime() == null){
                model.addAttribute("isSign",0);
            }else{
                String b=attendance1.getAttendanceTime().substring(0,10);
                System.out.println("000000:::::"+b);
                System.out.println("1111111:::::::"+df1.format(startTime));
                if(df1.format(startTime).equals(b)){
                    model.addAttribute("isSign",1);
                }else{
                    model.addAttribute("isSign",0);
                }
             }
        }
        return "lyj/attendance/sign";
	}
	@GetMapping("/sign")
	public  String sign(Model model , HttpSession session){
        User user = (User)session.getAttribute("current_user");
        Date startTime = new Date();
            Attendance attendance = new Attendance();
            //员工签到时间获取
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            attendance.setAttendanceTime(df.format(startTime));
            //员工是否迟到判断
            Calendar cal = Calendar.getInstance();
            cal.setTime(startTime);
            int month = cal.get(Calendar.MONTH) + 1;
            AttendanceStandard attendanceStandard = new AttendanceStandard();
            if (3 <= month && month <= 5) {
                attendanceStandard.setSeason("spring");
            } else if (6 <= month && month <= 8) {
                attendanceStandard.setSeason("summer");
            } else if (9 <= month && month <= 11) {
                attendanceStandard.setSeason("autumn");
            } else if (12 <= month && month <= 2) {
                attendanceStandard.setSeason("winter");
            }
            System.out.println(attendanceStandard.getSeason());
            AttendanceStandard attendanceStandard1 = attendanceStandardService.selectAttendanceStandard(attendanceStandard);
            String workTime = attendanceStandard1.getWorkTime();
            //比较签到时间startTime和签到标准workTime
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String st = sdf.format(startTime);//将签到时间startTime转换成String
            if (st.compareTo(workTime) < 0) {
                attendance.setStartStatusId(9);
            } else {
                attendance.setStartStatusId(5);
            }
            attendance.setUserId(user.getId());
            attendanceService.insertAttendance(attendance);
            attendance = attendanceService.selectAttendanceBySignTime(attendance);
            model.addAttribute(attendance);
            return "lyj/attendance/sign";
	}

    @GetMapping("/signout")
    public  String signout(Model model,HttpSession session){
        User user = (User)session.getAttribute("current_user");
	    Attendance attendance = new Attendance();
        //员工签退时间获取
        Date departureTime = new Date();
        SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        attendance.setDepartureTime(df.format(departureTime));
        //员工是否迟到判断
        Calendar cal = Calendar.getInstance();
        cal.setTime(departureTime);
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
        AttendanceStandard attendanceStandard1 = attendanceStandardService.selectAttendanceStandard(attendanceStandard);
        String closingTime = attendanceStandard1.getClosingTime();
        //比较签退时间departureTime和签退标准closingTime
        SimpleDateFormat  sdf = new SimpleDateFormat("HH:mm:ss");
        String dt = sdf.format(departureTime);//将签退时间closingTime转换成String
        if(dt.compareTo(closingTime)<0){
            attendance.setDepartureStatusId(6);
        }else{
            attendance.setDepartureStatusId(9);
        }
        int id = attendanceService.selectMaxId();
        attendance.setId(id);
        attendance.setUserId(user.getId());
        attendanceService.updateAttendance(attendance);
        attendance  = attendanceService.selectAttendanceBySignoutTime(attendance);
        model.addAttribute(attendance);
        return "lyj/attendance/signout";
    }

	@GetMapping("selectAttendance")
	public  String  selectAttendance(Model model,Attendance attendance,HttpSession session){
        User user = (User)session.getAttribute("current_user");
        attendance.setUserId(user.getId());
        List<Attendance> attendances = attendanceService.selectAttendance(attendance);
        model.addAttribute("attendances",attendances);
        return "/lyj/attendance/attendancerecord";
	}



}

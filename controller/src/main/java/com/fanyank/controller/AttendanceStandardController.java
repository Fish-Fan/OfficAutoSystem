package com.fanyank.controller;


import com.fanyank.pojo.AttendanceStandard;
import com.fanyank.service.AttendanceStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AttendanceStandardController {
	@Autowired
    AttendanceStandardService attendanceStandardService;

	/*进入签到设置界面*/
	@GetMapping("/insertAttendanceStandard")
	public  String insertAttendanceStandardJSP(Model model, AttendanceStandard attendanceStandard){
		model.addAttribute("attendanceStandard",attendanceStandard);
		return "attendance/attendanceStandard";
	}
    @GetMapping("updateAttendanceStandard1")
    public  String updateAttendanceStandard1(@RequestParam("id") int id, Model model){
        AttendanceStandard attendanceStandard = attendanceStandardService.selectAttendanceStandardById(id);
        System.out.println("进入此方法并得到了该标准的值::::"+attendanceStandard.toString());
        model.addAttribute("attendanceStandard",attendanceStandard);
        return "attendance/attendanceStandard";
    }
    /*插入签到标准*/
	@PostMapping("/insertAttendanceStandard")
	public  String insertAttendanceStandard(Model model, AttendanceStandard attendanceStandard){
        System.out.println("我看一下这个签到标准的id：：：：：："+attendanceStandard.getId());
	    if (attendanceStandard.getId() == 0){
	        //插入签到标准
            System.out.println("*********对修改的标准进行插入插入插入**********");
            attendanceStandardService.insertAttendanceStandard(attendanceStandard);
	    }else{
	        //更新签到标准
            System.out.println("$$$$$$$$$$$$$对修改的标准进行修改$$$$$$$$$$$$$$$$");
            attendanceStandardService.updateAttendanceStandard(attendanceStandard);
        }
        List<AttendanceStandard> attendanceStandards = attendanceStandardService.selectAllAttendanceStandard();
        model.addAttribute("attendanceStandards",attendanceStandards);
		return "attendance/attendanceStandard";
	}
    /*更新签到标准*/
    @GetMapping("updateAttendanceStandard")
    @ResponseBody
    public  String updateAttendanceStandard(@RequestParam("id") int id, Model model){
        AttendanceStandard attendanceStandard = attendanceStandardService.selectAttendanceStandardById(id);
        model.addAttribute("attendanceStandard",attendanceStandard);
        return "{\"status\":\"success\"}";
    }

    /*查找所有签到标准*/
    @GetMapping("selectAttendanceStandard")
    public  String selectAttendanceStandard(Model model,AttendanceStandard attendanceStandard) {
        List<AttendanceStandard> attendanceStandards = attendanceStandardService.selectAllAttendanceStandard();
        model.addAttribute("attendanceStandards",attendanceStandards);
        return "attendance/attendanceStandardRecord";
    }

	/*删除指定签到标准*/
    @GetMapping("deleteAttendanceStandard")
    @ResponseBody
    public  String deleteAttendanceStandard(int id, Model model, AttendanceStandard attendanceStandard) {
        attendanceStandardService.deleteAttendanceStandard(id);
        List<AttendanceStandard> attendanceStandards = attendanceStandardService.selectAllAttendanceStandard();
        model.addAttribute("attendanceStandards",attendanceStandards);
        return "attendance/attendanceStandardRecord";
    }
}

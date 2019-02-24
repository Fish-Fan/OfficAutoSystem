package com.fanyank.controller;

import com.fanyank.pojo.Leave;
import com.fanyank.pojo.User;
import com.fanyank.service.DepartmentService;
import com.fanyank.service.LeaveService;
import com.fanyank.service.NotifyService;
import com.fanyank.service.UserService;
import com.fanyank.socket.SocketHandler;
import com.fanyank.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class LeaveController {
	@Autowired
    LeaveService leaveService;
	@Autowired
    UserService userService;
	@Autowired
    SocketHandler socketHandler;
	@Autowired
    DepartmentService departmentService;
	@Autowired
    NotifyService notifyService;

	//插入请假
    @GetMapping("insertLeave")
    public  String leave(Model model,Leave leave){
        model.addAttribute("token", QiniuUtil.getToken());
        model.addAttribute("leave",leave);
        return "lyj/leave/leave";
    }
    @GetMapping("insertLeave1")
    public String leave(Model model,Leave leave,@RequestParam("id") int id){
        leave.setId(id);
        Leave leave1 = leaveService.selectLeaveById(leave);
        System.out.println("测试一下有没有走到这一步：：：："+leave1.toString());
        //判断该申请是否可以修改
        if(leave1.getStatesId() == 0) {
            model.addAttribute("leave",leave1);
            return "lyj/leave/leave";
        }else {
            List<Leave> leaves = leaveService.selectLeave(leave);
            model.addAttribute("leaves",leaves);
            return "lyj/leave/leaverecord";
        }
    }
	@PostMapping("insertLeave")
	public  String insertLeave(Model model, Leave leave, HttpSession session){
        System.out.println(leave);
        User user1 = (User) session.getAttribute("current_user");
        leave.setUserId(user1.getId());//session获取userId，目前暂定1
        int userId = leave.getUserId();
        User respondUser = userService.getUserLeader(user1);
        if(leave.getId() != 0){
            leaveService.updateLeave(leave);
            notifyService.leaveApplyRequest(respondUser.getId());
        }else {
            User user = userService.findById(userId);
            leave.setDepartmentId(user.getDepartment().getId());
            leave.setRespondentId(respondUser.getId());
            leaveService.InsertLeave(leave);
            notifyService.leaveApplyRequest(respondUser.getId());
        }
        model.addAttribute("leave",new Leave());
		return "lyj/leave/leave";
	}
	//删除记录
	@GetMapping("deleteLeave")
    @ResponseBody
    public  String deleteleave(Model model,Leave leave){
	    int leaveId = leave.getId();
       leaveService.deleteLeave(leaveId);
       return "{\"status\":\"success\"}";
    }
    //更改未经领导批准或者不批准的请假请求
    @GetMapping("updateLeave")
    @ResponseBody
    public  String updateleave(@RequestParam("id") int id,HttpSession session,Model model,Leave leave){
        User user = (User)session.getAttribute("current_user");
        leave.setId(id);
        leave.setUserId(user.getId());
        Leave newLeave = leaveService.selectLeaveById(leave);
        return "{\"status\":\"success\"}";
    }
    //查找记录
    @GetMapping("selectLeave")
    public  String selectLeave(Model model,Leave leave,HttpSession session){
        User user = (User) session.getAttribute("current_user");
        leave.setUserId(user.getId());
        List<Leave> leaves = leaveService.selectLeave(leave);
        model.addAttribute("leaves",leaves);
        return "lyj/leave/leaverecord";
    }

    //查找leave记录的详情
    @GetMapping("selectLeaveById")
    public String selectLeaveById(Model model,@RequestParam("id") int id,Leave leave){
        System.out.println("**********进入查询请假详情*********");
        leave.setId(id);
        model.addAttribute("leave",leaveService.selectLeaveById(leave));
        return "lyj/leave/leave";
    }

    //带有权限的请假审批
    @GetMapping("leaveapproval")
    public  String leaveApproval1(Model model,HttpSession session){
        User user = (User) session.getAttribute("current_user");
        int departmentId = user.getDepartment().getId();
        List<Leave> leaves = leaveService.selectLeaveByStateAndDepartId(departmentId);//查询还未审批的请假记录
        model.addAttribute("leaves", leaves);
        return "lyj/leave/leaveapproval";
    }
    @GetMapping("approveLeave")
    public  String leaveApproval(@RequestParam("id") int id,Model model){
        Leave leave = new Leave();
        leave.setId(id);
        Leave leave1 = leaveService.selectLeaveById(leave);
        leave1.setStatesId(1);
        Date respondentTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        leave1.setRespondentTime(df.format(respondentTime));
        leaveService.updateLeave(leave1);
        System.out.println("6666666:::::"+leaveService.selectLeaveById(leave).getUserId());
        notifyService.leaveApplyResponse(leave1.getUserId());
        int departmentId = leave.getDepartmentId();
        List<Leave> leaves = leaveService.selectLeaveByStateAndDepartId(departmentId);//查询还未审批的请假记录
        model.addAttribute("leaves",leaves);
        return "lyj/leave/leaveapproval";
    }
    @GetMapping("disapproveLeave")
    public  String leaveDisapproval(@RequestParam("id") int id,Model model){
        Leave leave = new Leave();
        leave.setId(id);
        Leave leave1 = leaveService.selectLeaveById(leave);
        leave1.setStatesId(2);
        Date respondentTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        leave1.setRespondentTime(df.format(respondentTime));
        leaveService.updateLeave(leave1);
        notifyService.leaveApplyResponse(leave1.getUserId());
        int departmentId = leave.getDepartmentId();
        List<Leave> leaves = leaveService.selectLeaveByStateAndDepartId(departmentId);//查询还未审批的请假记录
        model.addAttribute("leaves",leaves);
        return "lyj/leave/leaveapproval";
    }

}

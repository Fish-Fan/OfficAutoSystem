package com.fanyank.controller;

import com.fanyank.pojo.Position;
import com.fanyank.pojo.PositionApplication;
import com.fanyank.pojo.User;
import com.fanyank.service.NotifyService;
import com.fanyank.service.PositionService;
import com.fanyank.service.UserService;
import com.fanyank.socket.SocketHandler;
import com.fanyank.util.QiniuUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotifyService notifyService;
    @Autowired
    private SocketHandler socketHandler;

    /**
     * 经理，主管调度职员界面
     * @param model
     * @return
     */
    @GetMapping("/position/control")
    public String positionManager(Model model) {
        model.addAttribute("positionList",positionService.findAllPosition());
        return "fyf/position/authorityManager";
    }

    @PostMapping("/position/control")
    public String getPositionForm(PositionApplication positionApplication, HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        int id = positionService.insertPositionApply(positionApplication,user);
        notifyService.managerAdjustMemberPosition(positionApplication.getUserId(),socketHandler);
        user.setCurrentPositionApplyId(id);
        userService.updateMessageByUsername(user);
        return "redirect:/position/applyinfo/manager";
    }

    /**
     * 查看调度信息页面
     * @param model
     * @return
     */
    @GetMapping("/position/applyinfo/boss")
    public String forwardPositionMessage(Model model,HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        List<PositionApplication> applyList = positionService.findPositionApply(user);
        model.addAttribute("applyList",applyList);
        return "fyf/position/bossCheckApplyMessage";
    }

    @GetMapping("/position/applyinfo/manager")
    public String forwardManagerPositionMessage(Model model,HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        model.addAttribute("user",user);
        model.addAttribute("applyList",positionService.findApplyInfoByRespondentId(user.getId()));
        return "fyf/position/managerCheckApplyMessage";
    }

    /**
     * 个人申请职位页面
     * @param model
     * @return
     */
    @GetMapping("/position/up")
    public String getPositionUpPage(Model model,HttpSession session) {
        List<Position> positionList = positionService.findAllPosition();
        User user = (User) session.getAttribute("current_user");
        System.out.println(user);
        model.addAttribute("token", QiniuUtil.getToken());
        model.addAttribute("positionList",positionList);
        model.addAttribute("user",user);
        return "fyf/position/applyPosition";
    }

    @PostMapping("/position/up")
    public String getApplyForm(PositionApplication positionApplication, HttpSession session,Model model) {
        User user = (User) session.getAttribute("current_user");
        positionApplication.setApplicationTime(DateTime.now().toString("yyyy/MM/dd HH:mm:ss"));
        positionService.memberApplyPosition(positionApplication,user);
        PositionApplication apply = positionService.findApplyById(positionApplication.getId());
        model.addAttribute("apply",apply);
        notifyService.positionApplyRequest(apply.getRespondentId(),apply.getRespond().getPositionId(),socketHandler);
        return "redirect:/position/afterapply?id=" + positionApplication.getId();
    }


    /**
     * 经理审批职位变动情况
     * @param id
     * @return
     */
    @GetMapping("/position/boss/advice/yes")
    @ResponseBody
    public String bossAdviceAgree(Integer id,HttpSession session) {
        PositionApplication positionApplication = positionService.findApplyById(id);
        User user = (User) session.getAttribute("current_user");
        positionService.bossAgreePositionApply(positionApplication);
        String url = "/position/afterapply?id=" + positionApplication.getId();
        notifyService.positionApplyResponse(positionApplication.getUserId(),url,socketHandler);
        return "{\"status\":\"success\"}";
    }

    @GetMapping("/position/boss/advice/reject")
    @ResponseBody
    public String bossAdviceReject(Integer id,HttpSession session) {
        PositionApplication positionApplication = positionService.findApplyById(id);
        User user = (User) session.getAttribute("current_user");
        positionService.bossRejectPositionApply(positionApplication);
        String url = "/position/afterapply?id=" + positionApplication.getId();
        notifyService.positionApplyResponse(positionApplication.getUserId(),url,socketHandler);
        return "{\"status\":\"success\"}";
    }

    /**
     * 主管审批职位变动情况
     * @param id
     * @return
     */
    @PostMapping("/position/manager/advice/yes")
    @ResponseBody
    public String managerAdviceAgree(Integer id,String reason) {
        PositionApplication positionApplication = positionService.findApplyById(id);
        positionApplication.setReason(reason);
        positionService.managerAgreePositionApply(positionApplication);
        String url = "/position/afterapply?id=" + positionApplication.getId();
        notifyService.positionApplyResponse(positionApplication.getUserId(),url,socketHandler);
        return "{\"status\":\"success\"}";
    }

    @PostMapping("/position/manager/advice/reject")
    @ResponseBody
    public String manAdviceReject(Integer id,String reason) {
        PositionApplication positionApplication = positionService.findApplyById(id);
        positionApplication.setReason(reason);
        positionService.managerRejectPositionApply(positionApplication);
        String url = "/position/afterapply?id=" + positionApplication.getId();
        notifyService.positionApplyResponse(positionApplication.getUserId(),url,socketHandler);
        return "{\"status\":\"success\"}";
    }

    @GetMapping("/position/afterapply")
    public String forwardResultPage(Integer id,Model model) {
        PositionApplication apply = positionService.findApplyById(id);
        model.addAttribute("apply",apply);
        return "fyf/position/afterApplyPosition";
    }

    @GetMapping("/timeline")
    public String forwardTimeLinePage() {
        return "fyf/timeline";
    }
}

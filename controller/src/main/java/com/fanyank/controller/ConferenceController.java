package com.fanyank.controller;


import com.fanyank.pojo.Conference;
import com.fanyank.pojo.User;
import com.fanyank.service.ConferenceService;
import com.fanyank.service.NotifyService;
import com.fanyank.service.UserService;
import com.fanyank.socket.SocketHandler;
import com.fanyank.util.QiniuUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotifyService notifyService;
    @Autowired
    private SocketHandler socketHandler;

    /**
     * 新建会议
     * @param model
     * @return
     */
    @GetMapping("/newconference")
    public String newConference(Model model) {
        model.addAttribute("token", QiniuUtil.getToken());
        model.addAttribute("roomList",conferenceService.getAllRoom());
        model.addAttribute("conferenceTypeList",conferenceService.getAllType());
        return "fyf/conference/conference";
    }

    @PostMapping("/newconference")
    public String afterNewConference(Conference conference, Model model, HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        conference.setUserId(user.getId());
        conferenceService.saveConference(conference);
        Conference afterSave = conferenceService.findById(conference.getId());
        model.addAttribute("conference",afterSave);
        //更新user表中的current_conference_apply_id
        user.setCurrentConferenceApplyId(conference.getId());
        userService.updateMessageByUsername(user);
        notifyService.conferenceApplyRequest(afterSave.getRespondentId(),socketHandler);
        return "redirect:/conference/result?id=" + conference.getId();
    }

    /**
     * 管理会议
     * @param model
     * @return
     */
    @GetMapping("/conference/manager")
    public String conferenceManager(Model model) {
        List<Conference> conferenceList = conferenceService.findAll();
        model.addAttribute("conferenceList",conferenceList);
        return "fyf/conference/conferenceManager";
    }

    /**
     * 批准会议
     */
    @GetMapping(value = "/conference/allow",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String allow(Integer id,Integer respondentId,HttpSession session) {
        Conference conference = conferenceService.findById(id);
        User user = (User) session.getAttribute("current_user");
        conference.setRespondentId(user.getId());
        conference.setStatusId(1);
        conference.setResultTime(DateTime.now().toString("yyyy/MM/dd HH:mm:ss"));
        conferenceService.updateConferenceStatus(conference,socketHandler);
        String url = "/conference/result?id=" + conference.getId();
        notifyService.conferenceApplyResponse(conference.getUserId(),url,socketHandler);
        return "{\"status\":\"success\"}";
    }

    /**
     * 拒绝批准
     */
    @PostMapping(value = "/conference/reject",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String reject(@RequestBody Conference conference,HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        conference.setRespondentId(user.getId());
        conference.setStatusId(2);
        conference.setResultTime(DateTime.now().toString("yyyy/MM/dd HH:mm:ss"));
        conferenceService.updateConferenceStatus(conference,socketHandler);
        String url = "/conference/result?id=" + conference.getId();
        Conference afterUpdate = conferenceService.findById(conference.getId());
        notifyService.conferenceApplyResponse(afterUpdate.getUserId(),url,socketHandler);
        return "success";
    }

    @GetMapping("/conference/result")
    public String conferenceResult(Integer id,Model model) {
        model.addAttribute("conference",conferenceService.findById(id));
        return "fyf/conference/afterConference";
    }



}

package com.littlepig.controller;

import com.littlepig.mapper.TopicMapper;
import com.littlepig.pojo.Comment;
import com.littlepig.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TopicController {
    @Autowired
    TopicService topicService;


//    @RequestMapping(value = "/topic")
//    public String findAllTopic(Model model,Integer nodeId){
//       model.addAttribute("node",topicService.findNodeById(nodeId));
//       model.addAttribute("topicList",topicService.findAllTopic());
//        return "css/forum_main";
//    }
//    @GetMapping(value = "111")
//    public String findComment(Model model,Integer topicId){
//        model.addAttribute("commentList",topicService.findCommentByTopicId(topicId));
//        return "css/forum_post";
//    }

}

package com.littlepig.controller;

import com.littlepig.pojo.Comment;
import com.littlepig.pojo.Topic;
import com.littlepig.pojo.User;
import com.littlepig.service.TopicService;
import com.littlepig.util.QiniuUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    TopicService topicService;

    @GetMapping("index")
    public String Index() {
        return "css/index";
    }




    @GetMapping("/standard")
    public String standard() {
        return "fyf/standard";
    }

    @GetMapping("/forum")
    public String forum(Model model) {

        model.addAttribute("topicList", topicService.findAllTopic());
        return "css/forum_main";
    }
    /**
     * 插入一条新得主题
     */
    @PostMapping("/newtopic")
    public String insertTopic(Topic topic, HttpSession httpSession,Model model) {
        model.addAttribute("node", topicService.findNodeById(topic.getId()));
        model.addAttribute("topicList", topicService.findAllTopic());
        User user = (User)httpSession.getAttribute("current_user");
        String time = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
        topic.setUserId(user.getId());
        topic.setCreateTime(time);
        topicService.insertTopic(topic);
        return "redirect:/forum";
    }




    @GetMapping(value = "/comment")
    public String comment(Model model,Integer topicId) {


        model.addAttribute("commentList",topicService.findCommentByTopicId2(topicId));
        model.addAttribute("topic",topicService.findTopicId(topicId));
        return "css/forum_post";
    }

    /**
     * 跳转到新得页面 插入一条新的话题
     */
    @GetMapping("/topic")
    public String findAllNode(Model model) {
        model.addAttribute("nodeList", topicService.findAllNode());
        model.addAttribute("token", QiniuUtil.getToken());
        return "css/topic";
    }




    /**
     * 插入一个新的回复
     */
    @PostMapping("/comment.do")
    public String insertComment(int topicId,String comment,int replyNumber,HttpSession session){
        Topic topic= new Topic();
        topic.setId(topicId);
        topic.setReplyNumber(replyNumber+1 );
//        获取topicId 和comment
        topicService.updateTopic(topic);
        Comment comment1 = new Comment();
        comment1.setCreateTime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        comment1.setComment(comment);
        comment1.setUserId(((User)session.getAttribute("current_user")).getId());
        comment1.setTopicId(topicId);
        topicService.insertComment(comment1);


        return "redirect:/comment?topicId="+topicId;

    }



}

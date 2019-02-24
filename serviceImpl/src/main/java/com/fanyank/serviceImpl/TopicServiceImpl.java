package com.fanyank.serviceImpl;

import com.fanyank.mapper.TopicMapper;
import com.fanyank.pojo.Comment;
import com.fanyank.pojo.Node;
import com.fanyank.pojo.Topic;
import com.fanyank.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{
    @Autowired
    private TopicMapper topicMapper;


    /**
     * 根据topic_id查找Node
     */
    public Node findNodeById(Integer a){
        return topicMapper.findNodeById(a);
    }

    /**
     * 根据topicid 查找comment
     * @param topicId
     * @return
     */
    public Comment findCommentByTopicId(Integer topicId){
        return topicMapper.findCommentByTopicId(topicId);
    }

    /**
     * 查找所有的topic
     * @return
     */
    public List<Topic> findAllTopic(){
        return topicMapper.findAllTopic();
    }
    /**
     * 查找所有的node
     */
    public List<Node> findAllNode(){
        return topicMapper.findAllNode();
    }

    /**
     * 查找出所有的comment
     */
    public List<Comment> findAllComment(){
        return topicMapper.findAllComment();
    }

    /**
     * 插入一条新的话题
     */
    public void insertTopic(Topic topic){
        topicMapper.insertTopic(topic);
    }

    /**
     * 插入一条新的评论
     */
    public void insertComment(Comment comment){
         topicMapper.insertComment(comment);
    }

    /**
     * 根据ID查找Topic
     */
    public Topic findTopicId(Integer id){
        return topicMapper.findTopicById(id);
    }
    /**
     * 更新topic表中的 reply_number
     */
    public void updateTopic(Topic topic){
        topicMapper.updateTopic(topic);
    }

    public Comment findCommentById(Integer id){
      return  topicMapper.findCommentById(id);
    }

    public List<Comment> findCommentByTopicId2(Integer id){
        return  topicMapper.findCommentByTopicId2(id);
    }
}

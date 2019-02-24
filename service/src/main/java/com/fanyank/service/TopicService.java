package com.fanyank.service;

import com.fanyank.pojo.Comment;
import com.fanyank.pojo.Node;
import com.fanyank.pojo.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {
    /**
     * 根据topic_id查找Node
     */
    public Node findNodeById(Integer a);

    /**
     * 根据topicid 查找comment
     * @param topicId
     * @return
     */
    public Comment findCommentByTopicId(Integer topicId);

    /**
     * 查找所有的topic
     * @return
     */
    public List<Topic> findAllTopic();
    /**
     * 查找所有的node
     */
    public List<Node> findAllNode();
    /**
     * 查找出所有的comment
     */
    public List<Comment> findAllComment();

    /**
     * 插入一条新的话题
     */
    public void insertTopic(Topic topic);
    /**
     * 插入一条新的评论
     */
    public void insertComment(Comment comment);

    /**
     * 根据ID查找Topic
     */
    public Topic findTopicId(Integer id);
    /**
     * 更新topic表中的 reply_number
     */
    public void updateTopic(Topic topic);

    public Comment findCommentById(Integer id);

    public List<Comment> findCommentByTopicId2(Integer id);
}

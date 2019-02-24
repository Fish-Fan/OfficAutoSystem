package com.littlepig.mapper;

import com.littlepig.pojo.Comment;
import com.littlepig.pojo.Node;
import com.littlepig.pojo.Topic;

import java.util.List;

public interface TopicMapper {
    /**
     * 根据topic_id查找Node
     */
    Node findNodeById(Integer topicId);

    /**
     * 根据topicId查找comment
     */
    Comment findCommentByTopicId(Integer topicId);

    /**
     * 根据TOPic id 查找comment
     */
    List<Comment> findCommentByTopicId2(Integer id);
    /**
     * 查找所有topic
     */
    List<Topic> findAllTopic();

    /**
     * 查找所有的node
     */
    List<Node> findAllNode();

    /**
     * 查找所有的comment
     */
    List<Comment> findAllComment();

    /**
     * 插入一条新的话题
     */
    void insertTopic(Topic topic);

    /**
     * 插入一条新的回复
     */
   void insertComment(Comment comment);

    /**
     * 更新topic表中的回复数
     */
    void updateTopic(Topic topic);

    /**
     * 根据ID查找Topic
     */
    Topic findTopicById(Integer id);

    Comment findCommentById(Integer id);

}

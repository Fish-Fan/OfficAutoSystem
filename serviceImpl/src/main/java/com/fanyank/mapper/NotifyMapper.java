package com.fanyank.mapper;

import com.fanyank.pojo.Notify;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NotifyMapper {
    void insertIntoNotify(Notify notify);

    List<Notify> findByUserId(Integer userId);

    void updateById(Integer id);
}

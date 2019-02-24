package com.fanyank.mapper;

import com.fanyank.pojo.Conference;
import com.fanyank.pojo.ConferenceMember;
import com.fanyank.pojo.ConferenceRoom;
import com.fanyank.pojo.ConferenceType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConferenceMapper {
    List<ConferenceRoom> getAllRoom();

    List<ConferenceType> getAllType();

    void saveConference(Conference conference);

    void saveMember(List<ConferenceMember> memberList);

    List<Conference> findAll();

    void updateConferenceStatus(Conference conference);

    Conference findById(Integer id);

    List<ConferenceMember> findAttendMember(Integer conferenceId);
}

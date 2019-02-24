package com.littlepig.mapper;

import com.littlepig.pojo.Conference;
import com.littlepig.pojo.ConferenceMember;
import com.littlepig.pojo.ConferenceRoom;
import com.littlepig.pojo.ConferenceType;
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

package com.littlepig.mapper;

import com.littlepig.pojo.Attendance;
import com.littlepig.pojo.States;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StatesMapper {
	States selectStates(int id);
}

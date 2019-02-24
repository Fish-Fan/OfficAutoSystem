package com.fanyank.mapper;

import com.fanyank.pojo.States;
import org.springframework.stereotype.Component;

@Component
public interface StatesMapper {
	States selectStates(int id);
}

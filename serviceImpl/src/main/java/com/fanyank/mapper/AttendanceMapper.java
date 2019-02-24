package com.fanyank.mapper;

import com.fanyank.pojo.Attendance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttendanceMapper {
	int insertAttendance(Attendance attendance);
	int updateAttendance(Attendance attendance);
	List<Attendance> selectAttendance(Attendance attendance);
	Attendance selectAttendanceBySignTime(Attendance attendance);
	Attendance selectAttendanceBySignoutTime(Attendance attendance);
	Integer selectMaxId();

    Attendance selectAttendanceById(int id);
}

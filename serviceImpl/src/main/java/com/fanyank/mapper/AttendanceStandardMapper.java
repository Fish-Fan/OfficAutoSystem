package com.littlepig.mapper;

import com.littlepig.pojo.AttendanceStandard;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttendanceStandardMapper {
	int insertAttendanceStandard(AttendanceStandard attendanceStandard);
	int updateAttendanceStandard(AttendanceStandard attendanceStandard);
	int deleteAttendanceStandard(int id);
	AttendanceStandard selectAttendanceStandard(AttendanceStandard attendanceStandard);
	List<AttendanceStandard> selectAllAttendanceStandard();

    AttendanceStandard selectAttendanceStandardById(int id);
}

package com.fanyank.pojo;

public class Attendance {
	int id;
	int userId;
	String attendanceTime;
	String departureTime;
	User user;
    int startStatusId;
    int departureStatusId;
	States startStatus;
	States departureStatus;

    public States getStartStatus() {
        return startStatus;
    }
    public States getDepartureStatus() {
        return departureStatus;
    }
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public int getStartStatusId() {
		return startStatusId;
	}
	public void setStartStatusId(int startStatusId) {
		this.startStatusId = startStatusId;
	}
	public int getDepartureStatusId() {
		return departureStatusId;
	}
	public void setDepartureStatusId(int departureStatusId) {
		this.departureStatusId = departureStatusId;
	}
}

package com.myssm.paul.service;


import com.myssm.paul.pojo.Schedule;

import java.util.List;

public interface ScheduleService {
	public void insertschedule(Schedule schedule);
	public List<Schedule> selectAll();
	public void deleteschedule(Integer id);
	public void updateschedule(Schedule schedule);
	public Schedule selectbyid(Integer id);
}

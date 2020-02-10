package com.myssm.paul.dao;


import com.myssm.paul.pojo.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScheduleMapper {
	public void insertschedule(Schedule schedule);
	public List<Schedule> selectAll();
	public void deleteschedule(Integer id);
	public void updateschedule(Schedule schedule);
	public Schedule selectbyid(Integer id);
}

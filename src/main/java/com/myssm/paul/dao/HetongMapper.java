package com.myssm.paul.dao;

import com.myssm.paul.pojo.Hetong;
import org.springframework.stereotype.Repository;

@Repository
public interface HetongMapper {
	
	public void inserthetong(Hetong hetong);
	public Hetong findhetong(String house_id);
	public void updatehetong(Hetong hetong);
	public void deletehetong(String house_id);
}

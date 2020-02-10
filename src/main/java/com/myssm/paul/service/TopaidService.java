package com.myssm.paul.service;



import com.myssm.paul.pojo.Paid;
import com.myssm.paul.pojo.QueryVo;
import com.myssm.paul.pojo.Topaid;

import java.util.List;

public interface TopaidService {
	public void inserttopaid(Topaid topaid);
	public List<Topaid> findtopaid(QueryVo vo);
	public Topaid findbyid(Integer id);
	public void gotopay(Integer id, Paid paid);
}

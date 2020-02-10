package com.myssm.paul.service;



import com.myssm.paul.pojo.Paid;
import com.myssm.paul.pojo.QueryVo;
import com.myssm.paul.pojo.Zulist;

import java.util.List;

public interface PaidService {
	public List<Paid> selectall(QueryVo vo);
	public Double selectsum(QueryVo vo);
	public void deletepaid(Integer id);
	public List<Zulist> findzuuserlist() throws Exception;
	public Zulist findzukezulist(Integer id);
	
}

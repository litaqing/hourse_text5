package com.myssm.paul.service;



import com.myssm.paul.pojo.QueryVo;
import com.myssm.paul.pojo.Solve;
import com.myssm.paul.pojo.Wrong;

import java.util.List;

public interface SolveService {
	public List<Solve> selectall(QueryVo vo);
	public Integer selectcount(QueryVo vo);
	public void deletesolve(Integer id);
	
	public List<Wrong> findwrong(QueryVo vo);
	public Wrong findbyid(Integer id);
	 public void insertwrong(Wrong wrong);
	 public void gotosolve(Integer id, Solve solve);
}

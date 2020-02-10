package com.myssm.paul.service;


import com.myssm.paul.dao.PaidMapper;
import com.myssm.paul.dao.ZulistMapper;
import com.myssm.paul.pojo.Paid;
import com.myssm.paul.pojo.QueryVo;
import com.myssm.paul.pojo.Zulist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaidServiceImpl implements PaidService {
	@Autowired
	private PaidMapper paidMapper;
	@Autowired
	private ZulistMapper zulistMapper;
	
	@Override
	public List<Paid> selectall(QueryVo vo) {
		List<Paid> list=paidMapper.selectall(vo);
		return list;
	}

	@Override
	public Double selectsum(QueryVo vo) {
		Double sum=paidMapper.selectsum(vo);
		return sum;
	}

	@Override
	public void deletepaid(Integer id) {
		paidMapper.deletepaid(id);
		
	}

	@Override
	public List<Zulist> findzuuserlist() throws Exception{
		List<Zulist> list=zulistMapper.findzuuserlist();
		return list;
	}

	@Override
	public Zulist findzukezulist(Integer id) {
		Zulist zulist=zulistMapper.findzukezulist(id);
		return zulist;
	}

	
}

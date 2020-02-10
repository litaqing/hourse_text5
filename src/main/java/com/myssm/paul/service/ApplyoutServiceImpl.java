package com.myssm.paul.service;


import com.myssm.paul.dao.*;
import com.myssm.paul.pojo.Applyout;
import com.myssm.paul.pojo.Checkout;
import com.myssm.paul.pojo.Zulist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApplyoutServiceImpl implements ApplyoutService {
	
	@Autowired
	private ApplyoutMapper applyoutMapper;
	@Autowired
	private HouselistMapper houselistMapper;
	@Autowired
	private HetongMapper hetongMapper;
	@Autowired
	private CheckoutMapper checkoutMapper;
	@Autowired
	private ZulistMapper zulistMapper;
	@Override
	public void insertapplyout(Zulist zulist) {
		Applyout applyout=new Applyout();
		applyout.setHouse_id(zulist.getHouse_id());
		applyout.setAddress(zulist.getAddress());
		applyout.setStatus("申请中");
		applyout.setUserlist_id(zulist.getUserlist_id());
		applyoutMapper.insertapplyout(applyout);
		
	}
	@Override
	public List<Applyout> findallapplyout() {
		List<Applyout> list=applyoutMapper.findallapplyout();
		return list;
	}
	@Override
	public void updateapplyout(Applyout applyout) {
		
		applyoutMapper.updateapplyout(applyout);
	}
	@Override
	public void agreeapplyout(Integer id) {
		Applyout applyout=applyoutMapper.findbyid(id);
		houselistMapper.deletehousebyhouseid(applyout.getHouse_id());
		hetongMapper.deletehetong(applyout.getHouse_id());
		Checkout checkout=new Checkout();
		checkout.setHouse_id(applyout.getHouse_id());
		checkout.setAddress(applyout.getAddress());
		checkout.setStatus("已退租");
		checkout.setUserlist_id(applyout.getUserlist_id());
		checkoutMapper.insertcheckout(checkout);
		applyout.setStatus("已同意");
		applyoutMapper.updateapplyoutbyhouse(applyout);
		zulistMapper.deletezulist(applyout.getHouse_id());
	}
	@Override
	public void deleteapplyout(Integer id) {
		
		applyoutMapper.deleteapplyout(id);
	}
	
	
}

package com.myssm.paul.service;


import com.myssm.paul.pojo.Applyout;
import com.myssm.paul.pojo.Zulist;

import java.util.List;

public interface ApplyoutService {
	public void insertapplyout(Zulist zulist);
	List<Applyout> findallapplyout();
	public void updateapplyout(Applyout applyout);
	public void agreeapplyout(Integer id);
	public void deleteapplyout(Integer id);
}

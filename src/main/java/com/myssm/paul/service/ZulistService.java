package com.myssm.paul.service;


import com.myssm.paul.pojo.Zulist;

import java.util.List;

public interface ZulistService {
	public void insertzulist(Zulist zulist);
	public List<Zulist> findzuuserlist() throws Exception;
	public Zulist findzulist(String house_id);
	public void deletezulist(String house_id);
	public List<Zulist> findzulistbyuid(Integer userlist_id);
}

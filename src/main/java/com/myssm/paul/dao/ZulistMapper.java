package com.myssm.paul.dao;


import com.myssm.paul.pojo.Zulist;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZulistMapper {
	public void insertzulist(Zulist zulist);
	public List<Zulist> findzuuserlist() throws Exception;
	Zulist findzulist(String house_id);
	public void deletezulist(String house_id);
	public List<Zulist> findzulistbyuid(Integer userlist_id);
	public Zulist findzukezulist(Integer id);
}

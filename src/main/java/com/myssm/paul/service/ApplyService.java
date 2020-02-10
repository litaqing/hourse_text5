package com.myssm.paul.service;



import com.myssm.paul.pojo.Apply;
import com.myssm.paul.pojo.Houselist;

import java.util.List;

public interface ApplyService {
	
	public void insertapply(Apply apply);
	public List<Apply> findapplylist() throws Exception;
	Apply findbyhouse_id(String house_id);
	public void deletebyhouse_id(String house_id);
	public void refuseapply(Houselist houselist);
}

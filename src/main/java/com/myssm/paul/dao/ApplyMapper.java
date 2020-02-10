package com.myssm.paul.dao;



import com.myssm.paul.pojo.Apply;
import com.myssm.paul.pojo.Applyout;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ApplyMapper {
	void insertapply(Apply apply);
	public List<Apply> findapplylist() throws Exception;
	Apply findbyhouse_id(String house_id);
	public void deletebyhouse_id(String house_id);
	public void updateapplyout(Applyout applyout);
}

package com.myssm.paul.dao;


import com.myssm.paul.pojo.Applyout;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ApplyoutMapper {
	public void insertapplyout(Applyout applyout);
	List<Applyout> findallapplyout();
	public void updateapplyout(Applyout applyout);
	public void updateapplyoutbyhouse(Applyout applyout);
	public Applyout findbyid(Integer id);
	public void deleteapplyout(Integer id);
}

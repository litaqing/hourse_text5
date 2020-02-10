package com.myssm.paul.dao;



import com.myssm.paul.pojo.QueryVo;
import com.myssm.paul.pojo.Solve;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SolveMapper {
	public List<Solve> selectall(QueryVo vo);
	public Integer selectcount(QueryVo vo);
	public void deletesolve(Integer id);
	public void insertsolve(Solve solve);
}

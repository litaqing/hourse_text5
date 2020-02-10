package com.myssm.paul.dao;



import com.myssm.paul.pojo.Paid;
import com.myssm.paul.pojo.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaidMapper {
public List<Paid> selectall(QueryVo vo);
public Double selectsum(QueryVo vo);
public void deletepaid(Integer id);
public void insertpaid(Paid paid);
}

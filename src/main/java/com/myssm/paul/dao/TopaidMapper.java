package com.myssm.paul.dao;


import com.myssm.paul.pojo.QueryVo;
import com.myssm.paul.pojo.Topaid;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TopaidMapper {
public void inserttopaid(Topaid topaid);
public List<Topaid> findtopaid(QueryVo vo);
public Topaid findbyid(Integer id);
public void deletetopaid(Integer id);
}

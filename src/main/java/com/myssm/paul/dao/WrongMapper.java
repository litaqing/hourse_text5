package com.myssm.paul.dao;



import com.myssm.paul.pojo.QueryVo;
import com.myssm.paul.pojo.Wrong;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WrongMapper {
  public List<Wrong> findwrong(QueryVo vo);
  public Wrong findbyid(Integer id);
  public void insertwrong(Wrong wrong);
  public void deletewrong(Integer id);
}

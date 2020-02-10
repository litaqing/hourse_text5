package com.myssm.paul.dao;



import com.myssm.paul.pojo.Houselist;
import com.myssm.paul.pojo.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HouselistMapper {
List<Houselist> selectAll();
public Integer findhouselistByVoCount(QueryVo vo);
Houselist findhouseid(String houseid);
void inserthouse(Houselist houselist);
void deletehouse(int id);
Houselist findid(int id);
Houselist findhouseidupdate(Houselist houselist);
void updatehouse(Houselist houselist);
void updatehousestatus(Houselist houselist);
public void deletehousebyhouseid(String house_id);
public void updatestatus(Houselist houselist);
}

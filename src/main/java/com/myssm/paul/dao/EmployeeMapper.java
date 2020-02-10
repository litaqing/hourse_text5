package com.myssm.paul.dao;

import com.myssm.paul.pojo.Employee;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {
    List<Employee> selectAll();
}

package com.myssm.paul.service;

import com.myssm.paul.dao.EmployeeMapper;
import com.myssm.paul.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Puhao
 * @date 2019/5/9 0009
 * @brief
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

     public List<Employee> selectAll(){
        return employeeMapper.selectAll();
    }
}


package com.myssm.paul.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myssm.paul.pojo.Employee;
import com.myssm.paul.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author Puhao
 * @date 2019/5/8 0008
 * @brief
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getAll")
    public String getList(Map<String, Object> map) {
        System.out.println("-------------");
        List<Employee> empls = employeeService.selectAll();
        map.put("empls", empls);
        return "employee/list";
    }
    @RequestMapping("/testPage")
    public String userList(@RequestParam(required = true, defaultValue = "1") Integer page, Model model) {
        //page默认值是1，pageSize默认是10，我写的是5 意思是从第1页开始，每页显示5条记录。
        PageHelper.startPage(page, 5);
        List<Employee> userList = employeeService.selectAll();
        System.out.println(userList);
        PageInfo<Employee> p = new PageInfo<>(userList);
        model.addAttribute("page", p);
        model.addAttribute("userList", userList);
        return "employee/list";
    }


}

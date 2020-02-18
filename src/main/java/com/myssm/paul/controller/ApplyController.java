package com.myssm.paul.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myssm.paul.pojo.*;
import com.myssm.paul.service.ApplyService;
import com.myssm.paul.service.HouselistService;
import com.myssm.paul.service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ApplyController {
	@Autowired
	private UserlistService userlistService;
	@Autowired
	private HouselistService houselistService;
	@Autowired
	private ApplyService applyService;
	//申请看房
	@RequestMapping(value = "/applycheckuserlist",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String applycheckuserlist(HttpSession httpSession, Integer id){
		String error="";
		User user1= (User) httpSession.getAttribute("user");
		ModelAndView mv=new ModelAndView();
		Integer user_id=user1.getId();
		Userlist list=userlistService.findhasuserlist(user_id);
		error="applycheck";
		if(list==null){
			mv.addObject("error", error);
			return error;
		}else{

			Houselist houselist=houselistService.findid(id);
			if (houselist.getStatus().equalsIgnoreCase("已被申请")){
				error="已被申请";
			}else if (houselist.getStatus().equalsIgnoreCase("申请中")){
				error="申请中";
			}else{
                houselist.setStatus("已被申请");
                houselistService.updatehousestatus(houselist);
                Integer userlist_id=list.getId();
                Apply apply=new Apply();
                apply.setHouse_id(houselist.getId().toString());
                apply.setAddress(houselist.getAddress());
                apply.setPrice(houselist.getPrice());
                apply.setArea(houselist.getArea());
                apply.setStatus("申请中");
                apply.setUserlist_id(userlist_id);
                applyService.insertapply(apply);
                error="applysuccess";
                mv.addObject("error", error);
			}

			return error;
		}
	}

	//管理员查看申请看房列表
	@RequestMapping("/findapplylist")
	public String findapplylist(Model model,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="2") Integer pageSize) throws Exception{
		 PageHelper.startPage(page, pageSize);
		List<Apply> applylist=applyService.findapplylist();
		PageInfo<Apply> p=new PageInfo<Apply>(applylist);
		model.addAttribute("applylist",applylist);
		model.addAttribute("p", p);
		model.addAttribute("mainPage","applylist.jsp");
		return "admin/main1";
	}
	
	@RequestMapping("/applychangehousestatus")
	public String applychangehousestatus(HttpSession httpSession,Model model,String house_id)throws Exception{
		User user1= (User) httpSession.getAttribute("user");
		Integer user_id=user1.getId();
		Userlist userlist=userlistService.findhasuserlist(user_id);
		Houselist houselist=houselistService.findhouseid(house_id);
		houselist.setStatus("已租赁");
		houselistService.updatehousestatus(houselist);
		Zulist zulist=new Zulist();
		zulist.setHouse_id(house_id);
		zulist.setPrice(houselist.getPrice());
		zulist.setAddress(houselist.getAddress());
		
		return "";
	}
	//管理员拒绝看房申请
	@RequestMapping("/refuseapply")
	public String refuseapply(String house_id,Model model){
		Houselist houselist=new Houselist();
		houselist.setHouseid(house_id);
		houselist.setStatus("未租赁");
		applyService.refuseapply(houselist);
		
		return "redirect:findapplylist.action";
	}
	
	//租客查看自己的 看房申请
	@RequestMapping("/getmyapply")
	public String getmyapply(Model model,HttpSession httpSession,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="2") Integer pageSize){
		User user1= (User) httpSession.getAttribute("user");
		Userlist userlist=userlistService.findhasuserlist(user1.getId());
		PageHelper.startPage(page, pageSize);
		List<Userlist> list=userlistService.getmyapply(userlist.getId());
		PageInfo<Userlist> p=new PageInfo<Userlist>(list);
		model.addAttribute("userlist", list);
		model.addAttribute("p", p);
		model.addAttribute("mainPage", "myapply.jsp");
		return "zuke/main";
	}
	
	
}

package com.myssm.paul.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myssm.paul.pojo.Houselist;
import com.myssm.paul.pojo.Map;
import com.myssm.paul.service.HouselistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller

public class HoustlistController {
	@Autowired
	private HouselistService houselistService;
	
	@RequestMapping("/houselist")
	public String houselist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="2") Integer pageSize){
		
		 PageHelper.startPage(page, pageSize);
		List<Houselist> houselist=houselistService.selectAll();
	PageInfo<Houselist> p=new PageInfo<Houselist>(houselist);
		
				
		model.addAttribute("p", p);
		model.addAttribute("houselist",houselist);
		model.addAttribute("mainPage","houselist.jsp");
		return "zuke/main";
	}
	@RequestMapping("/ahouselist")
	public String ahouselist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="2") Integer pageSize){
		
		 PageHelper.startPage(page, pageSize);
		List<Houselist> houselist=houselistService.selectAll();
	PageInfo<Houselist> p=new PageInfo<Houselist>(houselist);
		
				
		model.addAttribute("p", p);
		model.addAttribute("houselist",houselist);
		model.addAttribute("mainPage","ahouselist.jsp");
		return "admin/main1";
	}
	
	@RequestMapping("/addhouse")
	public String addhouse(Model model ,Houselist houselist){
		
		String houseid=houselist.getHouseid();
		Houselist houselist1=houselistService.findhouseid(houseid);
		if(houselist1!=null){
			model.addAttribute("error","该房屋id已存在");
			model.addAttribute("houselist",houselist);
			model.addAttribute("mainPage","addhouse.jsp");
			return "admin/main1";
		}else{
			model.addAttribute("error","添加成功");
			houselistService.inserthouse(houselist);
			model.addAttribute("houselist",houselist);
			model.addAttribute("mainPage","addhouse.jsp");
		return "admin/main1";
	}
		}
	
	@RequestMapping("/toaddhouse")
	public String toaddhoust(Model model){
		model.addAttribute("mainPage","addhouse.jsp");
		
		return "admin/main1";
	}
	@RequestMapping("/deletehouse")
	public String deletehouse(Integer id){
		houselistService.deletehouse(id);
		
		
		return "redirect:ahouselist.action";
	}
	@RequestMapping("/toahouselist")
	public String toahouselist(){
		
		
		
		return "ahouselist.action";
	}
	@RequestMapping("/findid")
	public String findid(Integer id,Model model){
		Houselist list=houselistService.findid(id);
		model.addAttribute("houselist",list);
		model.addAttribute("mainPage", "changehouse.jsp");
		return "admin/main1";
	}

	@RequestMapping("/findhouseidupdate")
	public String findhouseidupdate(Houselist houselist,Model model){
		Houselist list=houselistService.findhouseidupdate(houselist);
		if(list!=null){
			model.addAttribute("houselist",houselist);
			model.addAttribute("mainPage", "changehouse.jsp");
			model.addAttribute("error","该房屋id已存在");
			return "admin/main1";
		}
		else{
			houselistService.updatehouse(houselist);
			model.addAttribute("houselist",houselist);
			model.addAttribute("mainPage", "changehouse.jsp");
			model.addAttribute("error","更新成功");
			return "admin/main1";
		}
	}
	@RequestMapping("/tomap")
	public String getMap(Model model){
		List<Map>  mapList=new ArrayList<Map>();
		mapList.add(new Map(118.777882,32.059839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
		mapList.add(new Map(118.457882,32.049839,"地址：北京市东城区东华门大街"));
		mapList.add(new Map(118.62882,32.039839,"地址：北京市东城区正义路甲5号"));
		mapList.add(new Map(118.3882,32.059839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
		mapList.add(new Map(118.6666,32.019839,"地址：北京市东城区东华门大街"));
		mapList.add(new Map(118.577882,32.051839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
		mapList.add(new Map(118.377882,32.052839,"地址：北京市东城区东华门大街"));
		mapList.add(new Map(118.277882,32.053839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
		mapList.add(new Map(118.177882,32.054839,"地址：北京市东城区东华门大街"));
		mapList.add(new Map(118.077882,31.055839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
		mapList.add(new Map(118.795394,32.027002,"地址：北京市东城区东华门大街"));
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(mapList));
		model.addAttribute("mapList",array);
		model.addAttribute("mainPage", "map.jsp");
		return "admin/main1";
	}
//	@RequestMapping(value = "/getMap",method = RequestMethod.POST)
//	public List<Map> getMap(){
//      List<Map>  mapList=new ArrayList<Map>();
//      mapList.add(new Map(118.777882,32.059839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
//		mapList.add(new Map(118.457882,32.049839,"地址：北京市东城区东华门大街"));
//		mapList.add(new Map(118.62882,32.039839,"地址：北京市东城区正义路甲5号"));
//		mapList.add(new Map(118.3882,32.059839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
//		mapList.add(new Map(118.6666,32.019839,"地址：北京市东城区东华门大街"));
//		mapList.add(new Map(118.577882,32.051839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
//		mapList.add(new Map(118.377882,32.052839,"地址：北京市东城区东华门大街"));
//		mapList.add(new Map(118.277882,32.053839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
//		mapList.add(new Map(118.177882,32.054839,"地址：北京市东城区东华门大街"));
//		mapList.add(new Map(118.077882,31.055839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"));
//		mapList.add(new Map(118.795394,32.027002,"地址：北京市东城区东华门大街"));
//
//
//
//      return mapList;
//	}
	
}

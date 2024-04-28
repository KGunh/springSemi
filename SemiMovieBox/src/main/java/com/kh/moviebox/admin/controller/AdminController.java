package com.kh.moviebox.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.moviebox.admin.model.service.AdminService;
import com.kh.moviebox.theater.model.vo.Screen;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("screen")
	public String ScreenList() {
		return "admin/adminScreenList";
	}
	
	@GetMapping("detailTheater")
	public ModelAndView DetailTheater(Screen sc,ModelAndView mv) {
		
		
		mv.addObject("screen",sc);
		mv.addObject("list",adminService.detailTheater(sc)).setViewName("admin/adminDetailTheater");
		return mv;

	}
}

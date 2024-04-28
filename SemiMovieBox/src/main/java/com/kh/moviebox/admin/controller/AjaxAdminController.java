package com.kh.moviebox.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kh.moviebox.admin.model.service.AdminService;
import com.kh.moviebox.theater.model.vo.Screen;

@RestController
@RequestMapping("admin")
public class AjaxAdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(value="locationList",produces="application/json; charset=UTF-8")
	public String locationList() {
		return new Gson().toJson(adminService.locationList());
	}
	
	@GetMapping(value="selectLocation",produces="application/json; charset=UTF-8")
	public String selectLocation(String locationCode) {
		return new Gson().toJson(adminService.selectTheaterList(locationCode));
	}
	
	@GetMapping(value="insertScreen")
	public int insertScreen(Screen sc) {
		
		String insertDate = sc.getWatchDate() + "/" + sc.getWatchTime();
		
		sc.setWatchDate(insertDate);
		
		int count = adminService.insertCheck(sc);
		if(count > 0) {
			return 0;
		} else {
			return adminService.insertScreen(sc);
		}
		
	}

	@GetMapping(value="selectDate",produces="application/json; charset=UTF-8")
	public String selectDate(Screen sc) {
		return new Gson().toJson(adminService.detailTheater(sc));
	}
	
	@GetMapping(value="movieList",produces="application/json; charset=UTF-8")
	public String movieList(){
		return new Gson().toJson(adminService.movieList());
	}
}

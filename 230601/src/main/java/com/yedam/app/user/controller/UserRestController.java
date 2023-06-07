package com.yedam.app.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.user.service.UserVO;

//@Controller
@RestController//@RestController 사용함으로써 모든 메소드에 @ResponseBody 자동 적용
public class UserRestController {
	
	@PostMapping("/insertUser")
//	@ResponseBody // 데이터를 반환하는 메서드 / 자동 적용 
	public UserVO insertUser(UserVO userVo) {
		System.out.println("name : " + userVo.getName());
		System.out.println("age : " + userVo.getAge());
		System.out.println("today : " + userVo.getToday());
		return userVo;
	}
	
	@GetMapping("/getHome")//@RestController 안에서는 페이지를 반환할 수 없다 . 데이터만 반환된다
	public String getHome() {
		return "home";
	}
}

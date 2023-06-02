package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptMapper deptMapper;
	// department 전체조회
	@GetMapping("/deptList")
	public String deptList(DeptVO vo,Model model) {
		
		model.addAttribute("deptList", deptMapper.selectDeptList(vo));
		return "dept/deptList";
	}
	
	@GetMapping("/deptInsert")
	public String deptInsertForm() {
		return "dept/deptInsert";
	}
}

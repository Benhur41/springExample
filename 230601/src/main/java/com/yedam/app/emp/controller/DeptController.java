package com.yedam.app.emp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptService;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	@Autowired
	DeptMapper deptMapper;
	
	// 경로 <-> 기능 ( view )
	// 경로 + Method -> Unique 각 메소드 (GET, POST ... ) 에 맞춰서 경로설정 (GetMapping , PostMapping ... )
	// 조회 -> GET / 등록 수정 삭제 -> POST (일반적)
	
	//전체조회
	@RequestMapping("/deptList")
	public String deptList(DeptVO vo,Model model) {
		model.addAttribute("deptList", deptService.getAllDept(vo));
		return "dept/deptList";
	}
	
	//등록 페이지
	@GetMapping("/deptInsert")
	public String deptInsertForm(Model model) {
		List<Map<String,Object>> mgrList = deptMapper.selectManagerId();
		List<Map<String,Object>> locList = deptMapper.selectLocationId();
		model.addAttribute("mgrList",mgrList);
		model.addAttribute("locationList",locList);
		return "dept/deptInsert";
	}
	
	//등록기능
	@PostMapping("/deptInsert")
	public String deptInsert(DeptVO vo) {
		int success = deptService.insertDeptInfo(vo);
		if(success > 0 ) {
			return "redirect:/deptList";
		}else {
			return "redirect:/deptInsert";
		}
	}
	
	//삭제기능
	@RequestMapping("/deptDelete")
	public String deptDelete(String departmentId) {
		int success = deptMapper.deleteDept(departmentId);
		if(success > 0) {
			return "redirect:/deptList";
		}else {
			return "redirect:/deptList";
		}
	}
	
	//수정 페이지 - 단건조회와 동일
	@GetMapping("/deptUpdate")
	public String deptUpdateForm(String departmentId , Model model) {
		DeptVO vo = deptMapper.selectDeptOne(departmentId);
		List<Map<String,Object>> mgrList = deptMapper.selectManagerId();
		List<Map<String,Object>> locList = deptMapper.selectLocationId();
		model.addAttribute("mgrList",mgrList);
		model.addAttribute("locationList",locList);
		model.addAttribute("dept",vo);
		return "dept/deptUpdate";
	}
	
	//수정기능
	@PostMapping("/deptUpdate")
	public String deptUpdate(DeptVO vo) {
		int success = deptMapper.updateDept(vo);
		
		if(success >0) {
			return "redirect:/deptList";
		}else {
			return "redirect:/deptUpdate";
		}
	}
}

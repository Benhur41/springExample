package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
 * command
 * pojo : 상속필요없음
 */
@Controller //객체생성해서 컨테이너에 빈 등록하고 스프링 디스패쳐 서블릿에서 호출할 수 있도록 커맨드 타입으로 만들어줌 
//@Component 상속받음 
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	@GetMapping("/empList")
	public String main(@ModelAttribute("emp2")EmpVO vo ,Model model) {
		System.out.println(vo);
		//model 에는 ("empVO" , vo ) 형태로 저장된다
		model.addAttribute("empList",empMapper.selectList(vo));
		return "emp/empList";
	}
	
	@GetMapping("/empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs",empMapper.selectJobs());
		model.addAttribute("deptId",empMapper.selectDepartmentId());
		return "emp/empInsert";
	}
	
	
	@PostMapping("/empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:/empList"; //forward redirect 맵핑 url 을 주소로 적어준다
	}
	
	//사원 삭제 처리
	@GetMapping("/empDelete")
	public String empDelete(@RequestParam String employeeId) {
		empMapper.deleteEmp(employeeId);
		return "redirect:empList";
	}
	
	//사원 수정
	@GetMapping("/empUpdate")
	public String empUpdateForm(Model model,String employeeId) {
		model.addAttribute("emp",empMapper.selectOne(Integer.parseInt(employeeId)));
		model.addAttribute("jobs",empMapper.selectJobs());
		model.addAttribute("deptId",empMapper.selectDepartmentId());
		return "emp/empUpdate";
	}
	
	@PostMapping("/empUpdate")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		return "redirect:empList";
	}
	
	
}

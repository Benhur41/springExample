package com.yedam.app.emp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptListVO;
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
	public String deptList(HttpServletRequest request,@RequestParam(required = false)String msg ,DeptVO vo,Model model) {
		System.out.println("redirect : " + msg);
		Map<String , ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		DeptVO dvo;
		if(flashMap != null) {
			dvo = (DeptVO) flashMap.get("vo");
			System.out.println("department_id : " + dvo.getDepartmentId());
			model.addAttribute("msg",dvo.getDepartmentId());
		}
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
	public String deptInsert(DeptVO vo,RedirectAttributes rtt) {
		int success = deptService.insertDeptInfo(vo);
		if(success > 0 ) {
			rtt.addFlashAttribute("vo",vo);//request response 사라지기전에 세션에 일시적으로 저장
			rtt.addAttribute("msg", "message");
			return "redirect:/deptList";
		}else {
			return "redirect:/deptInsert";
		}
	}
	
	//삭제기능
	@RequestMapping("/deptDelete")
	public String deptDelete(DeptListVO list) {
		int success = deptService.deleteDeptInfo(list.getDeptList());
		if(success > 0) {
			return "redirect:/deptList?msg" + success;
		}else {
			return "redirect:/deptList";
		}
	}
	
	//수정 페이지 - 단건조회와 동일
	@GetMapping("/deptUpdate")
	public String deptUpdateForm(String departmentId , Model model) {
		DeptVO vo = deptService.getDeptInfo(departmentId);
		List<Map<String,Object>> mgrList = deptMapper.selectManagerId();
		List<Map<String,Object>> locList = deptMapper.selectLocationId();
		model.addAttribute("mgrList",mgrList);
		model.addAttribute("locationList",locList);
		model.addAttribute("dept",vo);
		return "dept/deptUpdate";
	}
	
//	//수정기능
//	@PostMapping("/deptUpdate")
//	public String deptUpdate(DeptVO vo) {
//		int success = deptMapper.updateDept(vo);
//		
//		if(success >0) {
//			return "redirect:/deptList";
//		}else {
//			return "redirect:/deptUpdate";
//		}
//	}
//	
	
	//@RequestBody : JSON 포맷을 사용하는 경우 
	//				-> content-type : 'application/json'
	@PostMapping("/deptUpdate") 
	@ResponseBody // 뷰 반환 x 데이터를 반환   // @RequestBody 는 json 값을 받을때 사용한다 
	public String deptUpdate(@RequestBody List<DeptVO> list, RedirectAttributes rtt) {
//		Map<String,Object> map = deptService.updateDeptInfo(list);
//		map.put("success", "success");
//		map.put("result", "result");
//		map.put("deptList", list);
//		rtt.addFlashAttribute("updateRes",map);
//		
//		return "redirect:/deptUpdate?departmentId="+list.get(0).getDepartmentId();
//		return deptService.updateDeptInfo(list);
		return "success";
			
	}
}

package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	// 전체조회
	public List<DeptVO> getAllDept(DeptVO vo);
	// 단건조회
	public DeptVO getDeptInfo(String departmentId);
	// 등록
	public int insertDeptInfo(DeptVO deptVO);
	// 수정
	public Map<String,Object> updateDeptInfo(List<DeptVO> deptVO);
	// 삭제
	public int deleteDeptInfo(List<DeptVO> deptVO);
}

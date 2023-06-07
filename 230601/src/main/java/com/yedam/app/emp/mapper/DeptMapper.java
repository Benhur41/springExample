package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.DeptListVO;
import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	//전체조회
	public List<DeptVO> selectDeptList(DeptVO vo);
	//단건조회
	public DeptVO selectDeptOne(String departmentId);
	//등록
	public int insertDept(DeptVO vo);
	public List<Map<String,Object>> selectManagerId();
	public List<Map<String,Object>> selectLocationId();
	//수정
	public int updateDept(DeptVO vo);
	//삭제
	public int deleteDept(DeptVO vo);
}

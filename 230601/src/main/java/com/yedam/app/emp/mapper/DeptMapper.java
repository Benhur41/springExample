package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> selectDeptList(DeptVO vo);
	public DeptVO selectDeptOne(String departmentId);
	public int insertDept(DeptVO vo);
	public List<Map<String,Object>> selectManagerId();
	public List<Map<String,Object>> selectLocationId();
	public int updateDept(DeptVO vo);
	public int deleteDept(String departmentId);
}

package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> selectDeptList(DeptVO vo);
	public int insertDept(DeptVO vo);
	public List<Integer> selectManagerId();
	public List<Integer> selectLocationId();
}
package com.yedam.app.emp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptListVO;
import com.yedam.app.emp.service.DeptService;
import com.yedam.app.emp.service.DeptVO;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper deptMapper;
	
	  
	@Override
	public List<DeptVO> getAllDept(DeptVO vo) {
		return deptMapper.selectDeptList(vo);
	}

	@Override
	public DeptVO getDeptInfo(String departmentId) {
		return deptMapper.selectDeptOne(departmentId);
	}

	@Override
	public int insertDeptInfo(DeptVO deptVO) {
		int result = deptMapper.insertDept(deptVO);
		System.out.println("id : "+deptVO.getDepartmentId());
		return result;
	}

	@Override
	public Map<String,Object> updateDeptInfo(List<DeptVO> deptVO) {
		boolean result = false; 
		List<String> successList = new ArrayList<>();
		int count = 0;
		
		for(DeptVO deptInfo : deptVO) {
			int res = deptMapper.updateDept(deptInfo);
			if(res > 0) {
				count++;
				successList.add(deptInfo.getDepartmentId());
			}
		}
		
		if(count >0) {
			result = true;
		}
		
		Map<String , Object> map = new HashMap<>();
		map.put("result", result);
		map.put("success", count);
		map.put("deptList", successList);
		
		return map;
	}

	@Override
	public int deleteDeptInfo(List<DeptVO> deptVO) {
		int count = 0 ; 
		for(DeptVO deptInfo : deptVO) {
			count += deptMapper.deleteDept(deptInfo);
		}
		return count;
	}

}

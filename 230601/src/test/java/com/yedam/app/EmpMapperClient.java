package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper; // 인터페이스를 상속받은 구현클래스 주입 / 
	
	@Ignore
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		assertEquals(findEmp.getFirstName(),"Steven");
	}

	@Ignore
	public void getEmpList() {
		EmpVO vo = new EmpVO();
		vo.setDepartmentId("60,50");
		vo.setFirstName("");
		vo.setOrderColumn("department_id , first_name");
		List<EmpVO> list = empMapper.selectList(vo);
		int count = empMapper.selectCount(vo);
		for(EmpVO e : list) {
			System.out.println(e.getFirstName());
		}
		System.out.println(count);
	}
	
	@Ignore
	public void insertEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmail("hbj0402323");
//		vo.setEmployeeId("4122");
		vo.setFirstName("kim");
		vo.setLastName("taehyeon");
		vo.setJobId("IT_PROG");
		int check = empMapper.insertEmp(vo);
		assertEquals(check,1);
	}
	
	@Test
	public void selectJob() {
		List<Map<String,Object>> list = empMapper.selectJobs();
		assertNotNull(list);
	}
}

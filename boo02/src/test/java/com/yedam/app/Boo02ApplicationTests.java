package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boo02ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void empList() {
		List<EmpVO> list = empMapper.selectEmpAll();
		assertTrue(!list.isEmpty());
	}
	
	@Test
	public void empInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	
	@Test
	public void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("333");
		empVO.setEmail("3333@google.com");
		empVO.setJobId("IT_PROG");
		
		
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println(empVO.getEmployeeId());
		assertEquals(result, 1);
	}
	@Test
	public void empUpdate() {
		// 1)정보 조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(204);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		//2)정보수정 Baer
		findVO.setLastName("kkkk");
		int result = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		assertEquals(result, 1);
		
	}
	

	
	@Test
	public void empDelete() {
		int result = empMapper.deleteEmpInfo(557);
		assertEquals(result, 1);
		
	}
	

}

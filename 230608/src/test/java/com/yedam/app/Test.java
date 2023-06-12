package com.yedam.app;


import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class Test {
	
	@Autowired BoardMapper boardMapper;
	
	@org.junit.Test
	public void testBoard() {
		List<BoardVO> list = boardMapper.selectBoardList(1);
		System.out.println(list);
	}
}

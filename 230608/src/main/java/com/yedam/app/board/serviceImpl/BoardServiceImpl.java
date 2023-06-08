package com.yedam.app.board.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int addBoard(BoardVO boardVO) {
		int result = 0;
		int success = boardMapper.insertBoard(boardVO);
		if(success > 0) {
			result= Integer.parseInt(boardVO.getBno());
		}else {
			result =-1;
		}
		return result;
	}

	@Override
	public int modifyBoard(BoardVO boardVO) {
		int result = 0;
		int success = boardMapper.updateBoard(boardVO);
		if(success > 0) {
			result = Integer.parseInt(boardVO.getBno());
		}else {
			result = -1;
		}
		return result;
	}

	@Override
	public int removeBoard(String bno) {
		int result =0;
		int success = boardMapper.deleteBoard(bno);
		if(success > 0) {
			result = Integer.parseInt(bno);
		}else {
			result=-1;
		}
		return result;
	}

}

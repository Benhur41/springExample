package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	//전체조회
	public List<BoardVO> getBoardList(int page);
	public int boardTotalCount();
	//단건조회
	public BoardVO getBoardInfo(BoardVO boardVO);
	//등록 - 등록된 글 번호 반환 / 실패 : -1
	public int addBoard(BoardVO boardVO);
	//수정 - 수정된 글 번호 반환 / 실패 : -1
	public int modifyBoard(BoardVO boardVO);
	//삭제 - 삭제된 글 번호 반환 / 실패 : -1
	public int removeBoard(String bno);
}

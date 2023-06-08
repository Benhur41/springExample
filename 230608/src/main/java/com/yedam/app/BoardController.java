package com.yedam.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	//전체조회
	@GetMapping("/boardList")
	public String boardList(Model m) {
		List<BoardVO> list = boardService.getBoardList();
		m.addAttribute("boardList" , list);
		return "board/boardList";
	}
	
	//단건조회
	@GetMapping("/boardInfo")
	public String boardInfo(BoardVO vo,Model m) {
		System.out.println(vo);
		BoardVO bvo = boardService.getBoardInfo(vo);
		System.out.println(bvo);
		m.addAttribute("board", bvo);
		return "board/boardInfo";
	}
	
	//등록
	@GetMapping("/insertBoard")
	public String insertBoardForm() {
		return "board/InsertBoardForm";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(BoardVO vo) {
		int success = boardService.addBoard(vo);
		if(success > 0) {
			return "redirect:/boardList";
		}else {
			return "redirect:/insertBoard";
		}
	}
	//수정
	@GetMapping("/updateBoard")
	public String updateBoardForm(BoardVO vo,Model m) {
		
		BoardVO bvo = boardService.getBoardInfo(vo);
		m.addAttribute("board",bvo);
		return "board/updateBoardForm";
	}
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		System.out.println(vo+ "postUpdate");
		int success = boardService.modifyBoard(vo);
		if(success > 0) {
			return "redirect:/boardList";
		}
		return "redirect:/boardList";
	}
	//삭제
	@RequestMapping("/deleteBoard")
	public String delete(String bno) {
		int success = boardService.removeBoard(bno);
		if(success > 0) {
			return "redirect:/boardList";
		}else {
			return "redirect:/boardList";
		}
	}
}

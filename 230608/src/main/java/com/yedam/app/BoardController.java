package com.yedam.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.board.service.PageDTO;

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
	public String boardList(String page ,Model m) {
		page = page == null ? "1" : page;
		int pageNum= Integer.parseInt(page);
		int total = boardService.boardTotalCount();
		PageDTO dto = new PageDTO(pageNum , total);
		List<BoardVO> list = boardService.getBoardList(pageNum);
		m.addAttribute("boardList" , list);
		m.addAttribute("pageInfo",dto);
		return "board/boardList";
	}
	
	//단건조회
	@GetMapping("/boardInfo")
	public String boardInfo(BoardVO vo,Model m) {
		BoardVO bvo = boardService.getBoardInfo(vo);
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
	@ResponseBody
	public Map<String,Object> updateBoard(BoardVO vo) {
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(vo);
		Map<String,Object> map = new HashMap<>();
		boolean result = false;
		int success = boardService.modifyBoard(vo);
		if(success > -1) {
			result = true;
		}
		map.put("result", result);
		map.put("bno", vo.getBno());
		return map;
	}
	//삭제
	@GetMapping("/deleteBoard")
	public String delete(@RequestParam(required=false , defaultValue = "0" , name="bno") String bno) {
		int success = boardService.removeBoard(bno);
		if(success > 0) {
			return "redirect:/boardList";
		}else {
			return "redirect:/boardList";
		}
	}
}

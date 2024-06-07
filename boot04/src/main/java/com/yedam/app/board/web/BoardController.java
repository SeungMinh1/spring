package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//전체조회
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
		//classpath:/templates/+board/boardList + .html
	}
	//단건조회
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.boardInfo(boardVO);
		model.addAttribute("board", findVO);
		return "board/boardInfo";
	}
	//등록-페이지
	@GetMapping("boardInsert")
	public String boardInsertForm() { //일반적인 <form /> 활용
		return "board/boardInsert";
	}
	//등록-처리
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		/*
		String url = "";
		int bno = boardService.boardInsert(boardVO);
		if(bno > -1) {
			url += "redirect:boardInfo?bno="+bno;
		}else {
			url = "boardList";
		}
		return url;
		*/
		boardService.boardInsert(boardVO);
		return "redirect:boardList"; //redirect => GetMapping
		
	}
	//수정 - 페이지
	@GetMapping("boardUpdate")
	public String boardUpdateForm(Integer bno, Model model) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(bno);
		BoardVO findVO = boardService.boardInfo(boardVO);
		model.addAttribute("boardVO", findVO);
		return "board/boardUpdate";
	}
	//수정 - 처리
	@PostMapping("boardUpdate")
	@ResponseBody
	public  Map<String, Object> boardUpdateProcess(@RequestBody BoardVO boardVO) {
		return boardService.boardUpdate(boardVO);
	}
	//삭제
	@GetMapping("boardDelete")
	public String boardDelete(Integer boardNo) {
		boardService.boardDelete(boardNo);
		return "redirect:boardList";
	}
}

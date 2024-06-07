package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;
@Service   //Transactional
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> boardList() {
		return boardMapper.selectBoardAll();
	}

	@Override
	public BoardVO boardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int boardInsert(BoardVO boardVO) {
		int result = boardMapper.insertBoardInfo(boardVO);
		//return result == 1 ? boardVO.getBno() : -1; //하나의 조건식을 기준으로 두개의 값 중 하나를 결정할떄 상항연산자
		if(result == 1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> boardUpdate(BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = boardMapper.updateBoardInfo(boardVO);
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", boardVO);
		
		return map;
	}

	@Override
	public int boardDelete(int boardNo) {
		int result = boardMapper.deleteBoardInfo(boardNo);
		return result;
	}

}

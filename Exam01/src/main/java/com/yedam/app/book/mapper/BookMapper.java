package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;
import com.yedam.app.rent.service.RentVO;

public interface BookMapper {
	
	// 도서정보 등록
	public int insertBookInfo(BookVO bookVO);
	
	// 도서목록 조회
	public List<BookVO> selectBookAll();
	
	public int selectBookno();
	
	public List<RentVO> selectrentAll();
}

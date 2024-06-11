package com.yedam.app.book.service;

import java.util.List;

import com.yedam.app.rent.service.RentVO;

public interface BookService {
	
	//도서목록 조회
	public List<BookVO> bookList();
	
	//도서등록
	public int bookInsert(BookVO bookVO);
	
	//번호
	public int searchBookNo();
	
	//rent
	public List<RentVO> rentList();

}

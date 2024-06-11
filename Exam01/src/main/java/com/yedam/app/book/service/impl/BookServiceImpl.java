package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.rent.service.RentVO;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookMapper bookMapper;
	
	//도서등록
	@Override
	public int bookInsert(BookVO bookVO) {
		int result = bookMapper.insertBookInfo(bookVO);
		if(result == 1) {
			return bookVO.getBookNo();
		}else {
			return -1;
		}

	}
	//도서목록조회
	@Override
	public List<BookVO> bookList() {
		return bookMapper.selectBookAll();
	}
	@Override
	public int searchBookNo() {
		return bookMapper.selectBookno();
	}
	@Override
	public List<RentVO> rentList() {
		return bookMapper.selectrentAll();
	}
	

}

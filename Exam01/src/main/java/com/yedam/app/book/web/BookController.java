package com.yedam.app.book.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.rent.service.RentVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	//도서 목록 조회
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.bookList();
		model.addAttribute("bookList",list);
		return "book/bookList";
	}
	
	//등록-페이지
	@GetMapping("bookInsert")
	public String boardInsertForm(Model model) {
		BookVO bookVO = new BookVO(); 
		int num = bookService.searchBookNo();
		bookVO.setBookNo(num);;
		model.addAttribute("book", bookVO);
		return "book/bookInsert";
	}
	//등록 처리
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		bookService.bookInsert(bookVO);
		return "redirect:bookList";
	}
	
	@GetMapping("rent")
	public String rentList(Model model) {
		List<RentVO> list = bookService.rentList();
		model.addAttribute("rentList",list);
		return "book/rent";
	}
	
}

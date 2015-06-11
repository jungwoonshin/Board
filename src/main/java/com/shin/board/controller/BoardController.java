package com.shin.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.shin.board.model.BoardModel;
import com.shin.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService boardService;

	ModelAndView mav;

	/**
	 * 첫번째 게시판 입력정보 출력하기
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView boardList(
			@RequestParam(required = false) Integer pageNum
			, @RequestParam(required = false) String searchWord
			, @RequestParam(required = false) Integer pageSize) {

		mav = new ModelAndView();

		// Pagination을 위한 변수
		int boardListCount = 0;
		int pageBlock = 10;

		String pageCode = "";
		String paramCode = "";

		if (pageNum == null) pageNum = 1;
		if (pageSize == null) pageSize = 4;

		List<BoardModel> boardList= boardService.getBoardList();

		// 게시글 리스트
		mav.addObject("boardList", boardList);


		/*
		// 공지사항 글 갯수 ( 조건에 따라 0
		boardListCount = BoardService.getServiceListCount(searchWord);

		// 페이징
		Page page = new Page(pageNum, boardListCount, pageSize, pageBlock);

		pageCode = page.getSb().toString();

		// 페이징 계산이 된 게시글 리스트
		mav.addObject("boardList", boardService.getBoardList(searchWord, page.getStartRow(), page.getEndRow()));

		// 게시글 리스트 총 갯수
		mav.addObject("boardListCount", boardListCount);

		// 검색 정보와, 페이징 정보 리턴
		mav.addObject("pageNum", pageNum);

		mav.addObject("pageSize", pageSize);
		pageCode = pageCode.replace("?", "?pageSize=" + pageSize + "&");
		paramCode = paramCode + "&pageSize=" + pageSize;
		 */
		mav.setViewName("board/boardList");

		return mav;
	}	

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView boardListAfterPost(@ModelAttribute BoardModel board) {
		mav = new ModelAndView();
		boardService.insertOneBoard(board);
		mav.setViewName("redirect:/list");
		return mav;
	}

	// 게시판 등록 폼
	@RequestMapping(value = "/boardForm", method = RequestMethod.GET)
	public ModelAndView boardForm() {
		mav = new ModelAndView();
		logger.info("게시판 등록 페이지 이동");
		// 공지사항 등록 폼 뷰
		mav.setViewName("board/boardWrite");
		return mav;
	}

	// 게시판 삭제
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public ModelAndView boardDelete(@RequestParam int seq) {
		mav = new ModelAndView();
		logger.info("게시판 삭제");
		boardService.deleteOneBoard(seq);
		mav.setViewName("redirect:/list");
		return mav;
	}

	@RequestMapping(value = "/boardUpdateForm", method = RequestMethod.GET)
	public ModelAndView boardUpateForm(@RequestParam(required = false) Integer seq){

		// 수정 폼에는 SEQ가 필요한데 없을 경우 페이지 이동
		if (seq == null) {
			mav.setViewName("redirect:/list");
			return mav;
		}
		mav.addObject("toBeUpdated",boardService.getOneBoard(seq));
		
		
		
		mav.setViewName("board/boardUpdate");
		return mav;
	}

	// 공지사항 수정
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate( @ModelAttribute BoardModel board) {
		mav = new ModelAndView("redirect:/list");
		logger.info("게시판 수정!!" + board.toString());
		boardService.updateOneBoard(board);
		return mav;
	}

}

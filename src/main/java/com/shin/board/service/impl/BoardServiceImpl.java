package com.shin.board.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shin.board.dao.BoardDao;
import com.shin.board.model.BoardModel;
import com.shin.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	// 외부 Config 파일을 통한 Path 경로
	// String filePath = FILE_PATH;

	@Autowired
	BoardDao boardDao;

	// 게시판 목록 가져오기
	@Override
	public List<BoardModel> getBoardList() {
		logger.info("기본 목록 가져오기....");
		return boardDao.getBoardList();
	}

	@Override
	public void insertOneBoard(BoardModel toBeInserted) {
		boardDao.insertOneBoard(toBeInserted);
	}

	@Override
	public void deleteOneBoard(int seq) {
		boardDao.deleteOneBoard(seq);
	}

	@Override
	public void updateOneBoard(BoardModel board) {
		logger.info("공지사항 수정  [ 번호 ] : " + board.getBoardNo() + "\n [ 게시글 정보 ]" + board.toString());
		boardDao.updateOneBoard(board);
	}

	@Override
	public BoardModel getOneBoard(Integer seq) {
		return boardDao.getOneBoard(seq);
	}

	
	

	//	// 공지사항 단일 파일 읽기
	//	public NoticeFileModel getNoticeFile(int noticeFileSeq) {
	//		return noticeDao.getNoticeFileInfo(noticeFileSeq);
	//	}

	//	public List<NoticeFileModel> getNoticeFileList(int seq) {
	//		return noticeDao.getNoticeFileList(seq);
	//	}


}

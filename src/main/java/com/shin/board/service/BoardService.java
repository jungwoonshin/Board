package com.shin.board.service;

import java.util.List;

import com.shin.board.model.BoardModel;

public interface BoardService {
	public List<BoardModel> getBoardList();

	public void insertOneBoard(BoardModel toBeInserted);

	public void deleteOneBoard(int seq);

	public void updateOneBoard(BoardModel board);

	public BoardModel getOneBoard(Integer seq);
}

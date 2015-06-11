package com.shin.board.dao;

import java.util.List;

import com.shin.board.model.BoardModel;

public interface BoardDao {

	public List<BoardModel> getBoardList();

	public void insertOneBoard(BoardModel toBeInserted);

	public int deleteOneBoard(int seq);

	public void updateOneBoard(BoardModel board);

	public BoardModel getOneBoard(Integer seq);

}

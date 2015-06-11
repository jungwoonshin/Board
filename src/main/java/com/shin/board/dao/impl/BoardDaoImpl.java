package com.shin.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.shin.board.dao.BoardDao;
import com.shin.board.model.BoardModel;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Override 
	public List<BoardModel> getBoardList(){
		return getSqlSession().selectList("com.shin.board.dao.BoardDao.getBoardList");
	}

	@Override
	public void insertOneBoard(BoardModel toBeInserted) {
		getSqlSession().insert("com.shin.board.dao.BoardDao.insertOneBoard", toBeInserted);
	}

	@Override
	public int deleteOneBoard(int seq) {
		return getSqlSession().update("com.shin.board.dao.BoardDao.deleteOneBoard", seq);
	}

	@Override
	public void updateOneBoard(BoardModel board) {
		getSqlSession().update("com.shin.board.dao.BoardDao.updateOneBoard", board);
	}
	
	@Override
	public BoardModel getOneBoard(Integer seq){
		return getSqlSession().selectOne("com.shin.board.dao.BoardDao.getOneBoard", seq);
	}

	
	
}

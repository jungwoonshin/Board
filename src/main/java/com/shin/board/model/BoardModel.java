package com.shin.board.model;

import java.sql.Timestamp;

public class BoardModel {
	
	
	private int boardNo;
	private String boardTitle;
	private String boardAuthor;
	private String boardContents;
	private Timestamp boardDate;
	private int boardViewCount;
	private int boardIsDel;
	
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardAuthor() {
		return boardAuthor;
	}
	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}
	public Timestamp getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardViewCount() {
		return boardViewCount;
	}
	public void setBoardViewCount(int boardViewCount) {
		this.boardViewCount = boardViewCount;
	}
	public int getBoardIsDel() {
		return boardIsDel;
	}
	public void setBoardIsDel(int boardIsDel) {
		this.boardIsDel = boardIsDel;
	}
	@Override
	public String toString() {
		return "BoardModel [boardNo=" + boardNo + ", boardTitle=" + boardTitle
				+ ", boardAuthor=" + boardAuthor + ", boardDate=" + boardDate
				+ ", boardViewCount=" + boardViewCount + ", boardIsDel="
				+ boardIsDel + "]";
	}
}

package com.shin.board.util;

public class Page {
	private int totalPage, startPage, endPage;
	private int startRow, endRow;
	private StringBuffer sb;
	
	
	public Page(int pageNum, int count, int pageSize, int pageBlock) {
		this.paging(pageNum, count, pageSize, pageBlock);
	}
	
	/**
	 * 코드 정보 가져오기
	 * @param pageNum	: 현재 페이지 넘버
	 * @param count  : 총 글 갯수
	 * @param pageSize  : 페이지 당 글 갯수
	 * @param pageBlock  : 보여질 페이지 수 ( < 1,2,3,4,5... >)
	 * @return
	 */
	public void paging(int pageNum, int count, int pageSize, int pageBlock) {
		totalPage = (int) Math.ceil((double) count / pageSize);
		startRow = (pageNum - 1) * pageSize + 1;
		endRow = pageNum * pageSize;
		
		startPage = (int) ((pageNum - 1) / pageBlock) * pageBlock + 1;
		endPage = startPage + pageBlock - 1;
		
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		sb = new StringBuffer();
		// 왼쪽 페이지 버튼 이동
		if (startPage < pageBlock) {
			sb.append("<a class='prev no_prev'>이전</a>");
		} else {
			sb.append("<a class='prev' href='?pageNum=");
			sb.append(startPage - pageBlock);
			sb.append("'>이전</a>");
		}
		
		// 번호들
		for (int i = startPage; i <= endPage; i++) {
			if (i == pageNum) {
				sb.append("<em>");
				sb.append(i);
				sb.append("</em>");
			} else {
				sb.append("<a href='?pageNum=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}
		
		// 오른쪽 페이지 버튼 이동
		if (endPage < totalPage) {
			sb.append("<a class='next' href='?pageNum=");
			sb.append(startPage + pageBlock);
			sb.append("'>다음</a>");
		} else {
			sb.append("<a class='next no_next'>다음</a>");
		}
	}
	
	public int getStartRow() {
		return startRow;
	}
	
	public int getEndRow() {
		return endRow;
	}
	
	public StringBuffer getSb() {
		return sb;
	}
}

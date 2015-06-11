<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판 목록</title>
</head>
<body>

	<table>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글저자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>    </th>
			<th>	</th>
		</tr>

		<c:forEach items="${boardList}" var="b">
			<tr>
				<td>${b.boardNo}</td>
				<td>${b.boardTitle}</td>
				<td>${b.boardAuthor}</td>
				<td>${b.boardDate}</td>
				<td>${b.boardViewCount}</td>
				<td><a href="/boardUpdateForm?seq=${b.boardNo}" class="button btn_white2">수정</a></td>
				<td><a href="javascript:onDeleteBoard('${b.boardNo}')" class="button btn_red">삭제</a></td>
			</tr>
		</c:forEach>
		
		<tr>
			<a href="/boardForm" class="button btn_brown">공지사항 등록</a> 
		<tr>


	</table>




	

<script src="/js/site/board/board.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 수정</title>
</head>
<body>

	<form id="boardform" action="/boardUpdate" method="post">
		<table>
			<tr>
				<td>글 번호</td>
				<td><input type="text" name="boardNo" id="boardNo"
					value="${toBeUpdated.boardNo}" disabled/></td>
			</tr>
			<tr>
				<td>글 제목:</td>
				<td><input type="text" name="boardTitle" id="boardName"
					value="${toBeUpdated.boardTitle}" /></td>
			</tr>
			<tr>
				<td>글 저자:</td>
				<td><input type="text" name="boardAuthor" id="boardAuthor"
					value="${toBeUpdated.boardAuthor}" /></td>
			</tr>
			<tr>
				<td>글 내용:</td>
				<td><textarea name="boardContents" id="boardContents" rows="10"
						cols="48">${toBeUpdated.boardContents}</textarea></td>
			</tr>
			<tr>
				<td><button type="submit">저장</button></td>
				<td></td>
			</tr>
		</table>
	</form>

</body>
</html>
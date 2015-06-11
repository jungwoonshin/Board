//// 공지사항 폼 체크
//function onNoticeCheck() {
//	if ($("#title").val().isBlank()) {
//		alert('제목을 입력해주세요');
//		$('#title').focus();
//		return false;
//	}
//
//	if ($("#contents").val().isBlank()) {
//		alert('내용을 입력해주세요');
//		$('#contents').focus();
//		return false;
//	}
//
//	return true;
//}

//게시판 입력
function onInsertBoardSubmit() {
	var frm = document.getElementById('insertNoticeForm');

	// Form Check
	if (onNoticeCheck()) {
		frm.method = "post";
		frm.action = "/admin/notice";
		frm.submit();
	}
	return false;
}

//게시판 수정
function onUpdateBoardSubmit() {
	var frm = document.getElementById('updateBoardForm');

	// Form Check
	if (onNoticeCheck()) {
		frm.method = "post";
		frm.action = "/admin/noticeUpdate";
		frm.submit();
	}
	return false;
}

// 게시판 삭제
function onDeleteBoard(seq) {
	if (confirm('정말 삭제하시겠습니까?')) {
		var frm = document.createElement("form");
		var input_id = document.createElement("input");
		input_id.setAttribute("type", "hidden");
		input_id.setAttribute("name", "seq");
		input_id.setAttribute("value", seq);
		frm.appendChild(input_id);

		frm.method="post";
		frm.action="/boardDelete";
		frm.submit();
	}
	return false;
}
//
//	if ($('#searchForm').length > 0) {
//		// 오늘 날짜 today , 오늘 날짜 스트링 값 sToday ( yyyy-MM-dd )
//		var today = new Date();
//		var sToday = dateToString(today);
//
//		// 시작 조회 기간 컨트롤 시
//		$('#searchStartDate').change(function() {
//			var tmpStartDate = new Date($('#searchStartDate').val());
//			var tmpEndDate = new Date($('#searchEndDate').val());
//
//			if (tmpStartDate > tmpEndDate) {
//				alert("시작날짜가 종료 날짜 보다 클 수 없습니다.");
//				$('#searchStartDate').val("");
//				return false;
//			}
//		});
//
//		// 끝 조회 기간 컨트롤 시
//		$('#searchEndDate').change(function() {
//			var tmpStartDate = new Date($('#searchStartDate').val());
//			var tmpEndDate = new Date($('#searchEndDate').val());
//
//			if ($('#searchEndDate').val() < sToday) {
//				alert("종료 날짜가 오늘 날짜보다 작을  수 없습니다.");
//				$('#searchEndDate').val(sToday);
//				return false;
//			}
//
//			if (tmpStartDate > tmpEndDate) {
//				alert("종료 날짜가 시작 날짜보다 작을 수 없습니다. ");
//				$('#searchEndDate').val(sToday);
//				return false;
//			}
//		});
//
//		$('select[name="pageSize"]').change(function() {
//			$('#searchForm').submit();
//		});
//
//		$('select[id="pageSizeBottom"]').change(function() {
//			$('#searchForm select[name="pageSize"]').val($(this).val());
//			$('#searchForm').submit();
//		});
//	}
//});
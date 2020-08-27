<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
<script>
	var uiNum = ${param.uiNum};

	$(document).ready(function(){
		$.ajax({
			url:'/ajax/user',
			data:{
				cmd:'view',
				uiNum:uiNum
			},
			success:function(res){
				$('th[data-col]').each(function(idx,row){
					var col = row.getAttribute('data-col');
					$('#' + col).html(res[col]);
				});
			}
		})
	})
	
	function changeModify(){
		$('[id]').each(function(idx,td){
			var value = td.innerText;
			var html = '<input type="text" id="i' +td.id+'" value="'+ value +'">' ;
			td.innerHTML = html;
		})
	}
	
	function doDelete(){
		$.ajax({
			url:'/ajax/user',
			method:'POST',
			data:JSON.stringify({
				cmd:'delete',
				Num:Num
			}),
			success:function(res){
				if(res.result){
					alert('삭제 되었습니다.');
					location.href='/user/list.jsp';
				}else{
					alert('이미 삭제되었습니다.');
				}
			}
		})
	}
</script>
<table border="1">
	<tr>
		<th data-col="Name">이름</th>
		<td><input type="text" id="Name"></td>
	</tr>
	<tr>
		<th data-col="Id">아이디</th>
		<td><input type="text" id="Id"></td>
	</tr>
	<tr>
		<th data-col="Pw">비밀번호</th>
		<td><input type="password" id="Pw"></td>
	</tr>
	<tr>
		<th data-col="Email">이메일</th>
		<td><input type="text" id="Email"></td>
	</tr>
	<tr>
		<th data-col="Kind">업종</th>
		<td><input type="text" id="Kind"></td>
	</tr>
	<tr>
		<th data-col="Phone">폰번</th>
		<td><input type="text" id="Phone"></td>
	</tr>
	<tr>
		<th data-col="Nickname">닉넴</th>
		<td><input type="text" id="Nickname"></td>
	</tr>
	<tr>
		<th data-col="Admin">어드민여부</th>
		<td><input type="text" id="Admin"></td>
	</tr>
	<tr>
		<th colspan="2">
			<button onclick="changeModify()">수정</button>
			<button onclick="doDelete()">삭제</button>
		</th>
	</tr>
</table>
</body>
</html>
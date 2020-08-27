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
<table border="1" id="userList">
	<thead>
		<tr>
			<th data-col="Num">번호</th>
			<th data-col="Name">이름</th>
			<th data-col="Id">아이디</th>
			<th data-col="Email">이메일</th>
			<th data-col="Nickname">별명</th>
			<th data-col="Kind">업종</th>
			<th data-col="Admin">어드민여부</th>
		<th data-col="Phone">폰번</th>
			
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<a href="/user/insert.jsp"><button>유저생성</button></a>
<script>
$(document).ready(function(){
	$.ajax({
		url:'/ajax/user',
		data:{
			cmd:'list'
		},
		success:function(res){
			var html=''
			for(var i=0;i<res.length;i++){
				html += '<tr>';
				$('th[data-col]').each(function(idx,row){
					var col = this.getAttribute('data-col');
					html += '<td><a href="/user/view.jsp?uiNum=' + res[i].Num +'">' + res[i][col] + '</a></td>';
				})
				html += '</tr>';
			}
			$('#userList>tbody').html(html);
		}
	})
})
</script>
</body>
</html>
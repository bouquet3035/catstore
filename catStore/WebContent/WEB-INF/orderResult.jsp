<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<style>
table.type11 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}
table.type11 th {
    width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #ce4869 ;
}
table.type11 td {
    width: 155px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
}
</style>


	<div class="col-sm-6 col-md-4"
		style="padding: 15px; border: 2px double; border-radius: 25px;">
		<div class="thumbnail">
			<center>
				<img src="/images/thanks.JPG">
			</center>
			<div class="caption" style="padding: 10px">
			<h2 style="text-align: center">감사합니당 헤헿^^~</h2>
				<h2 style="text-align: center">주문번호: ${orderNo}</h2>
				<hr>
				<c:set var="sum" value="0" />
				<center><table class="type11">
					<tr>
					
						<th>이름</th>
						<th>수량</th>
						<th>단가</th>
						<th>합산</th>
					</tr>

					<c:forEach items="${orderList}" var="vo">
						<tr>
							<td>${itemMap[vo.ino].iname}</td>
							<td>${vo.amount}개</td>
							<td>${itemMap[vo.ino].price}</td>
							<td>${itemMap[vo.ino].price *vo.amount}</td>
						</tr>




						<c:set var="sum"
							value="${sum + (itemMap[vo.ino].price *vo.amount)}" />
					</c:forEach>
					<hr>
				</table><center>
				<div style="float:right">
				<p><h2>총 금액:
				<c:out value="${sum}" /><h2></p></div>
				<form action="/itemlist" method="get">
							<button type="submit" class="btn btn-danger">홈</button>
				</form>
			</div>
		</div>
	</div>
	




</body>
</html>
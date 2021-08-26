<%@page import="com.dg.s1.bankbook.BankbookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>BankBook Select Page</h1>
		
		
		<h3>num : ${dto.bookNumber} </h3>
		<h3>Name : ${dto.bookName} </h3>
		
		<h3>Rate : ${dto.bookRate} </h3>
		<h3>Sale : ${dto.bookSale} </h3>
		<h3>count : ${count}</h3>
		<h3>name : ${name}</h3>
		<h3>session : ${sessionScope.se}</h3>
	
	</body>
</html>
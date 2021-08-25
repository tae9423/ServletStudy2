<%@page import="com.dg.s1.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>

	<table>
		<tr>
			<th>ID</th><th>PW</th><th>이름</th><th>Phone</th><th>Email</th>
		</tr>
		<%
		Object obj = request.getAttribute("list");
		ArrayList<MemberDTO> ar = (ArrayList<MemberDTO>) obj;
		for (MemberDTO dto : ar) {
		%>

		<tr>
			<td><%=dto.getId()%></td>
			<td><%=dto.getPw()%></td>
			<td><%=dto.getName()%></td>
			<td><%=dto.getPhone()%></td>
			<td><%=dto.getEmail()%></td>
		</tr>
		<%
	}
	%>
	</table>
	
	<a href="memberJoin.do">WRITE</a>

</body>
</html>
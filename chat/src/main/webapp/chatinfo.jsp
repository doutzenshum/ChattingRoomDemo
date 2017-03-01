<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="5">
<title>多人聊天室</title>
</head>
<body>
	<table align="center" cellspacing="10">
		<tr>
			<td>历史访问人数：${applicationScope.counter.allCount }</td>
			<td>在线人数：${applicationScope.counter.onLineCount } <select>
					<c:forEach items="${applicationScope.counter.onLine}" var="line">
						<option>${line }</option>
					</c:forEach>
			</select>
			</td>
			<td>欢迎：${sessionScope.onLineName}</td>
		</tr>
		<tr>
			<td colspan="3"><textarea rows="20" cols="80">${applicationScope.chatInfo}</textarea>
			</td>
		</tr>
	</table>
</body>
</html>
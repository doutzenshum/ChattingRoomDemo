<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多人聊天室</title>
</head>
<body>
	<table align="center">
			<tr>
				<td colspan="2">
					<iframe src="chatinfo.jsp" width="800px" height="460px"></iframe>
				</td>
			</tr>
			<tr>
				<td align="center">
					<form action="chat.do" method="post">
						<input type="text" name="chat" size="60">
						<input type="submit" value="发言">
					</form>

				</td>
				<td align="center">
					<form action="rename.do" method="post">
						<input type="text" name="name" size="10">
						<input type="submit" value="换名登录">
					</form>
				</td>
			</tr>
		</table>
</body>
</html>
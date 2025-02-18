<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Counters=${counters }
<span style='color:${messageColor}'>
<%= request.getAttribute("message") %></span>
<span>
</span>
<form action="login" method="post">
<table>
<tr>
<td>Username</td>
<td><input name="username" type="text"/></td>

</tr>
<tr>
	<td>Password</td>
	<td><input name="password" type="password"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="Login" value="Login"></td>
</tr>

</table>

</form>
</body>
</html>
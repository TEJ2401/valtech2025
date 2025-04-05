<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
<%@ page import="dao.Employee" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="employees" method="get">
<div>
<table border="1">

<tr>


<th> <a href="employees?operation=SortById">Id</a></th>

<th> <a href="employees?operation=SortByName">Name</a></th>
<th ><a href="employees?operation=SortByAge">Age</a> </th>
<th ><a href="employees?operation=SortByGender">Gender</a></th>
<th><a href="employees?operation=SortBySalary">Salary</a></th>
<th><a href="employees?operation=SortByExperience">Experience</a></th>
<th><a href="employees?operation=SortByLevel">Level</a></th>
<th>Actions</th>
</tr>
<tr>

<c:forEach items="${emps}" var="e">

<tr>
<td><c:out value="${e.id}"></c:out></td>

<td>${e.name}</td>
<td>${e.age}</td>
<td>${e.gender}</td>
<td>${e.salary}</td>
<td>${e.exp}</td>
<td>${e.level}</td>
<td><a href="employees?operation=update&id=${e.id}">Update</a><a href="employees?operation=delete&id=${e.id}">Delete</a></td>

</tr>
</c:forEach>
<tr>
<td colspan="7"><a href="employees?operation=newEmp">New Employee</a></td>
</tr>

</table>
<div class="dropdown">

<jsp:include page="selectMenu.jsp" >
<jsp:param name="mode" value="employees"/>
</jsp:include>

<button value="RESET" type="submit" name="reset">Reset</button>
</form>
</div>

</div>
</body>
</html>
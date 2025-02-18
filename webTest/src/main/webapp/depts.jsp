<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Counters=${counters}
Current Department=${current}
<form method="post" action="depts">
<div>
<table>
	
	<tr>
	<td>Id</td>
	<td>${dept.id }</td>

	</tr>
	
	<table>

	<tr>
	<td>Name</td>
	<td>${dept.name }</td>

	</tr>
	<table>

	<tr>
	<td>Location</td>
	<td>${dept.location}</td>

	</tr>
	<table>

	
	<tr>
	<td colspan="2">
	<input type="submit" name="operation" value="First" />
	<input type="submit" name="operation" value="Previous" />
		<input type="submit" name="operation" value="Next" />
			<input type="submit" name="operation" value="Last" />
			<input type="submit" name="operation" value="Reset"/>
			
	</td>
	
	</tr>

</table>
<table>
</div>
<tr>

<th>Id</th>
<th> <a href="depts?operation=SortByName">Name</a></th>
<th ><a href="depts?operation=SortByAge">Age</a> </th>
<th ><a href="depts?operation=SortByGender">Gender</a></th>
<th><a href="depts?operation=SortBySalary">Salary</a></th>
<th><a href="depts?operation=SortByExperience">Experience</a></th>
<th><a href="depts?operation=SortByLevel">Level</a></th>
<th>Actions</th>
</tr>
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
<tr>
<td colspan="7"><a href="employees?operation=newEmp&current=${current}">New Employee</a></td>
</tr>

<th> <a href="employees?operation=SortByNameDepts&current=${current.id}">Name</a></th>
</table>
</form>
<jsp:include page="selectMenu.jsp" >	
<jsp:param name="typeofmeth" value="depts"/>
<jsp:param name="mode" value="depts"/>
</jsp:include>
</body>
</html>
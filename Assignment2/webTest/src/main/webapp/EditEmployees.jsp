<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="employees" method="post">
<table>
<tr>
<td>Id</td>
<input type="text" name="id" value="${ emps.id}" />

</tr>
<tr>
<td>Name</td>
<input type="text" name="name" value="${emps.name }"/>

</tr>
<tr>
<td>Age</td>

<td><input type="text" name="age" value="${ emps.age}"/></td>

</tr>
<tr>
<td>Gender</td>
<td><input type="text" name="gender" value="${emps.gender }"/></td>

</tr>
<tr>
<td>Salary</td>
<td><input type="text" name="salary" value="${emps.salary }"/></td>

</tr>
<tr>
<td>Experience</td>
<td><input type="text" name="experience" value="${emps.exp }"/></td>

</tr>
<tr>
<td>Level</td>
<td><input type="text" name="level" value="${emps.level }"/></td>
</tr>

<tr>
<td>DeptNo</td>
<td><input type="text" name="deptno" value="${emps.deptno}"/></td>

</tr>
<td></td>
<td></td>

</tr>
<tr>
<td colpspan="2">
<td><input type="submit" name="operation" value="${mode}"/></td>
<input type="submit" name="operation" value="Cancel"/>
</td>
</tr>
</table>
</form>
</body>
</html>
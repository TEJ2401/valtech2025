<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="employees" method="get">

<label for="options">Choose an Option</label>
<label for="Names">Name</label>
<input type="checkbox" name="pars" value="Names" id="Names" />
<label for="Age">Age</label>
<input type="checkbox" name="ages" value="Age" id="Age"/>
<label for="Salary">Salary</label>
<input type="checkbox" name="sal" value="Salary" id="sal"/>
<label for="Gender">Gender</label>
<input type="checkbox" name="gend" value="Gender" id="Gender"/>
<label for="Experience">Experience</label>
<input type="checkbox" name="exp" value="Experience" id="Experience"/>
<label for="Level">Level</label>
<input type="checkbox" name="level" value="Level" id="Level"/>

<%
		if("Names".equals(request.getParameter("pars"))){
			out.println("<p>Name</p><input name='searchbyname' type='text'/>");
		}
		if("Age".equals(request.getParameter("ages"))){
			out.println("<p>Age</p><select name='age'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='ab' type='text'/>");
			
		}
		if("Salary".equals(request.getParameter("sal"))){
			out.println("<p>Salary</p><select name='salary'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='cd' type='text'/>");
			
		}
		if("Gender".equals(request.getParameter("gend"))){
			out.println("<p>Gender</p><select name='gender'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='ef' type='text'/>");
		}
		if("Experience".equals(request.getParameter("exp"))){
			out.println("<p>Experience</p><select name='expr'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='gh' type='text'/>");
		}
		if("Level".equals(request.getParameter("level"))){
			out.println("<p>Level</p><select name='levelr'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='ij' type='text'/>");

		}

%>
	
<button type="submit" name="buttonValue" value=<%=request.getParameter("mode") %>  >Choose</button>
</form>
</body>
</html>
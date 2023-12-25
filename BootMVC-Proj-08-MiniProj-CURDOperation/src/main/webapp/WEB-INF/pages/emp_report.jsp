<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<c:choose>
	<c:when test="${!empty empList}">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Empno</th>
					<th scope="col">Name</th>
					<th scope="col">Job</th>
					<th scope="col">Salary</th>
					<th scope="col">DeptNo</th>
				</tr>
			</thead>

			<c:forEach var="emp" items="${empList}">
				<tr>		
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
					<td>
						<a href="edit_emp?eno=${emp.empno}" > <img alt="" src="image/edit.png" width="50" height="50"> </a> &nbsp;  &nbsp;
						<a href="delete_emp?eno=${emp.empno}" onclick="confirm('Do You Want To Delete Employee?')"> <img alt="" src="image/delete.png" width="50" height="50"> </a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	
	<c:otherwise>
		<h1 style="color: red;text-align: center;">Record Not Found</h1>
	</c:otherwise>
</c:choose>
<br>
<blink style="color: red;text-align: center;">${result}</blink>
<br>
<a href="add_emp"><button type="button" class="btn btn-primary btn-lg btn-block">Add Employee</button></a>
<a href="./"><button type="button" class="btn btn-secondary btn-lg btn-block">HOME</button></a>
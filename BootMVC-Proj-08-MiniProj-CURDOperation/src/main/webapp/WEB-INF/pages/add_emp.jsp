<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div align="center">
        <h2>Employee Registration</h2>
        <form:form action="add_emp" method="post" modelAttribute="emp">
            <form:label path="ename">Full name:</form:label>
            <form:input path="ename"/><br/>
             
            <form:label path="job">Job:</form:label>
            <form:input path="job"/><br/>
             
            <form:label path="sal">Salary:</form:label>
            <form:password path="sal"/><br/>      
 
            <form:label path="deptno">DeptNo:</form:label>
            <form:input path="deptno"/><br/>
              
            <button type="submit" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off">
 				 Register
			</button>
			
			<button type="reset" class="btn btn-secondary" data-toggle="button" aria-pressed="false" autocomplete="off">
 				 Reset
			</button>
			
        </form:form>
    </div>
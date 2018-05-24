<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>

<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>




	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Employee</h1>
			</div>
			<div class="col-md-4 col-md-offset-2">
				<a href="employeeController" class="btn btn-secondary" type="button">Employees</a>
				<a href="departmentController" class="btn btn-secondary" type="button">Departments</a>
			</div>
		</div>
	</section>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12"></div>

			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<legend>Employee List</legend>
					<div class="table-responsive">
						<table id="example" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Surname</th>
									<th>Salary</th>
									<th>Department</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${allEmployees}" var="employee">
									<tr>
										<td><c:out value="${employee.name}" /></td>
										<td><c:out value="${employee.surname}" /></td>
										<td><c:out value="${employee.salary}" /></td>
										<td><c:out value="${employee.department.name}" /></td>
										<td><a
											href="employeeController?action=delete&employeeId=${employee.id}"
											class="btn btn-danger" type="button">Delete</a> <a
											href="employeeController?action=update&employeeId=${employee.id}"
											class="btn btn-primary" type="button">Update</a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
			<div class="row">
				<div class="col-md-offset-3">
			<a href="employeeController?action=insert" class="btn btn-info"
				type="button">Add Employee</a> 
				</div>
		</div>
	</div>
	</div>

</body>
</html>
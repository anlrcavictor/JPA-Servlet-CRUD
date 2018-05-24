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
				<h1>Department</h1>
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
				<div class="col-md-4 col-md-offset-3">
					<legend>Department List</legend>
					<div class="table-responsive">
						<table id="example" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${allDepartments}" var="department">
									<tr>
										<td><c:out value="${department.name}" /></td>
										<td><a
											href="departmentController?action=delete&departmentId=${department.id}"
											class="btn btn-danger" type="button">Delete</a> <a
											href="departmentController?action=update&departmentId=${department.id}"
											class="btn btn-primary" type="button">Update</a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				

			</div>


			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12"></div>
						<div class="row">
							<div class="col-md-4 col-md-offset-3">
								<form class="form-horizontal" action="departmentController"
									method="POST">
									<fieldset>

										<!-- Form Name -->
										<legend>Department Add</legend>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-2 control-label" for="name">Name</label>
											<div class="col-md-4">
												<input id="name" name="name" type="text" placeholder=""
													class="form-control input-md">

											</div>
										</div>





										<!-- Button -->
										<div class="form-group">
											<div class="col-md-4 col-md-offset-2">
												<input type="submit" class="btn btn-info"
													value="Add Department">
											</div>
										</div>

									</fieldset>
								</form>
							</div>
							<div class="col-md-6"></div>
						</div>
					
				</div>
			</div>
</body>
</html>
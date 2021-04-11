<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Tasks</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper"align="center">
		<div id="header">
			<h2 align="center">Your Tasks</h2>
			
			<h4 align="left"><security:authentication property="principal.username" /></h4>
			<h4 align="left">
			<form:form action = "${pageContext.request.contextPath}/logout" method = "POST">
			<input type =  "submit" value="Logout" id="logout-button"/>
			</form:form>
			</h4>
		</div>
	</div>
	
	<div id="container" align="center">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Task"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			
			
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>ID</th>
					<th>Task</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
				<% int i = 0; %>
				<!-- loop over and print our customers -->
				<c:forEach var="tempTask" items="${tasks}">
					<% i++; %>
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/tasks/showFormForUpdate">
						<c:param name="taskId" value="${tempTask.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/tasks/delete">
						<c:param name="taskId" value="${tempTask.id}" />
					</c:url>					
					
					<tr>
						<td> <%=i%></td>
						<td> ${tempTask.comment} </td>
						<td> ${tempTask.status} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>










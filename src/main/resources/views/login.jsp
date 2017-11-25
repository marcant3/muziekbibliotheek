<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
      xmlns:c="http://xmlns.jcp.org/jsp/jstl/core" >
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="webresources/css/backendIndex.css" rel="stylesheet"  type="text/css" />
		<title>Muziekbibliotheek - Login Page</title>
</head>
<body>
	<div class="wrapper wrapperreverse">
		<div class="header">
		<img src="webresources/css/img/logoInverted.png">
		</div>
		<div class="containerContent">
		<form:form method="POST"   action="login" class="form-horizontal">
			<table style="margin:auto;">
					<tr>
						<td class="tableTitle">Username </td>
						<td>
							<form:input  type="text" path="username" name="username" id="username" maxlength="35" size="30" required="required" />
						</td>
					</tr>
					<tr>
						<td class="tableTitle">Password </td>
						<td>
							<form:input  type="password" path="password" name="password" id="password" maxlength="35" size="30" required="required" />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="tableSubmit">
							<input type="submit" value="Login" name="submit">
						</td>
					</tr>
				</table>
		</form:form> 
		 <c:if test="${  not empty '${message}'} ">
			 			${message}		
		</c:if>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="authority">
		<table>
			<tr>
				<td>user name :</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>authority :</td>
				<td><form:input path="authority" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="validate" /></td>
			</tr>
		</table>
	</form:form>
	
	list of all authorities
	<c:if test="${not empty authorities}">
		<table>
			<tr>
				<td>id</td>
				<td>user name</td>
				<td>password</td>
			</tr>
			<c:forEach var="item" items="${authorities}">
				<tr>
					<td>${item.id}</td>
					<td>${item.username}</td>
					<td>${item.authority}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
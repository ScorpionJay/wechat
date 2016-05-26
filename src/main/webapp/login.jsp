<%@ page language="java" contentType="text/html; charset=UTF-8""%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	login

	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
			<%-- <input name="_csrf" type="hidden" value="${_csrf.token}" /> --%>
		</table>
	</form>

</body>
</html>
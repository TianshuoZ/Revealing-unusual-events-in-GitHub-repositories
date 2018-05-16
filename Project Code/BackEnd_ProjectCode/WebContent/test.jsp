<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Page</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/test">
		<input type="text" name="username" id="username">
		<input class="submit" type="submit" id="submit" value="submit" >
	</form>
</body>
</html>
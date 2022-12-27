<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="result">
		<h3>${requestScope["message"]}</h3>
	</div>
	
	<div id="oh">
	</div>
	
	<%@ include file="/include/scriptsPath.jsp"%>
		
		<script src="<%=request.getContextPath()%>/Scripts/getPhotos.js"></script>
</body>
</html>
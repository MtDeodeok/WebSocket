<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function join() {
		var href = "/webSocket2?bang_id=" + $('#bang_id').val();
		location.href = href;
	}
</script>
</head>
<body>
	<input type="text" id="bang_id">
	<button id="join" onclick='join()'>입장</button>

	<div>
		<jsp:include page="roomList.jsp" flush="false"/>
	</div>
</body>
</html>
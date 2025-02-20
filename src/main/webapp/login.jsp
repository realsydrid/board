<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<%@include file="/header.jsp" %>
<h1>로그인</h1>
<form action="./login.do" method="post">
    <p><label>아이디<input type="text" name="user_id"></label></p>
    <p><label>비밀번호<input type="text" name="password"></label></p>
    <button>로그인</button>
</form>

</body>
</html>

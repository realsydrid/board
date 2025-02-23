<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<%@include file="/header.jsp" %>
<h1>로그인</h1>
<form action="./login.do" method="post">
    <p><label>아이디<input type="text" name="user_id" value="${rememberedId}"></label></p>
    <p><label>비밀번호<input type="password" name="password"></label></p>
    <div><button>로그인</button><a href="./signUp.jsp">회원가입</a></div>
    <p>
        <label>
            아이디기억하기<input type="checkbox" value="1" name="remember_id">
        </label>
        <label>
            자동로그인<input type="checkbox" value="1" name="auto_login">
        </label>
    </p>

</form>

</body>
</html>

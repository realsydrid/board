<%--
  Created by IntelliJ IDEA.
  User: seungyeob
  Date: 25. 2. 20.
  Time: 오전 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="./signUp.do" method="post">
  <p><label>아이디<input type="text" name="user_id"></label></p>
  <p><label>이름<input type="text" name="user_name"></label></p>
  <p><label>비밀번호<input type="text" name="password"></label></p>
  <p><label>비밀번호확인<input type="text" name="password_check"></label></p>
  <p><label>핸드폰번호<input type="text" name="phone_no"></label></p>
  <button type="submit">가입하기</button>
</form>

</body>
</html>

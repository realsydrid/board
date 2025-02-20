<%--
  Created by IntelliJ IDEA.
  User: seungyeob
  Date: 25. 2. 20.
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>비밀번호 변경하기</title>
</head>
<body>
<h1>비밀번호 변경하기</h1>
<form action="./passwordModify.do" method="post" name="passwordModifyForm">
  <p><label>변경할 비밀번호<input type="text" name="newPassword"></label></p>
  <p><label>비밀번호 확인<input type="text" name="passwordConfirm"></label></p>
  <button>변경하기</button>
</form>
</body>
</html>

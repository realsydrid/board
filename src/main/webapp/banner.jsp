<%--
  Created by IntelliJ IDEA.
  User: seungyeob
  Date: 25. 2. 24.
  Time: 오전 6:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배너</title>
    <style>
        h1 {
            font-size: 24px;
            font-weight: bold;
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>경고</h1>
<p>이 사이트는 인승엽 프로젝트 연습용입니다.<br>
    비밀번호는 암호화돼서 저장됩니다.<br>
    회원가입 시 실제정보가 아닌 테스트 용도로만 입력해주세요.</p>
<br>
<form action="setBannerCookie.do">
    <label>
        <span>오늘 하루동안 보지않기</span>
        <input type="checkbox" value="1" name="setBannerCookie">
    </label>
    <button type="submit">닫기</button>
</form>


</body>
</html>

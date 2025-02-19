<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>승엽게시판</title>
</head>
<body>
<h1>게시판</h1>
<%
    Object login=session.getAttribute("login");
    Object user_name=session.getAttribute("user_name");
%>

<%
    if(login!=null && login.equals(true)){
%>

<p><%= user_name%>님 접속중 <a href="">로그아웃</a></p>
<%}else {%>

<a href="./login.jsp">로그인</a>
<a href="./signUp.jsp">회원가입</a>
<%}%>




<div>
    <table>
        <thead>
        <tr>
            <th>글번호</th>
            <th>글제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>제목입니다</td>
            <td>작성자입니다</td>
            <td>작성일입니다</td>
        </tr>
        </tbody>
    </table>
</div>
<br/>
</body>
</html>
<%@ page import="com.example.board.dao.imp.BoardDaoImp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.board.dto.BoardDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>승엽게시판</title>
    <link rel="stylesheet" type="text/css" href="./css/index.css">
</head>
<body>
<%@include file="/header.jsp" %>
<%
    Cookie[] cookies = request.getCookies();
    Cookie bannerCookie=null;
    for (Cookie cookie : cookies){
        if (cookie.getName().equals("bannerCookie")){
            bannerCookie=cookie;
        }
    }
    if (bannerCookie==null || !bannerCookie.getValue().equals("1")){
%>
<script>
    window.open("./banner.jsp", "banner", "width=450,height=220,left=300,top=100,scrollbars=no,resizable=no");
</script>
<%}%>
<h1>게시판</h1>

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
        <%
            List<BoardDto> boards;
            try {
                BoardDaoImp boardDaoimp = new BoardDaoImp();
                boards = boardDaoimp.findAll();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (BoardDto b : boards) {%>
        <tr>
            <td><%=b.getBoard_id()%>
            </td>
            <td><a href="#"><%=b.getTitle()%>
            </a></td>
            <td><%=b.getUser_name()%>
            </td>
            <td><%=b.getCreated_at()%>
            </td>
        </tr>
        <%}%>


        </tbody>
    </table>
</div>
<br/>
</body>
</html>
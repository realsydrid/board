        <%@ page import="com.example.board.dao.imp.BoardDaoImp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.board.dto.BoardDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>승엽게시판</title>
    <link rel="stylesheet" type="text/css" href="./css/index.css">
</head>
<body>
<%@include file="/header.jsp" %>
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
            for(BoardDto b : boards){%>
        <tr>
            <td><%=b.getBoard_id()%></td>
            <td><a href="#"><%=b.getTitle()%></a></td>
            <td><%=b.getUser_name()%></td>
            <td><%=b.getCreated_at()%></td>
        </tr>                  
        <%}%>



        </tbody>
    </table>
</div>
<br/>
</body>
</html>
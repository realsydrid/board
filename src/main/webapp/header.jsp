<%@ page pageEncoding="UTF-8" %>

<header style="background-color: aquamarine; width: 100%; font-size: 20px; display: flex; justify-content: space-between; align-content: center;align-items: center">
  <%
    Object login=session.getAttribute("login");
    Object user_name=session.getAttribute("user_name");
  %>
<p><a href="<%=request.getContextPath()%>">HOME</a></p>
  <div>
  <%
    if(login!=null && login.equals(true)){
  %>

  <p><%= user_name%>님 접속중 <a href="./passwordModify.jsp">비밀번호 변경하기</a> <a href="./logout.do">로그아웃</a></p>
  <%}else {%>

  <a href="./login.jsp">로그인</a>
  <a href="./signUp.jsp">회원가입</a>
  <%}%>
  </div>

</header>

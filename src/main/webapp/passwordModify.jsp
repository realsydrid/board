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
    <%@include file="/header.jsp" %>

    <title>비밀번호 변경하기</title>
</head>
<body>
<h1>비밀번호 변경하기</h1>
<form action="./passwordModify.do" method="post" name="passwordModifyForm">
    <p><label>변경할 비밀번호<input type="text" name="newPassword"></label></p>
    <p class="msg" id="passwordMsg">비밀번호는 4글자 이상이어야 합니다.</p>
    <p><label>비밀번호 확인<input type="text" name="passwordCheck"></label></p>
    <p class="msg" id="passwordCheckMsg"></p>

    <button>변경하기</button>
</form>
<script>
    const passwordModifyForm = document.forms["passwordModifyForm"];
    const passwordMsg = document.getElementById("passwordMsg");
    const passwordCheckMsg = document.getElementById("passwordCheckMsg");
    const newPassword = passwordModifyForm.newPassword
    const passwordCheck = passwordModifyForm.passwordCheck
    passwordModifyForm.newPassword.oninput = function (e) {
        if (this.value.length < 4) {
            passwordMsg.style.display = "block";
            newPassword.style.borderColor = "red";
            passwordMsg.style.color = "red";
            passwordMsg.style.fontWeight = "bold";
        } else {
            passwordMsg.style.display = "none";
            newPassword.style.borderColor = "green";
        }
        if (this.value === passwordModifyForm.passwordCheck.value && passwordModifyForm.passwordCheck.value !== "") {
            passwordCheck.style.borderColor = "green";
            passwordCheckMsg.style.display = "none";
        } else if (passwordModifyForm.passwordCheck.value !== "") {
            passwordCheckMsg.style.display = "block";
            passwordCheckMsg.innerText = "불일치"
            passwordCheckMsg.style.color = "red";
            passwordCheck.style.borderColor = "red";
        }
    }
    passwordModifyForm.passwordCheck.oninput = function (e) {
        if (passwordModifyForm.newPassword.value === this.value) {
            passwordCheckMsg.style.display = "none";
            passwordCheck.style.borderColor = "green";


        } else {
            passwordCheckMsg.style.display = "block";
            passwordCheckMsg.innerText = "비밀번호가 일치하지 않습니다"
            passwordCheckMsg.style.color = "red";
            passwordCheck.style.borderColor = "red";
        }
    }
    passwordModifyForm.onsubmit = function (e) {
        if (newPassword.value !== passwordCheck.value) {
            e.preventDefault();
            alert("비밀번호가 일치하지 않습니다!");
            return false;
        }
        if (newPassword.value.length < 4) {
            e.preventDefault();
            alert("비밀번호는 4자리 이상이어야 합니다!")
            return false;
        }
    }
</script>
</body>
</html>

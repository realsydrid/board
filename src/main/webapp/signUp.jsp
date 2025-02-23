<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<%@include file="/header.jsp" %>
<form action="./signUp.do" method="post" name="signUpForm">

  <p><label>아이디<input type="text" name="user_id"></label></p>
  <p><label>이름<input type="text" name="user_name"></label></p>

  <p><label>비밀번호<input type="text" name="password"></label></p>
  <p class="msg" id="passwordMsg">비밀번호는 4글자 이상이어야 합니다.</p>
  <p><label>비밀번호확인<input type="text" name="password_check"></label></p>
  <p class="msg" id="passwordCheckMsg"></p>
  <p><label>핸드폰번호<input type="text" name="phone_no"></label></p>
  <button type="submit">가입하기</button>
</form>
<script>
  const signUpForm=document.forms["signUpForm"];
  const passwordMsg=document.getElementById("passwordMsg");
  const passwordCheckMsg=document.getElementById("passwordCheckMsg");
  const passwordInput=signUpForm.password
  const passwordCheckInput=signUpForm.password_check
  signUpForm.password.oninput=function (e){
    if(this.value.length<4){
      passwordMsg.style.display="block";
      passwordInput.style.borderColor="red";
      passwordMsg.style.color="red";
      passwordMsg.style.fontWeight="bold";
    }else{
      passwordMsg.style.display="none";
      passwordInput.style.borderColor="green";
    }
    if (this.value===signUpForm.password_check.value && signUpForm.password_check.value !== ""){
      passwordCheckInput.style.borderColor="green";
      passwordCheckMsg.style.display="none";
    }
    else if(signUpForm.password_check.value !== "") {
      passwordCheckMsg.style.display="block";
      passwordCheckMsg.innerText="불일치"
      passwordCheckMsg.style.color="red";
      passwordCheckInput.style.borderColor="red";
    }
  }
  signUpForm.password_check.oninput=function (e){
    if (signUpForm.password.value===this.value) {
      passwordCheckMsg.style.display="none";
      passwordCheckInput.style.borderColor="green";


    }else {
      passwordCheckMsg.style.display="block";
      passwordCheckMsg.innerText="비밀번호가 일치하지 않습니다"
      passwordCheckMsg.style.color="red";
      passwordCheckInput.style.borderColor="red";
    }
  }
  signUpForm.onsubmit = function(e) {
    if(passwordInput.value !== passwordCheckInput.value) {
      e.preventDefault();
      alert("비밀번호가 일치하지 않습니다!");
      return false;
    }
    if(passwordInput.value.length<4){
      e.preventDefault();
      alert("비밀번호는 4자리 이상이어야 합니다!")
      return false;
    }
  }
</script>

</body>
</html>

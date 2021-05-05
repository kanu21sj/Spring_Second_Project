<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignUp</title>
        <style>
        .container {
            width: 500px;
            margin: 40px auto;
            line-height: 16px;
        }
        h5 {
        	font-size: 20px;
            text-align: left;
        }
        h5 span {
            color: rgb(18, 70, 184);
        }
        #signup {
            background-color: rgb(18, 70, 184);
            color: white;
            border: 0;
            border-radius: 5px;
            padding: 20px 224px;
        }
        .bottom input {
            background-color: white;
            border: 0;
            color: teal;
            font-size: 16px;
        }
        input {
            border: 1px solid lightgray;
            border-radius: 3px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h5><span>회원정보</span></h5>
        <hr><br>
        
        <div class="register">
            <input type="text" id="name" placeholder="${vo2.username}" name="username" style="height:30px; width: 495px"><br>
            <input type="text" id="tel" placeholder="${vo2.usertel}" name="usertel" style="height:30px; width: 495px"><br>
            <input type="text" id="email" placeholder="${vo2.useremail}" name="useremail" style="height:30px; width: 495px"><br>
            <input type="text" id="birth" placeholder="${vo2.userbirth}" name="userbirth" style="height:30px; width: 495px"><br>
            <input type="text" id="type" placeholder="${vo2.usertype}" name="usertype" style="height:30px; width: 495px"><br>
            <input type="text" id="room" placeholder="${vo2.userroom}" name="userroom" style="height:30px; width: 495px"><br>
            <input type="text" id="interest" placeholder="${vo2.userinterest}" name="userinterest" style="height:30px; width: 495px"><br>
        </div>
        <form action="main.jsp" >
        <input type="submit" value="메인으로" id="signup"><br><br>
        </form>
        <form action="ruser_update.jsp" >
        <input type="submit" value="정보수정" id="signup"><br><br>
        </form>
        <form action="ruser_delete.jsp" >
        <input type="submit" value="회원탈퇴" id="signup">
        </form>
    </div>
</body>
</html>
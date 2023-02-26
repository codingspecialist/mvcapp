<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <h1>로그인</h1>
    <hr/>
    <form action="/user/login.do" method="post" enctype="application/x-www-form-urlencoded">
        <input type="text" name="username" placeholder="Enter username" /><br/>
        <input type="password" name="password" placeholder="Enter password" /><br/>
        <button type="submit">로그인</button>
    </form>
</body>
</html>

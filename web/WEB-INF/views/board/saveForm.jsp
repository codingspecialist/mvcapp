<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <h1>게시글 쓰기</h1>
    <hr/>
    <form action="/board/save.do" method="post">
        <input type="text" name="title" placeholder="Enter title" /><br/>
        <input type="text" name="content" placeholder="Enter content" /><br/>
        <button type="submit">글쓰기완료</button>
    </form>
</body>
</html>

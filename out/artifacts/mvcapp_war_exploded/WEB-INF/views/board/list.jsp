<%@ page import="java.util.List" %>
<%@ page import="shop.mtcoding.mvcapp.model.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <h1>게시글 목록</h1>
    <hr/>
    <table border="1">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
        </tr>
        </thead>
        <tbody>
            <%
                List<Board> boardList = (List<Board>) request.getAttribute("boardList");
                for(int i=0; i<boardList.size(); i++){
            %>
            <tr>
                <td><%=boardList.get(i).getId()%></td>
                <td><%=boardList.get(i).getTitle()%></td>
                <td><%=boardList.get(i).getContent()%></td>
            </tr>
            <%
                }
            %>

        </tbody>
    </table>
</body>
</html>

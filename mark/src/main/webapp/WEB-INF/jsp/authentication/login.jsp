<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<html>
<head>
    <title>logout</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }
        table {
            width: 300px;
            height: 200px;
            margin: auto;
        }
    </style>
</head>
<body>

    <h1>로그인</h1>
    <form action="<c:url value='login' /> method="post">
        <table border="">
            <tr>
                <td>
                    <p>아이디</p>
                    <input type="text" name="login_id">
                </td>
            </tr>
            <tr>
                <td>
                    <p>비밀번호</p>
                    <input type="text" name="login_pw">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="로그인">
                </td>
            </tr>
        </table>

    </form>
</body>
</html>
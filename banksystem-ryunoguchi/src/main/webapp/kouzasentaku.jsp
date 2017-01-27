<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="banksystem.bean.*" %>
<%@ page import="java.util.List" %>

<jsp:useBean id="sesObject" class="banksystem.bean.KouzaBean" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>口座選択画面</title>
</head>
<body>
	<div align="right">
		<form style="background-color:SkyBlue" action="./UserLogin" method="GET" >
			<label style="width: 80px; ">ユーザー名</label><label style="width:160; text-align:left">ほげほげ 太郎</label><input type="submit" value="ログアウト" style="width: 100px;">
		</form>
	</div>
	<div style="height:200px;">
		<div style="width:50%; height:100px; ">
			<p>口座選択</p>
			<table class="table01" border="1">
				<thead class="tableheader">
					<tr><td style="width: 100px; height: 20px;">口座種別</td><td style="width:100px; height:20px;">口座番号</td><td style="width:100px; height:20px;">残高</td></tr>
				</thead>
				<tbody>
<%
@SuppressWarnings("unchecked")
List<KouzaBean> list = (List<KouzaBean>)request.getAttribute("sesObject");
%>
<% for(KouzaBean bean: list) { %>
					<tr>
						<td><%= bean.getKouzaSyubetsu() %></td>
						<td><%= bean.getKouzaNumber() %></td>
						<td><%= bean.getKouzaZandaka() %></td>
					</tr>
<% } %>
				</tbody>
			</table>
			
		</div>
		
	</div>
</body>
</html>
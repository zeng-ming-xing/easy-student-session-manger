<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>    
    <title>利用PreparedStatement对象添加一条记录页面</title> 
  </head>
  <body> 
   data insert <%=(Integer)request.getAttribute("n")>0 ? "sucuess":"failed"%> !
  </body>
</html>

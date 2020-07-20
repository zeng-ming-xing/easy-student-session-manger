<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,java.util.*,com.student.vo.*"%>
<html>
    <head> <title>显示所有学生的页面</title> </head>
    <body>
        <center>
        <%
         List<Student> stulist =  (List<Student>)request.getAttribute("stulist");
         
         %>你要查询的学生数据表中共有
          <font size="5" color="red"> <%=stulist.size()%></font>人
          <table border="2" bgcolor= "ccceee" width="650">
               <tr bgcolor="CCCCCC" align="center">
                   <td>记录条数</td> <td>学号</td> <td>姓名</td><td>性别</td> <td>年龄</td><td>体重</td><td>身高</td>
               </tr>
          <% 
            for(int i=0;i<stulist.size();i++)
            {
            	Student stu = stulist.get(i);
          %>   <tr align="center">
                  <td><%=i+1 %></td>
                  <td><%=stu.getId()%></td>
                  <td><%=stu.getName()%></td>
                  <td><%=stu.getSex() %></td>
                  <td><%=stu.getAge() %></td>
                  <td><%=stu.getWeight() %></td>
                  <td><%=stu.getHight() %></td>
                </tr>            
             <% }%>
           </table>
        </center>

    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Archibald
  Date: 2/6/2017
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
<script>
  $(function () {
      $('#test1').setAttribute("src","image/test.jpg");
      $('#test').blur(function () {
//          alert($('#test').val());
//          $.post('test.do',{'mm':1},function (result) {
//              alert(result);
//          });

          $('#show').load('test.do',{'mm':$('#test').val()});
      });
  });
</script>
<% String path=request.getContextPath();%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <input type="text" id="test"><br/>
  <span id="show"></span><br/>
  <form action="save.do">
    <input type="text" name="ab">
    <input type="text" name="b">
    <input type="submit">
  </form>
  上传文件
  <form action="<%=path%>/upload.do" enctype="multipart/form-data" method="post">
    <input type="file" name="picFile" id="picFile">
    <input type="submit">
  </form>
  ${aa}<br/>
  <img id="test1" src='<%=path%>/${pic}'>
  <a href="<%=path%>/download.do?fname=${picName}">download</a>
  </body>
<a href="<%=path%>/save.do?a=15">good</a>
</html>

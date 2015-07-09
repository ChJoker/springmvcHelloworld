<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head> 
  </head>
  
  <body>
 <c:forEach var="hello" items="${hellos}">
 		${hello.say}<br>
</c:forEach>
<form action="/helloworld/helloworld/databind" method="post" enctype="multipart/form-data">
	<input type='text' name='name'/><br>
	<input type='text' name='sons[0].name'/><br>
	<input type='text' name='sons[1].name'/><br>
	<input type="file" name="files"/><br>
	<input type="file" name="files"/><br>
	<input type='submit' value='submit'/> 
</form>
    
  </body>
  <script type="text/javascript" src='http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js'></script>
  <script type="text/javascript">
  		$.ajax({
  			type:'POST',
  			url:'/helloworld/helloworld/ajax',
  			data:{
  				ajaxSendMessage:'I was posted from ajax'
  			},
  			success:function(msg){
  				alert(msg.answer);
  			}

  		})
  </script>
</html>
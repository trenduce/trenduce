<%--
  Created by IntelliJ IDEA.
  User: prafulmantale
  Date: 2/16/15
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form method="POST" enctype="multipart/form-data"
      action="/trenduce/styles/upload">
  File to upload: <input type="file" name="file"><br /> Name: <input
        type="text" name="name"><br /> <br /> <input type="submit"
                                                     value="Upload"> Press here to upload the file!
</form>


</body>
</html>

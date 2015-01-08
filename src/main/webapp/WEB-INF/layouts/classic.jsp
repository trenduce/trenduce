<%--
  Created by IntelliJ IDEA.
  User: prafulmantale
  Date: 1/4/15
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>
      <tiles:getAsString name="tittle"/>
      </title>
</head>
<body>

<tiles:insertAttribute name="body"/>
<br><br>

<tiles:insertAttribute name="footer"/>
</body>
</html>

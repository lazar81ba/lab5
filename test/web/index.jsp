  Created by IntelliJ IDEA.
  User: lazar81ba
  Date: 15.04.18
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="remoteLibrary" class="library.RemoteLibrary" scope="application"></jsp:useBean>
 ${remoteLibrary.test()}
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Ms.Zhong
  Date: 2022/6/14
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <title>Welcome to admin's HDMS</title>
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<h3 style="text-align: center; font-size: 30px;">My Database test</h3>

<c:import var="bookInfo" url="file:///E:/Java/HeuristicsDatabase-%E5%89%AF%E6%9C%AC1/HeuristicsDatabase-%E5%89%AF%E6%9C%AC1/HeuristicsDatabase-%E5%89%AF%E6%9C%AC/src/DatabaseSourse/test/book/book0.xml"/>
<c:import url="http://localhost:8080/HeuristicsDatabase/booking.xsl" var="xslt"/>
<x:transform xml="${bookInfo}" xslt="${xslt}"/>

<c:import var="schoolInfo" url="file:///E:/Java/HeuristicsDatabase-%E5%89%AF%E6%9C%AC1/HeuristicsDatabase-%E5%89%AF%E6%9C%AC1/HeuristicsDatabase-%E5%89%AF%E6%9C%AC/src/DatabaseSourse/test/school/school0.xml"/>
<c:import url="http://localhost:8080/HeuristicsDatabase/schooling.xsl" var="xslt"/>
<x:transform xml="${schoolInfo}" xslt="${xslt}"/>

<%--<c:import var="studentInfo" url="file:///E:/Java/HeuristicsDatabase-%E5%89%AF%E6%9C%AC1/HeuristicsDatabase-%E5%89%AF%E6%9C%AC1/HeuristicsDatabase-%E5%89%AF%E6%9C%AC/src/DatabaseSourse/test/student/student0.xml"/>--%>
<%--<c:import url="http://localhost:8080/HeuristicsDatabase/studenting.xsl" var="xslt"/>--%>
<%--<x:transform xml="${studentInfo}" xslt="${xslt}"/>--%>
</body>
</html>
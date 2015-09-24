<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>List of Offers</title>
</head>
<body>
<h2>List of our Offers</h2>
<%-- // use our pagedListHolder --%>
<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder"/>
<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
<c:url value="/" var="pagedLink">
    <c:param name="action" value="list"/>
    <c:param name="p" value="~"/>
</c:url>

<table>
        <tr>
            <th bgcolor="#CCC" width="80">Picture</th>
            <th width="100">ID</th>
            <th bgcolor="#CCC" width="300">Book</th>
            <th width="100">Author</th>
            <th bgcolor="#CCC" width="60">Year</th>
        </tr>
        <c:forEach items="${pagedListHolder.pageList}" var="offer">
        <tr>
            <td bgcolor="#CCC"><img src="${offer.picture}" width="80" height="80"/></td>
            <td style="padding:15px" width="100">${offer.bookId}</td>
            <td bgcolor="#CCC" style="padding:15px" width="300">${offer.name}</td>
            <td style="padding:15px" width="100">${offer.author}</td>
            <td bgcolor="#CCC" style="padding:15px" width="60">${offer.year}</td>
            <td><a href="<c:url value='/book/${offer.offerId}' />" >details</a>
        </tr>
    </c:forEach>
</table>

<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/>
</body>
</html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true" />
    </title>

    <link href="<s:url value="/resources" />/css/default.css"
          rel="stylesheet"
          type="text/css" />
</head>

<body>
<table border="1" width="100%">
    <tr>
        <td colspan="2" id="headerTD">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td id="menu">
            <tiles:insertAttribute name="menu" />
        </td>
        <td>
            <div id="body">
                <tiles:insertAttribute name="body" />
            </div>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>
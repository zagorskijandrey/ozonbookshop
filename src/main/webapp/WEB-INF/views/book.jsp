<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert book here</title>
    <style>
        .thumb img  {
            border: 2px solid #777777; /* Рамка вокруг фотографии */
            padding: 5px; /* Расстояние от картинки до рамки */
            background: #BBBBBB; /* Цвет фона */
            margin-right: 10px; /* Отступ справа */
            margin-bottom: 10px; /* Отступ снизу */
        }
    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" type="text/javascript" ></script>
    <script src="<c:url value="/resources/ajax/ajax.js" />" type="text/javascript" ></script>
</head>
<body>
<table>
    <tr>
        <td><a class="thumb"> <img src="${offer.picture}" width="200" height="200"/></a>

            <form id="formToSend" action="${pageContext.request.contextPath}/book/${offer.offerId}" method="post">
            <div class="stars">
                <div class="rating" style="width:0%"></div>
                <input type="radio" name="ratValue" id="star5" value="5" onclick="doAjaxPost()">
                <label for="star5"></label>
                <input type="radio" name="ratValue" id="star4" value="4" onclick="doAjaxPost()">
                <label for="star4"></label>
                <input type="radio" name="ratValue" id="star3" value="3" onclick="doAjaxPost()">
                <label for="star3"></label>
                <input type="radio" name="ratValue" id="star2" value="2" onclick="doAjaxPost()">
                <label for="star2"></label>
                <input type="radio" name="ratValue" id="star1" value="1" onclick="doAjaxPost()">
                <label for="star1"></label>
                </div>
            </form>

            <p id="returnResult"></p>


        <th valign="baseline"><font color="#6495ed">${offer.name}</font></br>
            <br><p>${offer.author} (${offer.year})</p></br>
            <br>${offer.ISBN}
        </th>
    </tr>
</table>
<p>${offer.description}</p>
<p>${rating.offer.offerId}</p>
</body>
</html>
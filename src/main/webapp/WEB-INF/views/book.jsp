<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
</head>
<body>
<table>
    <tr>
        <td><a class="thumb"> <img src="${offer.picture}" width="200" height="200"/></a></td>
        <th valign="baseline"><font color="#6495ed">${offer.name}</font></br>
            <br><p>${offer.author} (${offer.year})</p></br>
            <br>${offer.ISBN}
        </th>
    </tr>
</table>
    <p>${offer.description}</p>
<p></p>
</body>
</html>
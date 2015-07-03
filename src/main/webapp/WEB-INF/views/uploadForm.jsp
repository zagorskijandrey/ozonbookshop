<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>

<body>
<h2>Upload catalog</h2>
        <form:form method="post" action="fileUpload">
        Please select file: <label>
            <input type="text" name="path"/>
        </label>
            <input type="submit" value="upload" />
            <span>
                <form:errors path="file" cssClass="error" />
            </span>

        </form:form>

</body>
</html>

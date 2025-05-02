<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Quote</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Edit Quote</h1>
    <form:form method="POST" action="/update/${quote.id}" modelAttribute="quote">
        <div>
            <label>Author:</label>
            <form:input path="author" />
            <form:errors path="author" cssClass="error" />
        </div>
        <div>
            <label>Quote:</label>
            <form:textarea path="quoteText" rows="5" cols="40" />
            <form:errors path="quoteText" cssClass="error" />
        </div>
        <form:hidden path="id" />
        <div>
            <input type="submit" value="Update Quote" />
        </div>
    </form:form>
    <div>
        <a href="/list">Back to List</a>
    </div>
</body>
</html>

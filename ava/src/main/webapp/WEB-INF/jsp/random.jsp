<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quote of the Day</title>
</head>
<body>
    <h1>Quote of the Day</h1>
    <div>
        <c:if test="${quote != null}">
            <blockquote>
                <p>${quote.quoteText}</p>
                <footer>— ${quote.author}</footer>
            </blockquote>
        </c:if>
        <c:if test="${quote == null}">
            <p>No quotes available.</p>
        </c:if>
    </div>
    <div>
        <a href="/">Another Quote</a> | 
        <a href="/list">View All Quotes</a>
    </div>
</body>
</html>
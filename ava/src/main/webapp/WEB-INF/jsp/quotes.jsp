<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>All Quotes</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>All Quotes</h1>
    <div>
        <a href="/">Back to Random Quote</a> | 
        <a href="/add">Add New Quote</a>
    </div>
    <br>
    <table>
        <thead>
            <tr>
                <th>Author</th>
                <th>Quote</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${quotes}" var="quote">
                <tr>
                    <td>${quote.author}</td>
                    <td>${quote.quoteText}</td>
                    <td>
                        <a href="/edit/${quote.id}">Edit</a> | 
                        <a href="/delete/${quote.id}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

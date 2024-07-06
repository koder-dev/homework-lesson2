<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Statistics Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            text-align: center;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #4CAF50;
        }
        .stats {
            margin-top: 20px;
            font-size: 1.2em;
        }
        .stats div {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Statistics</h1>
    <div class="stats">
        <div>Total Resumes Submitted: <%= request.getAttribute("totalCvs") %></div>
        <div>Average age of candidates: <%= request.getAttribute("averageAge") %></div>
    </div>
</div>
</body>
</html>


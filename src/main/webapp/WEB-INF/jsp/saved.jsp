<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Išsaugotos temperatūros</title>
    <jsp:include page="header.jsp"/>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #080710;
            color: white;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.13);
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 40px rgba(8, 7, 16, 0.6);
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
        }

        th {
            background-color: rgba(255, 255, 255, 0.07);
            color: white;
            font-weight: 500;
            text-transform: uppercase;
            font-size: 14px;
            letter-spacing: 1px;
        }

        tr:last-child td {
            border-bottom: none;
        }

        tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.05);
        }

        tr:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        a {
            color: white;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
        td{
            color: white;
        }

        .search-bar {
            display: flex;
            border: 1px solid #ccc;
            border-radius: 4px;
            overflow: hidden;
            box-shadow: 0 0 40px rgba(8, 7, 16, 0.6);
            margin-bottom: 20px;
            background-color: rgba(255, 255, 255, 0.13);
        }

        .search-input {
            border: none;
            padding: 10px;
            flex-grow: 1;
            font-family: 'Poppins', sans-serif;
            background-color: transparent;
            color: white;
        }

        .search-input::placeholder {
            color: white;
        }

        .search-button {
            border: none;
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            cursor: pointer;
            font-family: 'Poppins', sans-serif;
        }

        .search-button:hover {
            background-color: #0056b3;
        }
        .search-input::placeholder {
            color: rgba(255, 255, 255, 0.5);
        }
    </style>
</head>
<body class="container">
    <form class="search-bar" action="/saved" method="GET">
        <input type="text" name="query" class="search-input" placeholder="Ieškoti pagal 'Temperatūra °C'">
        <button type="submit" class="search-button">Ieškoti</button>
    </form>
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <sec:authorize access="hasAnyAuthority('ADMIN')">
                    <th>Id</th>
                </sec:authorize>
                <th>Įrašo laikas</th>
                <th>Temperatūra °C</th>
                <th>Temperatūra °F</th>
                <th>Operacijos</th>
            </tr>

            <c:forEach var="record" items="${data}">
                <c:url var="edit" value="/edit">
                    <c:param name="id" value="${record.id}"/>
                </c:url>

                <c:url var="delete" value="/delete">
                    <c:param name="id" value="${record.id}"/>
                </c:url>

                <c:url var="view" value="/view">
                    <c:param name="id" value="${record.id}"/>
                </c:url>

                <tr>
                    <sec:authorize access="hasAnyAuthority('ADMIN')">
                        <td>${record.id}</td>
                    </sec:authorize>
                    <td>${record.date}</td>
                    <td>${record.temperatureCelsius}</td>
                    <td>${record.temperatureFahrenheit}</td>
                    <td>
                        <sec:authorize access="hasAnyAuthority('ADMIN')">
                            <a href="${edit}">Keisti</a> |
                            <a href="${delete}" onclick="return confirm('Ar tikrai norite ištrinti šį įrašą?')">Trinti</a> |
                        </sec:authorize>
                        <a href="${view}">Rodyti</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

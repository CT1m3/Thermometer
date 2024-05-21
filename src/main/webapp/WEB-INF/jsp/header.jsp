<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .header-component .header-header {
            font-family: 'Poppins', sans-serif;
        }

        .header-component .navbar {
            margin-bottom: 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: rgba(255,255,255,0.13);
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
            backdrop-filter: blur(10px);
            border-bottom: 2px solid rgba(255,255,255,0.1);
            box-shadow: 0 0 40px rgba(8,7,16,0.6);
            height: 70px;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
        }

        .header-component .navbar-brand,
        .header-component .navbar-nav > li > a {
            color: white;
            text-decoration: none;
            font-size: 20px;
            font-weight: bold;
        }

        .header-component .navbar-brand:hover,
        .header-component .navbar-nav > li > a:hover {
            color: white;
        }

        .header-component .user-role span {
            font-weight: bold;
        }

        .header-component .user-role .user {
            color: green;
        }

        .header-component .is {
            margin-right: 60vw;
        }

        body.header-component {
            padding-top: 100px;
        }
    </style>
</head>
<body class="header-component">
<nav class="navbar navbar-default header-header">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Termometras</a>
        <ul class="nav navbar-nav">
            <li class="active is"><a href="/saved">Išsaugotos temperatūros</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right user-role">
            <li><a style="font-size: 15px; color: white;">Vartotojas: <span class="user">${pageContext.request.userPrincipal.name}</span></a></li>
            <li style="margin-left: auto;"><a style="font-size: 15px; background-color: red; padding: 4px 5px; border-radius: 10px;" href="${pageContext.request.contextPath}/logout">Atsijungti</a></li>
        </ul>
    </div>
</nav>
</body>
</html>

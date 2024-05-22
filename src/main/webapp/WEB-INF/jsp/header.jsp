<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body style="padding-top: 100px;">
<nav class="navbar navbar-default" style="
    font-family: 'Poppins', sans-serif;
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
    left: 0;
    width: 100%;
    z-index: 1000;">
    <div class="container-fluid">
        <a class="navbar-brand" href="/" style="color: white; text-decoration: none; font-size: 20px; font-weight: bold;">
            Termometras
        </a>
        <ul class="nav navbar-nav">
            <li class="active" style="margin-right: 60vw;">
                <a href="/saved" style="color: white; text-decoration: none; font-size: 20px; font-weight: bold;">
                    Išsaugotos temperatūros
                </a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right" style="font-weight: bold;">
            <li>
                <a style="font-size: 15px; color: white;">
                    Vartotojas: <span style="color: green;">${pageContext.request.userPrincipal.name}</span>
                </a>
            </li>
            <li style="margin-left: auto;">
                <a href="${pageContext.request.contextPath}/logout" style="font-size: 15px; background-color: red; padding: 4px 5px; border-radius: 10px; text-decoration: none; color: white;">
                    Atsijungti
                </a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>

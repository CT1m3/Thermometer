<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <jsp:include page="header.jsp"/>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Dosis:200,400,500,600);
        @import url(https://fonts.googleapis.com/css?family=Poppins:200,400,500,600);
        html, body { height: 100%; }
        body { background: #080710;}

        .container { width: 300px; margin: 10px auto 0; }
        .de .den, .de .dene, .de .denem, .de .deneme { position: absolute;  left: 50%; top: 50%; }
        .de {
            position: relative;
            width: 240px;
            height: 500px;
            border-radius: 100%;
            box-shadow: 0 0 10px rgba(0, 0, 0, .1);
            background-color: transparent;
        }
        .den {
            position: relative;
            width: 210px;
            height: 210px;
            margin: -105px 0 0 -105px;
            border-radius: 100%;
            box-shadow: inset 0 2px 10px rgba(0, 0, 0, .5), 0 2px 20px rgba(255, 255, 255, 1);
            background: #df3341;
            background: -moz-linear-gradient(left, #df3341 0%, #d4f355 50%, #61c0ec 100%);
            background: -webkit-gradient(linear, left top, right top, color-stop(0%,#df3341), color-stop(50%,#d4f355), color-stop(100%,#61c0ec));
            background: -webkit-linear-gradient(left, #df3341 0%,#d4f355 50%,#61c0ec 100%);
            background: linear-gradient(to right, #df3341 0%,#d4f355 50%,#61c0ec 100%);
        }
        .dene {
            width: 180px;
            height: 180px;
            margin: -90px 0 0 -90px;
            border-radius: 100%;
            box-shadow: inset 0 2px 2px rgba(255, 255, 255, .4), 0 3px 13px rgba(0, 0, 0, .85);
            background: #f2f6f5;
            background: -moz-linear-gradient(top, #f2f6f5 0%, #cbd5d6 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f2f6f5), color-stop(100%, #cbd5d6));
            background: -webkit-linear-gradient(top, #f2f6f5 0%, #cbd5d6 100%);
            background: -o-linear-gradient(top, #f2f6f5 0%, #cbd5d6 100%);
        }
        .denem {
            width: 160px;
            height: 160px;
            margin: -80px 0 0 -80px;
            border-radius: 100%;
            background: #cbd5d6;
            background: -moz-linear-gradient(top, #cbd5d6 0%, #f2f6f5 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #cbd5d6), color-stop(100%, #f2f6f5));
            background: -webkit-linear-gradient(top, #cbd5d6 0%, #f2f6f5 100%);
        }

        .deneme {
            padding: 10px 10px 0 10px;
            width: 120px;
            height: 137px;
            display: inline-block;
            margin: -85px 0 0 -75px;
            color: #555;
            text-shadow: 1px 1px 1px white;
            font-family: 'Dosis';
            font-size: 100px;
            font-weight: 400;
            text-align: center;
        }
        .deneme span { font-size: 30px; font-weight: 200; }
        .deneme strong { position: absolute; right: -10px; top: 25px; font-size: 34px; }

		.btn {
          	font-family: 'Poppins', sans-serif;
    		position: absolute;
    		top: 50%;
    		transform: translateY(40%);
    		padding: 10px 20px;
    		font-size: 16px;
    		border: none;
            background: transparent;
  			color: #FFF;
    		border: none;
    		border-radius: 5px;
    		cursor: pointer;
            width: 130px;
  			height: 40px;
  			outline: none;
            box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   			7px 7px 20px 0px rgba(0, 255, 255,.1),
   			4px 4px 5px 0px rgba(0, 255, 255,.1);
  			outline: none;
    		transition: background-color 0.3s ease;
		}
		.btn:after {
  			position: absolute;
  			content: "";
  			width: 0;
  			height: 100%;
  			top: 0;
  			left: 0;
  			direction: rtl;
  			z-index: -1;
            border-radius: 5px;
  			box-shadow:
   			-7px -7px 20px 0px #fff9,
   			-4px -4px 5px 0px #fff9,
   			7px 7px 20px 0px #0002,
   			4px 4px 5px 0px #0001;
  			transition: all 0.3s ease;
			}
		.btn:hover {
  			color: #FFF;
		}
		.btn:hover:after {
  			left: auto;
  			right: 0;
  			width: 100%;
		}

		.btn.status {
    		right: 40vw;
		}

		.btn.record {
    		left: 37vw;
		}

    </style>
    <meta http-equiv="refresh" content="0.5">
</head>
<body>
    <div class="container">
        <div class="de">
            <div class="den">
                <div class="dene">
                    <div class="denem">
                        <div class="deneme">
                            ${tempWhole}<span>.${tempDecimal}</span><strong>&deg;</strong>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		<button class="btn record">Įrašyti</button>
		<button class="btn status">Statusas</button>
    </div>
</body>
</html>

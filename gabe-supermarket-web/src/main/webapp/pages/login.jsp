<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gatcheni FP Service | Login</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min_1.css'/>">
        <link rel="stylesheet" href="<c:url value='/assets/css/font-awesome.min.css"'/>">
        <link rel="stylesheet" href="<c:url value='/assets/css/form-elements.css"'/>">
        <link rel="stylesheet" href="<c:url value='/assets/css/style-old.css"'/>">

    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Welcome to Gacheni FP Services &trade;</a>
                </div>               
            </div>
        </nav>
        <!-- Top content -->
        <div class="top-content">

            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <div class="description">
                                <p>
                                <div class="error" style="display: none;">
                                    <span id="message"></span>
                                </div>
                                </p>
                            </div>
                        </div>
                    </div>                    
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Login</h3>                                  
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" class="login-form">
                                    <div class="form-group">
                                        <label for="username">Username</label>
                                        <input type="text" name="username" placeholder="Username..." class="form-username form-control" id="username">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="password">
                                    </div>
                                    <button type="button" class="btn loginBtn">Sign in!</button>
                                </form>                             
                            </div>
                        </div>
                    </div>                   
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="<c:url value='/assets/js/vendor/jquery-2.1.4.min.js"'/>"></script>
        <script src="<c:url value='/assets/js/bootstrap.min.js"'/>"></script>
        <script src="<c:url value='/assets/js/jquery.backstretch.min.js"'/>"></script>
        <script src="<c:url value='/assets/js/scripts.js"'/>"></script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>       
        <![endif]-->

    </body>

</html>
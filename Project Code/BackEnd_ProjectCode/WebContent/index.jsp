<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Login Page</title>
  <link rel="shortcut icon" href="favicon.png">
  <!---CSS Files-->
  <link rel="stylesheet" href="css/master.css">
  <link rel="stylesheet" href="css/login.css">
  <!---jQuery Files-->
  <script src="js/jquery-1.7.1.min.js"></script>
  <script src="js/jquery.spinner.js"></script>
  <script type="text/javascript" src="js/forms/jquery.validate.min.js"></script>
  <!---Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>

  <script>
    $(document).ready(function () {
       $('div.wrapper').hide();
        $('div.wrapper').fadeIn(1200);
        $('#lg-form').validate();
        $('.submit').click(function() {
        var $this = $(this);
        $this.spinner();
        setTimeout(function() {
                $this.spinner('remove');
        }, 1000);
       });
    });
  </script>
</head>
<body>
	<div class="wrapper">
		<div class="logo">
	 	<h1 style="margin-right: 175px" >LOGIN PAGE</h1>
	 </div>
   <div class="lg-body">
     <div class="inner">
       <div id="lg-head">
         <p><span class="font-bold">Please use your GitHub account to login</span></p>
         <div class="separator"></div>
       </div>
       <div class="login">
         <form id="lg-form" method="post" action="${pageContext.request.contextPath}/getUserInfo"> 
           <fieldset>
           <div style="color:red">
           <%=request.getAttribute("loginData")==null?"":request.getAttribute("loginInfo")%></div>

              <ul>
                 <li id="usr-field">
                  <input class="input required" name="username" type="text" size="26" minlength ="1" placeholder="Username..." />
                 </li>
                 <li class="checkbox">
                  <input class="checkbox" type="checkbox" id="remember-me" value="remember" /> 
                  <label for="remember-me" class="checkbox-text">Remeber Me</label>
                 </li>
                 <li>
                  <input class="submit" type="submit" value="" name="submit"/>
                 </li>
              </ul>
           </fieldset>
          </form>
          <span id="lost-psw">
           <a href="#">I forgot my password</a>
          </span>
        </div>
     </div>
    </div>
	</div>

</body>
</html>
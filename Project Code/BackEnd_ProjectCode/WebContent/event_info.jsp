<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
	<head>
	  <meta charset="utf-8">
	  <title>Detail Information</title>
	  <link rel="shortcut icon" href="favicon.gif">
	  <!---CSS Files-->
	  <link rel="stylesheet" href="css/master.css">
	  <!---jQuery Files-->
	  <script src="js/jquery-1.7.1.min.js"></script>
	  <script src="js/jquery-ui-1.8.17.min.js"></script>
	  <script src="js/styler.js"></script>
	  <script src="js/jquery.tipTip.js"></script>
	  <script src="js/colorpicker.js"></script>
	  <script src="js/sticky.full.js"></script>
	  <script src="js/global.js"></script>
	  <!---Fonts-->
	  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
	  <!--[if lt IE 9]>
	  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	  <![endif]-->
	</head>
	<body>
	
	  <!--- HEADER -->
	<jsp:include page="/header.jsp">
	<jsp:param value="${username }" name="username"/>
	</jsp:include>
	
	  <!--- CONTENT AREA -->
	
	  <div class="content container_12">
	     <h4 id="error-heading" >Detail</h4>
	     <p id="error-desc">You are not authorized to view this page.<br><br>
	      You shall now receive a quite painful virtual slap on the wrist.</p>
	     <p id="error-desc">You are not authorized to view this page.<br><br>
	      You shall now receive a quite painful virtual slap on the wrist.</p>
	     <p id="error-back">Not interested in this information, <a href="">go to the dashboard.</a>
	     </p>
	  </div>
	  
		<!-- FOOTER -->
	  <jsp:include page="/footer.jsp"></jsp:include>
	
	
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Tables</title>
  <link rel="shortcut icon" href="favicon.png">
  <!---CSS Files-->
  <link rel="stylesheet" href="css/master.css">
  <link rel="stylesheet" href="css/tables.css">
  <!---jQuery Files-->
  <script src="js/jquery-1.7.1.min.js"></script>
  <script src="js/jquery-ui-1.8.17.min.js"></script>
  <script src="js/styler.js"></script>
  <script src="js/jquery.tipTip.js"></script>
  <script src="js/colorpicker.js"></script>
  <script src="js/sticky.full.js"></script>
  <script src="js/global.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <!---Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <!--[if lte IE 8]>
  <script language="javascript" type="text/javascript" src="js/flot/excanvas.min.js"></script>
  <![endif]-->
</head>
<body>

  <!--- HEADER -->

<jsp:include page="/header.jsp">
	<jsp:param name="username" value="${username }" />
	<jsp:param value="${user_avatar}" name="user_avatar"/>
</jsp:include>

  <!--- CONTENT AREA -->

  <div class="content container_12">
      <div class="box grid_12">
        <div class="box-head"><h2>All unusual events</h2></div>
        <div class="box-content no-pad">
        <table class="display" id="dt3">
        <thead>
          <tr>
            <th width = 150>Repository name</th>
            <th>Artifact</th>
            <th width = 400>Description</th>
            <th>Happened date</th>
            <th>Feedback</th>
            
          </tr>
        </thead>
        <tbody>
	        <c:forEach items="${unusualEventsList }" var="unusualevent">
		        <tr class="odd gradeX">
		            <td class="center">${unusualevent.repository_name }</td>
		            <td class="center">${unusualevent.event_artifact } : ${unusualevent.event_name }</td>
		            <td class="center">${unusualevent.detail }</td>
		            <td class="center">${unusualevent.happened_date }</td>
		            <td class="center">view</td>
		          </tr>
	        </c:forEach>
        </tbody>
      </table>
        </div>
      </div>

      

      <div class="box grid_10">
        <div class="box-head"><h2>Unusual event Definition</h2></div>
        <div class="box-content no-pad">
        <table class="display" id="dt1">
        <thead>
          <tr>
            <th width = 100>ID</th>
            <th>Artifact</th>
            <th>Definition</th>
            <th>Vote</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${eventNameList}" var="eventname">
	         <tr class="odd gradeX">
	            <td class="center">${eventname.event_name_id }</td>
	            <td class="center">${eventname.event_artifact }</td>
	            <td class="center">${eventname.event_name }</td>
	            
	            <td class="center">up:${eventname.up_number }&nbsp; down:${eventname.down_number }</td>
	            </tr>
        </c:forEach>
         
        </tbody>
      </table>
        </div>
      </div>

<jsp:include page="/footer.jsp"></jsp:include>

<script> /* SCRIPTS */
  $(function () {
    $('#dt1').dataTable( {
        "bJQueryUI": true   
    });
    $('#dt2').dataTable( {
        "bJQueryUI": true     
    });
    $('#dt3').dataTable( {
        "bJQueryUI": true,
        "sPaginationType": "full_numbers"   
    }); /* For the data tables */
  });
</script>


</body>
</html>
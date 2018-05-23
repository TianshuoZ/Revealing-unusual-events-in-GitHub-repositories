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
	<jsp:param name="user_avatar" value="${user_avatar }" />
</jsp:include>

  <!--- CONTENT AREA -->

  <div class="content container_12">
      <div class="box grid_12">
        <div class="box-head"><h2>Pull Request</h2></div>
        <div class="box-content no-pad">
        <table class="display" id="dt3">
        <thead>
          <tr>
            <th>Time</th>
            <th>Content</th>
            <th>Repository</th>
            <th>Comment Number</th>
          </tr>
        </thead>
        <tbody>
	        <c:forEach items="${pullRequestsList }" var="pullRequest">
	        		<tr class="odd gradeX">
		            <td>${pullRequest.pull_request_date }</td>
		            <td>${pullRequest.title } : ${pullRequest.body }</td>
		            <td>${pullRequest.repository_name }</td>
		            <td class="center"> ${pullRequest.comment_number }</td>
          		</tr>
	        </c:forEach>
        </tbody>
      </table>
        </div>
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
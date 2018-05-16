<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Welcome!</title>
  <link rel="shortcut icon" href="favicon.png">
  <!---CSS Files-->
  <link rel="stylesheet" href="css/master.css">
  <link rel="stylesheet" href="css/tables.css">
  <!---jQuery Files-->
  <script src="js/jquery-1.7.1.min.js"></script>
  <script src="js/jquery-ui-1.8.17.min.js"></script>
  
  <!---<script src="js/styler.js"></script>-->
  
  <script src="js/jquery.tipTip.js"></script>
  <script src="js/colorpicker.js"></script>
  <script src="js/sticky.full.js"></script>
  <script src="js/global.js"></script>
  <script src="js/flot/jquery.flot.min.js"></script>
  <script src="js/flot/jquery.flot.resize.min.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <!---Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>
  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <!--[if lte IE 8]>
  <script language="javascript" type="text/javascript" src="js/flot/excanvas.min.js"></script>
  <![endif]-->
</head>
<body>

  <!--- HEADER -->

	<!-- <div class="header"> -->
   <!-- <a href="dashboard.html"><img src="img/logo.png" alt="Logo" /></a>  -->
   <!-- <div class="styler"> -->
     <!-- <ul class="styler-show"> -->
       <!-- <li><div id="colorSelector-top-bar"></div></li> -->
       <!-- <li><div id="colorSelector-box-head"></div></li> -->
     <!-- </ul> --> 
   <!-- </div> -->
  <!-- </div> -->
  
  <!-- 引入 header.jsp -->
<jsp:include page="/header.jsp">
  <jsp:param value="${username }" name="username"/>
  <jsp:param value="${userList[0].user_avatar }" name="user_avatar"/>
  
</jsp:include>
 
 <%-- <%@include file="header.jsp" %> --%>

  <!--- CONTENT AREA -->

  <div class="content container_12">
      <%-- <div class="ad-notif-info grid_12">
      	<p>
	      	Welcome, ${userList[0].user_name }, you can click here to dismiss me...

      	</p>
      </div> --%>
      <div class="box grid_3">
        <div class="box-head"><h2>Latest Unusual Event</h2></div>
        <c:choose>
	        <c:when test="${empty latestEventList}">
		       <div class="box-content">
			         <br>
		          	<br><br>
			         	<p style="font-size:18px; text-align:center">There is no any recent event!</p>
			         <br><br>
		          	<br><br>
	       		 </div>
	        </c:when>
	        
	        <c:otherwise>
    		 	   	<div class="box-content ad-stats">
		          <p>
		          	<c:forEach items="${latestEventList}" var="event">
			          	<ul>
				            <li><h3 style="padding-right: 50px;padding-left: 55px;width: 165px;height: 20px;text-align:center">${event.happened_date }</h3>Time</li>
				            	<li><h3 style="padding-right: 50px;padding-left: 55px;width: 165px;height: 20px;;padding-top: 4px;text-align:center">${event.event_artifact }</h3>Type</li>
				            <li><h3 style="padding-right: 50px;padding-left: 55px;width: 165px;height: 20px;text-align:center"> ${event.event_name }</h3>Name</li>
				            <center>
				            <li>
				            	<td><h3 style="padding-right: 5px;padding-left: 5px;text-align:center;"><font color="#a62626">${event.up_number }</font></h3>Like</td>
				           		<td><h3 style="padding-right: 5px;padding-left: 5px;text-align:center;"><font color="#6f9300">${event.down_number }</font></h3>Dislike</td>
				            </li>
				            </center>
				        </ul>
		          	</c:forEach>
		          	<br>
		          <center><input type="button" class="button green" value="Detail information" /></center>
		          </p>
		        </div>
	        </c:otherwise>
        </c:choose>
        
        
      </div>
      <div class="box grid_3">
        <div class="box-head"><span class="box-icon-24 fugue-24 counter"></span><h2>Status</h2></div>
        <div class="box-content ad-stats">
          <ul>
            <li><h3>${repository }</h3>Repository</li>
   
            <li class="stats-down">
            <h3>
           		${commitNum }
            </h3>Commits</li>
            
            <li class="stats-down">
            <h3>
            		${issueNum }
            </h3>Issues</li>
            		
            <li class="stats-down">
            <h3>
				${ pullRequestNum }
            </h3>Pull Requests</li>
            
            <li class="stats-up"><h3>${unusualEvents }</h3>Unusual Events</li>
          </ul>
        </div>
      </div>
      <div class="box grid_6">
        <div class="box-head"><span class="box-icon-24 fugue-24 system-monitor"></span><h2>Monthly Chart</h2></div>
        <div class="box-content">
          <div id="flot-demo"></div>
        </div>
      </div>
      <div class="box grid_12">
        <div class="box-head"><h2>Repository Information</h2></div>
        <div class="box-content no-pad">
        <table class="display" id="example">
        <thead>
          <tr>
            <th>Repository Name</th>
            <th>Created Date</th>
            <th>Commits Number</th>
            <th>Issues Number</th>
            <th>Pull Requests Number</th>
          </tr>
        </thead>
        <tbody>
        		<c:forEach items="${repositoryList }" var="repository">
        			<tr class="odd gradeX">
		            <td>${repository.repository_name } <input style="float: right;" type="button" class="button green" value="Download" /></td>
		            <td>${repository.create_date }</td>
		            <td class="center">${repository.commit_number} </td>
		            <td class="center">${repository.issue_number}</td>
		            <td class="center">${repository.pull_request_number}</td>
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
      var sin = [], cos = [];
      for (var i = 0; i < 14; i += 0.5) {
          sin.push([i, Math.sin(i)]);
          cos.push([i, Math.cos(i)]);
      }
      var plot = $.plot($("#flot-demo"),
             [ { data: sin, label: "Green", color: "#71a100"}, { data: cos, label: "Blue", color: "#308eef" } ], {
                 series: {
                     lines: { show: true },
                     points: { show: true }
                 },
                 grid: { hoverable: true },
                 yaxis: { min: -1.2, max: 1.2 }
               });
      var previousPoint = null;
      $("#flot-demo").bind("plothover", function (event, pos, item) {
          if ($("#enablePosition:checked").length > 0) {
              var str = "(" + pos.x.toFixed(2) + ", " + pos.y.toFixed(2) + ")";
              $("#hoverdata").text(str);
          }
      });
  });/* for the flot chart demo */

  $('#example').dataTable( {
      "bJQueryUI": true
  }); /* For the data tables */
</script>


</body>
</html>
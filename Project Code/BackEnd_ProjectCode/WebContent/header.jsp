<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%-- <%=request.getParameter("username") %> --%>
  <div class="top-bar">
      <ul id="nav">
        <li id="user-panel">
        		
          <img src="img/nav/usr-avatar.jpg" style="width:47px;height:47px" id="usr-avatar" alt="" />
          <div id="usr-info">
            <p id='usr-name'>${username } </p>	
       		<p id='usr-notif' style="font-size: 10px; margin-bottom:2px">Welcome to Unusual Events</p>
       		<p id='usr-name' style="font-size: 8px">You can log out by<a href='index.jsp'> &nbsp;clicking here</a></p>
          </div>
        </li>
        <li>
        <ul id="top-nav">
         <li class="nav-item">  <%-- username=<%=request.getParameter("username")%> --%>
           <a href="${pageContext.request.contextPath }/getUserInfo?username=${username}"><img src="img/nav/dash-active.png" alt="" /><p>Dashboard</p></a>
         </li>
         <li class="nav-item">
           <a href="#"><img src="img/nav/anlt.png" alt="" /><p>Individual</p></a>
           <ul class="sub-nav">
            <li><a href="${pageContext.request.contextPath }/showIndCommits?username=${username}">Commits</a></li>
            <li><a href="#">Issues</a></li><%-- ${pageContext.request.contextPath }/showIndIssues?username=${username} --%>
            <li><a href="#">Pull Requests</a></li><%-- ${pageContext.request.contextPath }/showIndPullRequest?username=${username} --%>
          </ul>
         </li>
          <li class="nav-item">
           <a href="#"><img src="img/nav/grid.png" alt="" /><p>My Team</p></a>
           <ul class="sub-nav">
            <li><a href="#">Commits</a></li><%-- ${pageContext.request.contextPath }/showTeamCommits?username=${username} --%>
            <li><a href="#">Issues</a></li><%-- ${pageContext.request.contextPath }/showTeamIssues?username=${username} --%>
            <li><a href="#">Pull Requests</a></li><!-- ${pageContext.request.contextPath }/showTeamPullRequest?username=${username} -->
          </ul>
         </li>
         <li class="nav-item">
           <a href="${pageContext.request.contextPath }/getUnusualEventsList?username=${username}"><img src="img/nav/tb.png" alt="" /><p>Tables</p></a>
         </li>
       </ul>
      </li>
     </ul>
     
 <!-- 		<script type="text/javascript">
  		//header.jsp 加载完毕之后去服务器端获得 用户名
  		$(function(){
  			var content = "";
  			$.post(
  				"${pageContext.request.contextPath}/getUserName",
  				function(data){
  					//content 应该加上的语句应该是拼串, 
  					//{"userid":3,"username":"jiexinli","userpwd":"123"}
  					content+="<p id='usr-name'>Welcome, &nbsp; "+data[0].user_name+" </p>"
  					//content+= "<p id='usr-name'>Welcome, &nbsp; "++" </p>";
  					/* for(var i= 0; i<data.length;i++){
  					}
  					 */ 
  					/* <p>&nbsp;"+data[0].username+"</p> */
  					//将剩下的 p 标签加入到 content 里
  					//将拼好串的语句放到p中
  					content+= "<p id='usr-notif'>You have 1 notifications. <a href='#'>View</a></p><p><a href='#'>Profile</a><a href='index.jsp'>Log out</a></p>";
  					$("#usr-info").html(content);
  				},
  				"json"
  			);
  		});
  </script> -->
  </div>
  
    
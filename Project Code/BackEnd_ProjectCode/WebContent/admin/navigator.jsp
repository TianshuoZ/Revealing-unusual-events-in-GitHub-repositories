<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <div class="sidebar-nav">
       <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>Dashboard</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="${pageContext.request.contextPath }/adminLogin">Home</a></li>
            <li ><a href="${pageContext.request.contextPath }/adminEvents">Events List</a></li>
            <li ><a href="${pageContext.request.contextPath }/adminUsers">Users</a></li>
            
        </ul>
    </div>
</html>
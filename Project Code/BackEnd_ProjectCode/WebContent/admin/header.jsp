<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> Jack
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="${pageContext.request.contextPath }/admin/signin.jsp">Logout</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="${pageContext.request.contextPath }/adminLogin"><span class="first">Backstage</span> <span class="second">System</span></a>
        </div>
    </div>
</html>
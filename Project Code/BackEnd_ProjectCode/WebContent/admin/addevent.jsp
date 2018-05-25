<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
  
 <!-- ---------------Header----------------- -->
    		<jsp:include page="/admin/header.jsp"></jsp:include>
    <!-- -------------navigator-------------- -->
		<jsp:include page="/admin/navigator.jsp"></jsp:include>
		 
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Add Event Type</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
            <li><a href="eventlist.jsp">Unusual Events</a> <span class="divider">/</span></li>
            <li class="active">Add Event</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
    <form id="tab">
        <label>Type</label>
        <select name="DropDownTimezone" id="DropDownTimezone" class="input-xlarge">
          <option value="0">Commits</option>
          <option value="0">Issues</option>
          <option value="0">Pull Requests</option>
        </select>

        <label>Desceiption</label>
        <textarea value="Smith" rows="3" class="input-xlarge"> number of comments
        </textarea>

        <label>Greater Than</label>
        <input type="text" value="5" class="input-xlarge">

        <label>Less Than</label>
        <input type="text" value="0" class="input-xlarge"> 

        <label>Equals</label>
        <input type="text" value="20" class="input-xlarge"> 

        <div class="btn-toolbar">
    <button class="btn btn-primary"><i class="icon-save"></i> Save</button>
        </div>  
    </form>
    
    <!-- ------------footer------------- -->
    <jsp:include page="/admin/footer.jsp"></jsp:include>
    
      </div>
  </div>
</div>
</html>
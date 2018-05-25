<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
    <!-- ---------------Header----------------- -->
    		<jsp:include page="/admin/header.jsp"></jsp:include>
    <!-- -------------navigator-------------- -->
		<jsp:include page="/admin/navigator.jsp"></jsp:include>
  <!-- ----------dashboard content page----------- -->
    
    <div class="content">
        
        <div class="header">
            <h1 class="page-title">Dashboard</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
            <li class="active">Dashboard</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">

<!--     <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>Just a quick note:</strong> Hope you like the theme!
    </div> -->

    <div class="block">
        <a href="#page-stats" class="block-heading" data-toggle="collapse">Latest Stats</a>
        <div id="page-stats" class="block-body collapse in">

            <div class="stat-widget-container">
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">2,500</p>
                        <p class="detail">Users</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">3,299</p>
                        <p class="detail">Repositories</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">6</p>
                        <p class="detail">Unusual Events</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">10,242 MB</p>
                        <p class="detail">Capacity Remaining</p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">Unusual Events</a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>Event ID</th>
                  <th>Name</th>
                  <th>Description</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>commits</td>
                  <td>number of LOC modified</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>issues</td>
                  <td>number of comments</td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>pull requests</td>
                  <td>number of comments</td>
                </tr>
              </tbody>
            </table>
            <p><a href="users.html">More...</a></p>
        </div>
    </div>
        <div class="block span6">
        <a href="#" class="block-heading" data-toggle="collapse">Users</a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Last Login Time</th>
                  <th>Repository Number</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>TianshuoZhang</td>
                  <td>2018-05-24</td>
                  <td>8</td>
                </tr>
              </tbody>
            </table>
            <p><a href="users.html">More...</a></p>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <div class="block-heading">
            <span class="block-icon pull-right">
                <a href="#" class="demo-cancel-click" rel="tooltip" title="Click to refresh"><i class="icon-refresh"></i></a>
            </span>

            <a href="#widget2container" data-toggle="collapse">Repository</a>
        </div>
        <div id="widget2container" class="block-body collapse in">
            <table class="table list">
              <tbody>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> TianshuoZhang</p>
                      </td>
                      <td>
                          <p>Repository: unusual events</p>
                      </td>
                      <td>
                          <p>Date: 5/24/2018</p>
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <p><i class="icon-user"></i> JiexinLi</p>
                      </td>
                      <td>
                          <p>Repository: lee</p>
                      </td>
                      <td>
                          <p>Date: 4/5/2018</p>
                      </td>
                  </tr>
              </tbody>
            </table>
        </div>
    </div>
</div>

 	
    <!-- ------------footer------------- -->
    <jsp:include page="/admin/footer.jsp"></jsp:include>
      
            </div>
        </div>
    </div>
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>
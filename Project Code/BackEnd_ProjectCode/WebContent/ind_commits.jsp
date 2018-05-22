<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Individual Commits</title>
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
        <div class="box-head"><h2>Commits</h2></div>
        <div class="box-content no-pad">
        <table class="display" id="dt3">
        <thead>
          <tr>
            <th>Time</th>
            <th>Repository</th>
            <th>Description</th>
            <th>Comment Number</th>
          </tr>
        </thead>
        <tbody>
       <%--  <c:forEach begin="0" end="100" var="commit"> items="${individual.commitsList}" var="commit"
	        <tr class="odd gradeX">
	            <td>2018-5-10</td>
	            <td>commit</td>
	            <td class="center">
	           <!--  需要返回 user_name 和 event_id, 用 user_name 和 event_id 传到 servlet 里  -->
	           <!-- 然后来判断这个用户是否对这个 event 已经点up or down -->
		            <a href="${pageContext.request.contextPath }/voteup">
		            		<img alt="" id="vote1" src="${pageContext.request.contextPath }/img/icons/basic/up.png"> 
		            </a>
		            &nbsp;&nbsp;&nbsp;
		            <a href="${pageContext.request.contextPath }/votedown">
		            		<img alt="" id="vote2" src="${pageContext.request.contextPath }/img/icons/basic/down.png">
		            </a>
	            </td>
	            <td class="center">
	            		<a href="#">view</a>
	            </td>
	          </tr>
        </c:forEach> --%>
        <c:forEach items="${commitsList }" var="commit">
        			<tr class="odd gradeX">
		            <td>${commit.commit_date }</td>
		            <td>${commit.repository_name }</td>
		            <td>
		            		<%-- <c:forEach items="${commitList }" var="commit"> --%>
		           			 <%-- <c:if test="${value.file_change !=0 }">
		            				${value.file_change } files changed.
		            			</c:if> --%>
		            			<c:choose>
		            				<c:when test="${commit.lines_added !=0 }">
		            					${commit.lines_added} lines of code added.
		            				</c:when>
		            				<c:otherwise>
		            					<c:choose>
		            						<c:when test="${commit.lines_deleted !=0 }">
		            							${commit.lines_deleted } lines of code deleted.
		            						</c:when>
		            						<c:otherwise>
		            							<c:choose>
		            								<c:when test="${commit.lines_modified !=0 }">
		            									${commit.lines_modified} lines of code modified.
		            								</c:when>
		            								<c:otherwise>
		            									<c:choose>
		            										<c:when test="${commit.file_change !=0 }">
		            											${commit.file_change } files changed.
		            										</c:when>
		            									</c:choose>
		            								</c:otherwise>
		            							</c:choose>
		            						</c:otherwise>
		            					</c:choose>
		            				</c:otherwise>
		            			</c:choose>
						<%-- <c:if test="${commit.lines_added !=0 }">
		            				${value.lines_added} lines of code added.
		            			</c:if>
		            			<c:if test="${commit.lines_deleted !=0 }">
		            				${value.lines_deleted } lines of code deleted.
		            			</c:if>
		            			<c:if test="${commit.lines_modified !=0 }">
		            				${value.lines_modified} lines of code modified.
		            			</c:if>
 		            		</c:forEach> --%>
		            </td>
		            <td>${commit.comment_number }</td>
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
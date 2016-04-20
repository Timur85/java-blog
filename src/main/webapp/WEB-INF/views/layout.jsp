<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<tiles:insertAttribute name="stylecss" />
</head>
<body> 

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
	
	<tilesx:useAttribute name="current"/>
	
		<div class="container">
		<!-- Static navbar -->
	   <nav class="navbar navbar-default navbar-static-top">
	     <div class="container">
	       <div class="navbar-header">
	         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	           <span class="sr-only">Toggle navigation</span>
	           <span class="icon-bar"></span>
	           <span class="icon-bar"></span>
	           <span class="icon-bar"></span>
	         </button>
	         <a class="navbar-brand" href="/tilesapp">Spring security</a>
	       </div>
	       <div id="navbar" class="navbar-collapse collapse">
	         <ul class="nav navbar-nav">
	           <li class="${current=='index' ? 'active' : ''}"><a href="/tilesapp">Home</a></li>
	           <security:authorize access="hasRole('ROLE_ADMIN')">
	           		<li class="${current=='users' ? 'active' : ''}"><a href="/tilesapp/users">Users</a></li>
	           </security:authorize>
	           <li class="${current=='register' ? 'active' : ''}"><a href="/tilesapp/register">Register</a></li>
	           <security:authorize access="! isAuthenticated()">
	           		<li class="${current=='login' ? 'active' : ''}"><a href="/tilesapp/login">Login</a></li>
	           </security:authorize>
	           <security:authorize access="isAuthenticated()">
	           		<li class="${current=='users' ? 'active' : ''}"><a href="/tilesapp/account">My account</a></li>
	           		<li><a href="/tilesapp/logout">Logout</a></li>
	           </security:authorize>
	         </ul>
	       </div><!--/.nav-collapse -->
	     </div>
	   </nav>
	
		<%-- <tiles:insertAttribute name="header" /> --%>
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
		<tiles:insertAttribute name="scriptjs" />
	</div>
</body>

</html>
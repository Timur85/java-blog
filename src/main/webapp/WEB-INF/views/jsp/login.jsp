<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<link rel="stylesheet" href="/tilesapp/resources/css/signin.css" crossorigin="anonymous">

	 <form class="form-signin" action="/tilesapp/login" method="post">
       <h2 class="form-signin-heading">Please sign in</h2>
       <label for="username" class="sr-only">Name</label>
       <input type="text" name="username" class="form-control" placeholder="Name" required autofocus>
       <label for="password" class="sr-only">Password</label>
       <input type="password" name="password" class="form-control" placeholder="Password" required>
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
     </form>
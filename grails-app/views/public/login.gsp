<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <%--<meta name="layout" content="main"> --%>
    <title>Login Here</title>
  </head>
  <body>
    <g:if test="${message}">
      <font color="green">${message}</font>
    </g:if>
    <g:if test="${flash.errorMessage}">
      <font color="red">${flash.errorMessage}</font>
    </g:if>


    <div class="form-area">
      <h2>Authenticate Urself</h2>
      <g:form name="loginForm" action="authenticate" controller="private">
        <p>
          <g:textField name="username" placeholder="Enter username"/>
        </p>
        <p>
          <g:passwordField name="password" placeholder="Enter password"/>
        </p>
        <p>
          <g:submitButton name="submit" value="Login" />
          <g:link action="register">Register</g:link>
        </p>
      </g:form>
      <i>Page Accessed at : ${currentTimestamp}</i>
    </div>
  </body>
</html>

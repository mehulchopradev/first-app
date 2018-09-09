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

    <div class="form-area">
      <h2>Authenticate Urself</h2>
      <form>
        <p>
          <input placeholder="Enter Username">
        </p>
        <p>
          <input type="password" placeholder="Enter Password">
        </p>
        <p>
          <input type="submit" value="Login">
          <g:link action="register">Register</g:link>
        </p>
      </form>
      <i>Page Accessed at : ${currentTimestamp}</i>
    </div>
  </body>
</html>

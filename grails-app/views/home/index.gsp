<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Welcome user</title>
  </head>
  <body>
    <div class="welcome">
      Welcome ${session.user.username}&nbsp;
      <g:link action="logout" controller="private">
        Logout
      </g:link>
    </div>
    <div class="menu-links">
      <g:link action="create" controller="account">
        Accounts
      </g:link>
    </div>
    <div class="container">
      This is ur home page
    </div>
  </body>
</html>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>All accounts</title>
  </head>
  <body>
    <g:if test="${flash.message}">
      <font color="green">${flash.message}</font>
    </g:if>

    <table border="1">
      <tr>
        <td>Account Name</td>
        <td>Account Balance</td>
      </tr>
      <g:each var="account" in="${accounts}">
        <tr>
          <td>
            <g:link action="edit" id="${account.id}">
              ${account.accName}
            </g:link>
          </td>
          <td>${account.balance}</td>
          <td>
            <g:link action="delete" id="${account.id}">
              Delete
            </g:link>
          </td>
        </tr>
      </g:each>
    </table>
  </body>
</html>

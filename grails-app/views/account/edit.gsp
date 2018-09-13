<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Edit an account</title>
  </head>
  <body>
    <g:renderErrors bean="${account}" as="list"/>
    <g:form name="accountForm" action="update" id="${account.id}">
      <p>
        <g:textField name="accName" placeholder="Account name please" value="${account.accName}"/>
      </p>
      <p>
        <g:textField name="balance" placeholder="Initial Balance" value="${account.balance}"/>
      </p>
      <p>
        <g:submitButton name="submit" value="Update" />
      </p>
    </g:form>
  </body>
</html>

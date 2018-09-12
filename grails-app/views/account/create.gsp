<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Create an account</title>
  </head>
  <body>
    <g:renderErrors bean="${account}" as="list"/>
    <g:form name="accountForm" action="save">
      <p>
        <g:textField name="accName" placeholder="Account name please" value="${account.accName}"/>
      </p>
      <p>
        <g:textField name="balance" placeholder="Initial Balance" value="${account.balance}"/>
      </p>
      <p>
        <g:submitButton name="submit" value="Save" />
      </p>
    </g:form>
  </body>
</html>

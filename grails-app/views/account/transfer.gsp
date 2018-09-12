<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <g:form action="initiateTransfer">
      <p>
        <g:textField name="from" placeholder="From Account Id"/>
      </p>
      <p>
        <g:textField name="to" placeholder="To Account Id"/>
      </p>
      <p>
        <g:textField name="transferAmount" placeholder="To Account Id"/>
      </p>
      <p>
        <g:submitButton name="submitbtn" value="Transfer"/>
      </p>
    </g:form>
  </body>
</html>

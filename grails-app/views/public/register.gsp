<!DOCTYPE html>
<html>
  <head>
    <%-- <meta name="layout" content="main">--%>
    <meta charset="utf-8">
    <title>Register Here</title>
  </head>
  <body>
    <div class="form-area">
      <g:renderErrors bean="${user}" as="list"/>
      <h2>Register Urself</h2>
      <g:uploadForm controller="private" action="register">
        <p>
          <g:textField name="username" placeholder="Enter Username" value="${user.username}" />
        </p>
        <p>
          <g:passwordField name="password" placeholder="Enter Password" />
        </p>
        <p>
          Country:
          <!--<select>
            <g:each var="country" in="${countries}">
              <option>${country}</option>
            </g:each>
          </select> -->
          <g:select name="country"
            from="${countries}"
            optionValue="fullName"
            optionKey="code"
            value="${user.country}"/>
        </p>
        <p>
          Gender:
          <g:radioGroup name="gender" labels="['Male','Female']" values="['m','f']" value="${user.gender}">
            ${it.radio}&nbsp;${it.label}
          </g:radioGroup>
        </p>
        <p>
          Profile Pic:
          <input type="file" name="profilePic">
        </p>
        <p>
          <g:submitButton name="submit" value="Register" />
        </p>
      </g:uploadForm>
    </div>
  </body>
</html>

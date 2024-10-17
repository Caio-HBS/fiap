<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Validation</title>
  </head>
  <body>
    <form action="exemplo" method="post">
      <fieldset>
        <legend>Validation</legend>
        <label for="user">Username</label>
        <input type="text" name="user" id="user">
        <hr />
        <label for="pass">Password</label>
        <input type="text" name="pass" id="pass">
      </fieldset>
      <input type="submit" value="Send">
    </form>
  </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fantastic Application, Yo</title>
    </head>

    <body>
        <h2>Create new participant, yo</h2>
        <form action="new" method="post">
            <label for="nameInput">Name:</label>
            <input type="text" placeholder="Enter your name here" name="nameInput" id="nameInput"/>
            <label for="emailInput">E-mail</label>
            <input type="email" placeholder="Enter your email here" name="emailInput" id="emailInput"/>
            <input type="submit" value="Submit"/>
        </form>
    </body>

</html>

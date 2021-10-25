<%-- 
    Document   : ShoppingList
    Created on : Oct 24, 2021, 8:22:31 PM
    Author     : jagan
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <p><a href="?action=logout">Logout</a></p>
        <form action="" method="POST">
            <h2>Add Item:<h2>
                    <input type="text" name="item"><input type="submit" value="Add Item">
                    <input type="hidden" name="action" value="add">
        </form>
        <form action="" method="post">
                       <ul>
                           <c:forEach items="${itemarray}" var="items">
                               <c:out value="<li> <input type='radio' value='${items}' name='itemToDelete'>
                                      <label for='itemToDelete'>${items}</label>
                                      </li>" escapeXml="false"> </c:out>    
                           </c:forEach>
                       </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
            
    </body>
</html>

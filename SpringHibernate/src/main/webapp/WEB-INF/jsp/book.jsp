<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 MVC Hibernate - Book CRUD</title>
    <style type="text/css">
        body {
            font-family: verdana;
            font-size: 12px;
            margin: 40px;
        }
        .bookTable, .bookTable td {
            border-collapse: collapse;
            border: 1px solid #aaa;
            margin: 2px;
            padding: 2px 2px 2px 10px;
            font-size: 12px;
        }
        .bookTable th {
            font-weight: bold;
            font-size: 12px;
            background-color: #5C82FF;
            color: white;
        }
        .bookLabel {
            font-family: verdana;
            font-size: 12px;
            font-weight: bold;
        }
        a, a:AFTER {
            color: blue;
        }
    </style>
    <script type="text/javascript">
    function deleteBook(bookId){
        if(confirm('Do you want to delete this Book ?')){
            var url = 'delete/'+bookId;
            window.location.href = url;
        }
    }
    </script>
</head>
<body>
 
<h2>Book Store </h2>
<p style="color:green;font-weight:bold;">
  To add a New Book please click <a href="<c:url value='/' />" >
    <img width="20px" height="30px" src="<c:url value='/images/insert.png' />" title="Add a New Book"/>
</a>
</p>
<c:url var="action" value="/book/add.html" ></c:url>
<form:form method="post" action="${action}" commandName="book" cssClass="bookForm">
    <table>
    <c:if test="${!empty book.bookName}">
    <tr>
        <td>
            <form:label path="id" cssClass="bookLabel">
                <spring:message code="label.bookId" />
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="bookName" cssClass="bookLabel">
                <spring:message code="label.bookName" />
            </form:label>
        </td>
        <td>
            <form:input path="bookName" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="author" cssClass="bookLabel">
                <spring:message code="label.author" />
            </form:label>
        </td>
        <td>
            <form:input path="author" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="price" cssClass="bookLabel">
                <spring:message code="label.price" />
            </form:label>
        </td>
        <td>
            <form:input path="price" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="quantity" cssClass="bookLabel">
                <spring:message code="label.qty" />
            </form:label>
        </td>
        <td>
            <form:input path="quantity" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty book.bookName}">
                <input type="submit"
                    value="<spring:message code="label.editbook"/>" />
            </c:if>
            <c:if test="${empty book.bookName}">
                <input type="submit"
                    value="<spring:message code="label.addbook"/>" />
            </c:if>
        </td>
    </tr>
</table>    
</form:form>
<h3>List of Books in Library</h3>
<c:if test="${!empty bookList}">
    <table class="bookTable">
    <tr>
        <th width="180">Book Name</th>
        <th width="160">Author Name</th>
        <th width="60">Price</th>
        <th width="80">Quantity</th>
        <th width="60">Action</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>
      <a href="<c:url value='/edit/${book.id}' />" >${book.bookName}</a>
      </td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>${book.quantity}</td>
            <td><img  width="30px" height="30px" src="<c:url value='/images/delete.png' />"
                title="Delete Book"
                onclick="javascript:deleteBook(${book.id})" />
 		        <a href="<c:url value='/edit/${book.id}' />"  >
                    <img  width="30px" height="25px" src="<c:url value='/images/insert.png' />" 
          title="Edit Book"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </table>
</c:if>
 
 
</body>
</html>
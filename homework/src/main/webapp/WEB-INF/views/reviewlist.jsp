<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table>




	<c:forEach items="${history}" var="eh" >

		<tr>

			<td>${eh.word}</td>


		</tr>

	</c:forEach>


</table>
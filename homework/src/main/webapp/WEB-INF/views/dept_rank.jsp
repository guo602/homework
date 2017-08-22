<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

 <table  class="table table-striped" border=5  >
          
      
          
          <tbody>
          
          
         
          <c:forEach items="${my_dept_list}" var="ep">       
           
                    <tr>
                   
                   
                    
				<td>${ep.getDept_name()}</td>
				 <td>${ep.getRound()}</td>
				
				<td>${ep.getRed_amount()}</td>
				</tr>
          </c:forEach>
          </tbody>
</table>
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <br>
 <table  class="table table-striped" border=3     >
          
                            
         
          
          <tbody>
          
          <tr><td>恭喜发财</td> 
          <td>红包轮次</td>
          <td>红包金额</td>
          </tr>
          <c:forEach items="${maopaoshow}" var="ep">                
                    <tr>
                    <td>${ep.getIndex()}</td>
                   
                    
					<td>${ep.getRound()}</td>
					
					<td>${ep.getRed_amount()}</td>
					</tr>
          </c:forEach>
          </tbody>
     </table>
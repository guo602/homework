<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <table  border=1>
          <tbody>
          <c:forEach items="${pro}" var="ep">
                                
                <tr>

					<td>${ep.getPro_name()}</td>
					<td>${ep.getPerformer()}</td>
					<td>${ep.getDept()}</td>
					
					
					 
						</form>
					</tr>

          </c:forEach>
          </tbody>
     </table>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <table  border=1>
          <thead>
          <th>
                              红包轮次
          </th>
          <th>
                              红包金额
          </th>
          </thead>
          <tbody>
          <c:forEach items="${lucky_record}" var="ep">                
                    <tr>
					<td>${ep.getRound()}</td>
					<td>${ep.getLucky_money()}</td>
					</tr>
          </c:forEach>
          </tbody>
     </table>
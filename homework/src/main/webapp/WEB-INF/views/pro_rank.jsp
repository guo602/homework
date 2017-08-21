 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

			
	<c:forEach items="${program}" var="ep" >
				<!-- <div style="display:flex; flex-direction:row;"> -->
				<div style="margin: 7px 0 30px 0;border-top: 1px solid #ddd;">
							<div style="display:flex; flex-direction:row;">
								
								<div style="width:20em"><b>${ep.getPro_name()}</b>
								</div>

								<div><button id="dsbtn${ep.getPro_name()}" class="btn btn-danger btn-xs" value="${ep.getPro_name()}" onclick="changepro_name('${ep.getPro_name()}')">打赏
								</div>

							</div>

							<div style="display:flex; flex-direction:row;">

									<div style="width:7em">${ep.getDept_name()}</div>
									<div style="width:10em">${ep.getAct_name()}</div>
									<div style="width:11em">被赏:${ep.getRed_amount()}</div>

							</div>


				</div>
	
	</c:forEach>
			


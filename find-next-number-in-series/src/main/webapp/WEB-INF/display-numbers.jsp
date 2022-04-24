<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Resultant Number Series</title>

<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/css/style.css" />
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>SERIES - NEXT NUMBER in the Series</h2>
		</div>
	</div>
	<div id="container">
	<form:form action="displayNumbers" modelAttribute="sixnums" method="POST">
		<form:input type="hidden" id="input1" path="num1" style="width: 101px;"  value = "${num1}"/>
		<form:input type="hidden" id="input2" path="num2" style="width: 101px;"  value = "${num2}"/>
		<form:input type="hidden" id="input3" path="num3" style="width: 101px;"  value = "${num3}"/>
		<form:input type="hidden" id="input4" path="num4" style="width: 101px;"  value = "${num4}"/>
		<form:input type="hidden" id="input5" path="num5" style="width: 101px;"  value = "${num5}"/>
		<form:input type="hidden" id="input6" path="num6" style="width: 101px;"  value = "${num6}"/>
		<input type="hidden" id="nextnum" style="width: 101px;"  value = "${nextnum}"/>
		<input type="hidden" id="nextnum" style="width: 101px;"  value = "${option}"/>	
		
	
	<c:if test="${nextnum != 99999.0}">
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Number 1</th>
					<th>Number 2</th>
					<th>Number 3</th>
					<th>Number 4</th>
					<th>Number 5</th>
					<th>Number 6</th>
					<th>NextNumber</th>
					<c:if test="${(option=='NextTwoTerms')}">
					<th>NextNumber</th>
					<th>NextNumber</th>
					</c:if>
				</tr>		
					<tr>
						<td> ${num1} </td>
						<td> ${num2} </td>
						<td> ${num3} </td>
						<td> ${num4} </td>
						<td> ${num5} </td>
						<td> ${num6} </td>
						<td> ${nextnum} </td>
						<c:if test="${(option=='NextTwoTerms')}">
						<td> ${nextnum} </td>
						<td> ${nextnum} </td>
						</c:if>
					</tr>			
			</table>
		</div>
	</div>
	<p>
	
	
	
	
	
	</p>
		
		
	<select name="moreInfo">
	<option>NameOfSeries</option>
	<option>NextTwoTerms</option>
	<option>LogicalFlow</option>
	</select>
	<input type="submit"  value="Get Info" />
	
    <c:if test="${(option=='NameOfSeries')}">
	<p>${seriesname}</p>
	</c:if>
	
	<c:if test="${(option=='LogicalFlow')}">
	<p>${logicalformula}</p>
	</c:if>
		
	</c:if>
	</form:form>
	</div>
	<c:if test="${nextnum == 99999.0}">
	<p>
	Either this given number series logic is not implemented or the given series numbers are logically incorrect
	</p>
	</c:if>
	<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/number/showFormForEnteringIntegers">Back to next series Inputs</a>
		</p>
</body>

</html>

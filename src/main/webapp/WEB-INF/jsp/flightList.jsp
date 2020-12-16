<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matching Flights</title>
<style>
fieldset{
	border-radius:4px ;
}
div{
	width: 400px;
    margin-left:calc(50% - 200px) ;
	margin-bottom:30px ;
}
form input{
	float:right ;
	margin-right:20px ;
	border:0.5px solid black ;
}
table{
	width:60% ;
	margin:auto ;
}
table,tr,td,th{
border: 1px solid black ;
border-collapse:collapse ;
text-align :center ;
}
p{
	/* margin:10px 20px 0px 0px; */
	font-size: small;
	float:right ;
	color:red ;
}
</style>
</head>
<body>


<table>
<tr>
<th>S.no.</th>
<th>flight No. </th>
<th>Valid till</th>
<th>Departure Time</th>
<th>Duration</th>
<th>fare</th>
</tr>

<c:forEach  var="listValue" items="${list}"  varStatus="status">
<tr>

<td>  ${listValue.flight_no} </td>
<td> <fmt:formatDate value="${listValue.valid_till}" type="date" dateStyle="long" /> </td>
<td>  ${listValue.flight_time} </td>
<td>  ${listValue.flight_dur} </td>
<td>  ${listValue.fare} </td>
</tr>
</c:forEach>

</table>

</body>
</html>
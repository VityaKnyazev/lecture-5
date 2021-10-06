<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make a decision on your new car</title>
</head>
<body>

	<c:if test="${car != null}">
		<h1>Vehicle representation</h1>
		<p>
			<b>Today we're showing:</b>
		</p>

		<p>
			A new car: <span style="color: red">${car.firm}</span> <span
				style="color: lime;">${car.model}</span>, car sirial number: <span
				style="color: silver;">${car.serialNumber}</span>
		</p>
	</c:if>

	<c:if test="${cars != null}">
		<h1>Vehicles representation</h1>
		<p>
			<b>Today we're showing:</b>
		</p>

		<c:forEach var="car" items="${cars}">
			<p>
				A new car: <span style="color: red">${car.firm}</span> <span
					style="color: lime;">${car.model}</span>, car sirial number: <span
					style="color: silver;">${car.serialNumber}</span>
			</p>
		</c:forEach>
	</c:if>

	<c:if test="${id != null}">
		<h1>
			<i>Bad request</i>
		</h1>
	</c:if>

	<c:if test="${post != null && post.equals('success')}">
		<p>Ваш автомобиль успешно добавлен!</p>
		<a href="represent">Вернуться к презентации новых автомобилей</a>		
	</c:if>

	<c:if test="${post != null && post.equals('failed')}">
		<h1>
			<i>Bad request</i>
		</h1>
		<p>Ваш автомобиль не добавлен!</p>
		<a href="represent">Вернуться к презентации новых автомобилей</a>
	</c:if>
	
	
	<p>Добавить новый автомобиль в презентацию: </p>
	<form action="represent" method="POST">
		<p>
			<label>Производитель автомобиля: <input type="text"
				name="firm" /></label>
		</p>
		<p>
			<label>Модель автомобиля: <input type="text" name="model" /></label>
		</p>
		<p>
			<label>Номер автомобиля в серии: <input type="text"
				name="serialNumber" /></label>
		</p>

		<input type="submit" value="Добавить">
	</form>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>

<body>
	<h1>This is the body of the sample view</h1>
</body>
		<h2>
			<c:if test="${not empty message}"><div class="message green">${message}</div></c:if>
		</h2>
</html>
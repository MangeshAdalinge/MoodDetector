<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<header>
	<h1 class="w100 text-center">
		<a href="index.html">Mood Video Recommender</a>
	</h1>
	</header>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<form action="#">

				<p >
					<label>Your mood is <%=session.getAttribute("mood")%>. Have a look at the below videos and Ctrl + F5 your mood</label>
					<input type="text" id="search" disabled="disabled"
						value=<%=session.getAttribute("mood")%>
						class="form-control" />
				</p>
				<p class="submit">
					<input type="submit" value="Search"
						class="form-control btn btn-primary w10">
				</p>
			</form>
			<div id="results"></div>


		</div>
	</div>

	<!-- scripts -->
	<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
	<script src="utube1.js"></script>
	<script src="https://apis.google.com/js/client.js?onload=init"></script>

</body>
</html>
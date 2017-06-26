<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Filmit - Movie Social Network</title>
		<meta charset="UTF-8">
		<meta name="description" content="Filmit - Movie Social Network">
		<meta name="keywords" content="Movies, Actors, Films">
		<meta name="author" content="Anna Bagés Casas, Brayan Alberto CastaÃ±eda Aquise, Gabriel Arroyo Hinojosa">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
		<script src="https://use.fontawesome.com/2e3f3cb1c9.js"></script>
		<link rel="stylesheet" href="css/bulma.css">
		<link rel="stylesheet" href="css/style.css">
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#navigation').load('NavController');
				
				$('#content').load('ContentMainController', {controller: ""});
				
				$("#logo").click(function(event) {
					$('#content').load('ContentMainController', {controller: ""});
				});
			});
		</script>
	</head>
	<body>
		<section class="page is-fullheight">
			<div class="header">
				<nav id="navigationHeader" class="nav">
					<div class="nav-left">
						<a id="logo" class="nav-item">
							<img src="css/images/filmitLogo.png" alt="Filmit Logo">
						</a>
					</div>
					<div id="navigation" class="nav-right"></div>
				</nav>
			</div>
			
			<div id="content" class="contentLayout"></div>
		</section>
	</body>
</html>
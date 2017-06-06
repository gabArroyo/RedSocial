<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>

<html>

<head>
	<title>Filmit - Movie Social Network</title>
	<meta charset="UTF-8">
	<meta name="description" content="Filmit - Movie Social Network">
	<meta name="keywords" content="Movies, Actors, Films">
	<meta name="author" content="Anna BagÃ©s Casas, Brayan Alberto CastaÃ±eda Aquise, Gabriel Arroyo Hinojosa">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"> </script>
	<link rel="stylesheet" href="css/bulma.css">
  <link rel="stylesheet" href="css/style.css">
  <script type="text/javascript">
	$(document).ready(function() {
		$('#navigation').load('NavController');
		$('#content').load('ContentMainController', {controller: "UserHome"});
		});
	</script>
</head>
<body>
  <section class="page is-fullheight">
    <div class="header">
      <nav id="navigationHeader" class="nav is-mobile">
        <div id="logo" class="nav-left">
          <a class="nav-item">
            <img src="css/images/filmitLogo.png" alt="Bulma logo">
          </a>
        </div>
        <div id="navigation" class="nav-right nav-menu">
        </div>
      </nav>
    </div>
    <div id="content" class="contentLayout">
    </div>
  </section>
</body>
</html>

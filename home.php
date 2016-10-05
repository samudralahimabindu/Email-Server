
<?php
	session_start();
	$name=$_SESSION['username'];
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<style>
	.container-fluid
	{
		height: 100%;
	}
  }
	</style>
</head>

<body>
<div class="container-fluid">
	<h1 align="center">E-MAIL SERVER</h1>
	<div align="right"><a href="profile.php" target="content"><?php echo file_get_contents("data/$name/profile/name"); ?></a>&nbsp <a href="logout.php">Log out</a></div>
</div>
<nav class="navbar navbar-inverse">
<div class="container">
<ul class="nav navbar-nav" >
<li><a href="inbox.php" target="content">Home</a></li>
<li><a href="inbox.php" target="content">Inbox</a></li>
<li><a href="sent.php" target="content">Sent</a></li>
<li><a href="draft.php" target="content">Draft</a></li>
<li><a href="compose.php" target="content">Compose</a></li>
</ul>
</div>
</nav>
<div class="container-fluid">
<br>
	
	<div class="embed-responsive embed-responsive-4by3">
		<iframe class="embed-responsive-item" src="inbox.php" name="content" width="50%"></iframe>
	</div>
	</div>
</div>
</body>

</html>


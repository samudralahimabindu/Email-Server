<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form method="post"><br>
<div class="form-group">
<label for="email">Email:</label>
      <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
<div>
<div class="form-group">
<label for="pwd">Password:</label>
      <input type="password" class="form-control" name="pwd" id="email" placeholder="Enter Password">
</div>
<div>
<input type="submit" class="btn btn-default" value="Sign in" name="login">
</div>
</form>
</div>
</body>
</html>

<?php
	if(isset($_POST['login']))
	{
		if(!empty($_POST['email']))
		{
			$name=$_POST['email'];
			if(!empty($_POST['pwd']))
			{
				$pwd=$_POST['pwd'];
				if(file_exists("data/$name"))
				{
					$p=file_get_contents("data/$name/profile/pwd");
					if($p==$pwd)
					{
						session_start();
						$_SESSION['username']=$name;
?>
	<script type="text/javascript">
		window.open("home.php","_parent");
	</script>
<?php
					}
					else
						echo "Invalid user name or password";
				}
				else
						echo "Invalid user name or password";
			}
			else
				echo "<script type='text/javascript'>alert('Enter Password');</script>";
		}
		else
			echo "<script type='text/javascript'>alert('Enter username');</script>";
	}
?>

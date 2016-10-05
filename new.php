<?php
	$nameErr=$emailErr=$pwdErr=$phnoErr="";
	if(isset($_POST['register']))
	{
		$name=$_POST['name'];
		$email=$_POST['email'];
		$pwd=$_POST['pwd'];
		$phno=$_POST['phno'];
		if(empty($name))
			$nameErr="Name Required";
		if(empty($email))
			$emailErr="Email Required";
		if(empty($pwd))
			$pwdErr="Password Required";
		if(empty($phno))
			$phnoErr="Phone Number Required";
		if(!empty($name) && !empty($email) && !empty($pwd) && !empty($phno))
		{
			if(file_exists("data/$email"))
			{
				$err="<h3>User already exists</h3>";
				if(file_exists("data/$email")==1)
					echo "User already exists";
			}
			else
			{
				mkdir("data/$email");
				mkdir("data/$email/inbox");
				mkdir("data/$email/sent");
				mkdir("data/$email/draft");
				mkdir("data/$email/profile");
				$f=fopen("data/$email/profile/pwd","w");
				fwrite($f,$pwd);
				$f=fopen("data/$email/profile/name","w");
				fwrite($f,$name);
				$f=fopen("data/$email/profile/email","w");
				fwrite($f,$email);
				$f=fopen("data/$email/profile/phno","w");
				fwrite($f,$phno);
				echo "You are successfully registered!Go back and login";
			}
		}
	}
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>
</head>
<h1 align="center">E-MAIL SERVER</h1>
<body align="center">
<div class="container">
<h3>New User</h3>
<form method="post">
<div class="form-group">
<div class="col-sm-offset-3 col-sm-2"><label> Name:</label></div>
<div class="col-sm-offset-3 col-sm-6"><input type="text" class="form-control" name="name" placeholder="Enter Name"></div><div class="col-sm-3" align="left" style="color:#FF0000;"><?php echo $nameErr;?></div>
</div>
<div class="form-group">
<div class="col-sm-offset-3 col-sm-2"><label>E-mail:</label></div>
<div class="col-sm-offset-3 col-sm-6"><input type="email" class="form-control" id="email" name="email" placeholder="Enter Email"></div><div class="col-sm-3" align="left" style="color:#FF0000;"><?php echo $emailErr;?></div>
</div>
<div class="form-group">
<div class="col-sm-offset-3 col-sm-2"><label>Password:</label></div>
<div class="col-sm-offset-3 col-sm-6"><input type="password" class="form-control" id="email" name="pwd" placeholder="Enter Password"></div><div class="col-sm-3" align="left" style="color:#FF0000;"><?php echo $pwdErr;?></div>
</div>
<div class="form-group">
<div class="col-sm-offset-3 col-sm-2"><label>Phone No:</label></div>
<div class="col-sm-offset-3 col-sm-6"><input type="text" class="form-control" id="email" name="phno" placeholder="Enter Phone No"></div><div class="col-sm-3" align="left" style="color:#FF0000;"><?php echo $phnoErr;?></div>
</div>
<div class="form-group">
<div class="col-sm-offset-3 col-sm-2"><label></label></div>
<div class="col-sm-8"><input type="submit" class="btn btn-info" name="register" value="Register"></div>
</div>

</form>
<div>
</body>
</html>



<?php
session_start();
$name=$_SESSION['username'];
if(isset($_POST['confirm']))
{
	$op=$_POST['op'];
	$np=$_POST['np'];
	$cp=$_POST['cp'];
	$pwd=file_get_contents("data/$name/profile/pwd");
	if($pwd!=$op)
	{
		echo "Enter your old password correctly";
	}
	else
	{
		if($cp!=$np)
		{
			echo "New Password doesn't match the Confirm Password";
		}
		else
		{
			file_put_contents("data/$name/profile/pwd",$np);
			echo 'Password Changed Successfully';
		}
	}
}

?>
<html>
<body align="center">
<form method="post">
<table align="center">
<tr><td>Old Password:</td><td><input type="password" name="op"></td></tr>
<tr><td>New Password:</td><td><input type="password" name="np"></td></tr>
<tr><td>Confirm Password:</td><td><input type="password" name="cp"></td></tr>
<tr><td></td><td><input type="submit" value="Confirm" name="confirm"></td></tr>
</table>
</form>
</body>
</html>
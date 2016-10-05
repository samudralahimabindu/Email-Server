<?php
session_start();
$name=$_SESSION['username'];
if(isset($_POST['save']))
{
	$n=$_POST['n'];
	$ph=$_POST['ph'];
	file_put_contents("data/$name/profile/name",$n);
	file_put_contents("data/$name/profile/phno",$ph);
	echo "Profile edited successfully";
}
?>
<html>
<body>
<form method="post">
<table align="center">
<tr>
<td>Name:</td><td><input type="text" value="<?php echo file_get_contents("data/$name/profile/name");?>" name="n"></td>
</tr>
<tr>
<td>Phone No:</td><td><input type="text" value="<?php echo file_get_contents("data/$name/profile/phno"); ?>" name="ph"></td>
</tr>
<tr>
<td></td><td><input type="submit" value="Save" name="save"></td>
</tr>
</table>
</form>
</body>
</html>
<?php
session_start();
$name=$_SESSION['username'];
echo '<body align="center"><h3>MY PROFILE</h3><table align="center">';
echo '<tr><td>Name:</td><td>'.file_get_contents("data/$name/profile/name").'</td><td></td></tr>';
echo '<tr><td>Password:</td><td>'.file_get_contents("data/$name/profile/pwd").'</td><td><a href="change_pwd.php">Change Password</a></td></tr>';
echo '<tr><td>Phone No:</td><td>'.file_get_contents("data/$name/profile/phno").'</td><td></td></tr></table>';
?>
<html>
<body>
<form method="post" action="edit.php">
<input type="submit" value="Edit Profile" name="edit">
</form>
</body>
</html>
<?php
echo '</body>'
?>

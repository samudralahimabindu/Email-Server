<?php
session_start();
$name=$_SESSION['username'];
$in=$_SESSION['in'];
$fname=$_GET['name'];
echo "<h3>".file_get_contents("data/$name/$in/$fname/sub").'</h3><hr>';
echo "<b>".$name."</b><br>";
if($in=="inbox")
	echo file_get_contents("data/$name/$in/$fname/from")."<br>to me<br>";
else
	echo "to:".file_get_contents("data/$name/$in/$fname/to")."<br>";
echo file_get_contents("data/$name/$in/$fname/msg");
?>
<html>
<body bgcolor="white">
</body>
</html>
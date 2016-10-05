<?php
session_start();
$name=$_SESSION['username'];
session_unset();
session_destroy();
include ('index.php');

?>
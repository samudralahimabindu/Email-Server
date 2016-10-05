<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>
<div class="container-fluid">
<form method="post">
<div class="form-group">
<div class="col-sm-2" align="right"><label> To</label></div>
<div class="col-sm-10"><input type="text" class="form-control" name="to"></div>
</div>
<br><br>
<div class="form-group">
<div class="col-sm-2" align="right"><label> Subject</label></div>
<div class="col-sm-10"><input type="text" class="form-control" name="sub"></div>
</div><br><br>
<div class="form-group">
<div class="col-sm-2" align="right"><label> Message</label></div>
<div class="col-sm-10"><textarea name="msg" cols="110" rows="15" class="form-control"></textarea></div>
</div><br><br>
<div class="form-group">
<div class="col-sm-offset-3 col-sm-2"><label></label></div>
<div class="col-sm-1"><button type="submit" class="btn btn-primary"  value="send" name="send">Send</button></div>
<div class="col-sm-1"><button type="submit" class="btn btn-primary"  value="save" name="save">Save</button></div>
</div>
</form>
</div>
</body>
</html>

<?php
session_start();
$name=$_SESSION['username'];
if(isset($_POST['send']))
{
	$to=$_POST['to'];
	$sub=$_POST['sub'];
	$msg=$_POST['msg'];
	
	if($to=="")
		echo "enter recipient address";
	else
	{
		if(file_exists("data/$to")==1)
		{
			//reciever
			$date=date("Y-m-d");
			$tym=date("h_i_sa");
			$f_name=$date."--".$tym;
			$fname="data/$to/inbox/$f_name";
			mkdir("$fname");
			$f1=fopen("$fname/date","w");
			fwrite($f1,$date);
			$f2=fopen("$fname/tym","w");
			fwrite($f2,$tym);
			if($sub=="")
			{
				$sub=$sub."(no Subject)";
			}
			$f3=fopen("$fname/sub","w");
			fwrite($f3,$sub);
			$f4=fopen("$fname/msg","w");
			fwrite($f4,$msg);
			$f5=fopen("$fname/from","w");
			fwrite($f5,$name);
			
			//sender
			$fname="data/$name/sent/$f_name";
			mkdir("$fname");
			$f1=fopen("$fname/date","w");
			fwrite($f1,$date);
			$f2=fopen("$fname/tym","w");
			fwrite($f2,$tym);
			if($sub=="")
			{
				$sub=$sub."(no Subject)";
			}
			$f3=fopen("$fname/sub","w");
			fwrite($f3,$sub);
			$f4=fopen("$fname/msg","w");
			fwrite($f4,$msg);
			$f5=fopen("$fname/to","w");
			fwrite($f5,$to);
			//fclose($f);
			echo "Message sent successfully";
		}
		else
		{
			echo "User does not exist";
		}
	}
}
if(isset($_POST['save']))
{
	$to=$_POST['to'];
	$sub=$_POST['sub'];
	$msg=$_POST['msg'];
	$sub=$sub."--".$to;
	$date=date("Y-m-d");
	$tym=date("h_i_sa");
	$f_name=$date."--".$tym;
	$fname="data/$name/draft/$f_name";
	mkdir("$fname");
	$f1=fopen("$fname/date","w");
	fwrite($f1,$date);
	$f2=fopen("$fname/tym","w");
	fwrite($f2,$tym);
	$f3=fopen("$fname/sub","w");
	if($sub=="")
				$sub=$sub."(no Subject)";
	fwrite($f3,$sub);
	$f4=fopen("$fname/msg","w");
	fwrite($f4,$msg);
	$f5=fopen("$fname/to","w");
	fwrite($f5,$to);
	echo "message saved to drafts";
}
?>
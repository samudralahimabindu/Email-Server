<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function($) {
		$(".table-row").click(function() {
        window.document.location = $(this).data("href");
		});
		});
		
	</script>
	<style>
  .affix {
      top: 0;
      width: 100%;
  }

  .affix + .container-fluid {
      padding-top: 70px;
  }
  </style>
</head>
<body>
<br><br>
<?php
	session_start();
	$name=$_SESSION['username'];
	$f=opendir("data/$name/draft");
	while(($file=readdir($f))!=false)
	{
		if($file!="." && $file!="..")
		{
			$_SESSION['in']="draft";
?>
<div class="container-fluid">
	<form method="post">
	<table width="100%" align="center"class="table table-hover table-condensed" style="table-layout:fixed;" cellpadding="0">
	<tr style="height:10px;" class="table-row" data-href="display.php?name=<?php echo $file;?>" onmouseover="" style="cursor: pointer;">
		<td width="5%%"><input type='checkbox' name='i[]' value='<?php echo $file ;?>' onchange="this.form.submit()"  <?php if(isset($_POST['i'])){$check=$_POST['i'];	foreach($check as $v){if($v==$file){ ?>checked="checked" <?php }}}?>></td>
	<td width="20%" onmouseover="" style="cursor: pointer;">To: <?php echo file_get_contents("data/$name/draft/$file/to");?></td>
	<td width="55%" onmouseover="" style="cursor: pointer;"><?php echo "<b>".file_get_contents("data/$name/draft/$file/sub")."</b>"."-".file_get_contents("data/$name/draft/$file/msg");?></td>
	<td width="10%" onmouseover="" style="cursor: pointer;"><?php echo file_get_contents("data/$name/draft/$file/tym");?></td>
	<td width="10%" onmouseover="" style="cursor: pointer;"><?php echo file_get_contents("data/$name/draft/$file/date");?></td>
	</tr>
	</table>

</div>
<?php
		}
	}
?>
	
<?php
	if(isset($_POST['i']))
	{	
?>
	<div class="container">
		<button type="submit" class="btn btn-danger" name="del" style="position: fixed; top: 0; left: 20; border: 0;">Delete</button>

    </div>
  </form>
</body>
</html>
<?php
		if(isset($_POST['del']))
		{
			$check=$_POST['i'];	
			foreach($check as $v)
			{
				$f=opendir("data/$name/draft/$v");
				while(($file=readdir($f))!=false)
				{
					if($file!="." && $file!=".." && $file!=$v)
					{
						unlink("data/$name/draft/$v/$file");
					}
				}
				rmdir("data/$name/draft/$v");
			}
			echo "<meta http-equiv='refresh' content='0'>";
		}
	}
?>
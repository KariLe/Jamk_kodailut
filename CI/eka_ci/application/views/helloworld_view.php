<!--The View-->
<html>
	<head>
		<title><?php echo $page_title; ?></title>
	</head>
	<body>
		<?php foreach($result as $row):?>
		<h3><?php echo $row->title; ?></h3>
		<p><?php echo $row->text; ?></p>
		<br />
		<?php endforeach;?>
		<p><?php echo $calendar?></p>
		<br>
		<script src="<?php echo base_url();?>assets/script.js"></script>
		<link rel="stylesheet" href="<?php echo base_url();?>assets/style.css" />
		<a href="<?php echo $there; ?>">To Another page</a>
		
	</body>
</html>
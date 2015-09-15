<!--The View-->
<html>
	<head>
		<title><?php echo $page_title; ?></title>
                
	</head>
	<body>
                <div class="json_data">
		<?php foreach($result as $row):?>
		<h3><?php echo $row->title; ?></h3>
		<p><?php echo $row->text; ?></p>
		<br />
		<?php endforeach;?>
                </div>
	</body>
</html>
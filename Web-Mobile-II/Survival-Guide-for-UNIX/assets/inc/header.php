<?php
	include '/home/iste240t95/repos/.dbConn.php';
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>1GG - <?php echo $page ?></title>
	<link rel="stylesheet" type="text/css" href="<?php echo $path; ?>assets/css/styles.css">
	<link rel="stylesheet" type="text/css" href="
		<?php 
			if ( $page == "Home" ){
				echo $path.'assets/css/index.css';
			} else if ( $page == "Quizzes"){
				echo $path.'assets/css/pages.css';
			} else if ( $page == "Sections"){
				echo $path.'assets/css/sections.css';
			}
		?>
	">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<link href='https://fonts.googleapis.com/css?family=Overpass+Mono' rel='stylesheet'>
	<script src="<?php echo $path; ?>assets/scripts/menuButton.js"></script>
</head>
<body>
    <!-- Header/Nav Container -->
	<header class="header-container">
		<img src="<?php echo $path; ?>assets/images/1GG-hand_filled_27x60.png" alt="One Group Global logo">
		<!-- Upper left logo -->
		<h2 class="nomobile">1GroupGlobal</h2>
		<h2 class="nodesktop">1GG</h2>

		<!-- Menu icon for navigation -->
		<a class="menu-icon" onclick="navDropdown()">
			<i class="fa fa-bars" aria-hidden="true"></i>
		</a>
	</header>

	<?php include 'nav.php'; ?>

<?php
//connect to db
include "../../../dbCon.php";
	if ($mysqli){
		if(!empty($_GET['formName']) && !empty($_GET['formComment'])){
			//prep
			$stmt = $mysqli->prepare("insert into comments (name,comment,last_modified) values (?, ?, NOW())");
			//bind
			$stmt->bind_param("ss",$_GET['formName'],$_GET['formComment']);
			//exec
			$stmt->execute();
			//close
			$stmt->close();
		}
		$result=$mysqli->query('select * from comments');
		if($result){
            $records = [];
			while($rowHolder = $result->fetch_assoc()){
				$records[] = $rowHolder;
			}
		}
	}
 
?>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>PHP - Part 2 - Forms</title>
	</head>
	<body>
		<h3>What do you think?</h3>
		<div id="list">
			<ul>
			<?php
				foreach($records as $this_row){
					echo '<li>'.$this_row['name'].": ".$this_row['comment']." @ ".$this_row['last_modified'].'</li>';
				}
			?>
			</ul>
		</div>
		<hr/>
		<h3>What do you have to say?</h3>
		<form action="EX07.php" method="get">		
			First name: <input type="text" id="name" name="formName" />
            <br/>
			<input type="text" id="comment" name="formComment" placeholder="say what?"/>
            <br/>
			<input type="submit" value="Add to the List"/>
		</form>
	</body>
</html>
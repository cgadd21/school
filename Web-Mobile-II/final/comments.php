<?php
    //connect to db
    include "../../../dbCon.php";
	if ($mysqli){
		if(!empty($_GET['formName']) && !empty($_GET['formComment'])){
			//prep
			$stmt = $mysqli->prepare("insert into finalComments (name,comment) values (?, ?)");
			//bind
			$stmt->bind_param("ss",$_GET['formName'],$_GET['formComment']);
			//exec
			$stmt->execute();
			//close
			$stmt->close();
		}
		$result=$mysqli->query('select * from finalComments');
		if($result){
            $records = [];
			while($rowHolder = $result->fetch_assoc()){
				$records[] = $rowHolder;
			}
		}
	}
?>

<?php $currentPage = "Comments"; ?>

<!DOCTYPE html>
<html lang="en">

<?php include('assets/inc/head.php'); ?>

<body>

    <div class="stick">

        <?php include('assets/inc/header.php'); ?>
        
        <?php include('assets/inc/mainMenu.php'); ?>

    </div>

    <div id="message" style="display:none;left:5px;">Invalid Comment 🥲</div>

    <div class="container">
        <div id="list">
            <ul>
            <?php
                foreach($records as $this_row){
                    echo '<li>'.$this_row['name'].": ".$this_row['comment'].'</li>';
                }
            ?>
            </ul>
        </div>
        <form action="comments.php" method="get" onsubmit="return validate();">
        <fieldset>
        <legend>Post your comment:</legend>
            <input type="text" id="name" name="formName" placeholder="First Name" />
            <span id="name*" style="color:red;display:none;">*</span><br/>
            <br/>
            <input type="text" id="comment" name="formComment" placeholder="Comment"/>
            <span id="comment*" style="color:red;display:none;">*</span><br/>
            <br/>
            <input type="submit" name="submit" value="Post"/>
        </fieldset>
        </form>

    </div>

    <?php 
    
        function sanitize($str, $length=50){
            $str = trim($str);
            $str = htmlentities($str, ENT_QUOTES);
            return substr($str,0,$length);
        }

        if(!empty($_POST['submit'])){
            sanitize($_POST['name']);
            sanitize($_POST['comment']);
        }

    ?>

<script>

    var ret;
    var moving;

    function validate(){

        ret = true;

        if(document.getElementById('name').value==''){
            document.getElementById('name*').style.display='inline';
            ret=false;
        }else{
            document.getElementById('name*').style.display='none';
        }
        
        if(document.getElementById('comment').value==''){
            document.getElementById('comment*').style.display='inline';
            ret=false;
        }else{
            document.getElementById('comment*').style.display='none';
        }

        //display the message if invalid submission
        if (!ret){
            message();
        }

        return ret;

    }

    function message(){
        document.getElementById('message').style.display = 'block';
        if (parseInt(document.getElementById('message').style.left) < 1800){
            document.getElementById('message').style.left = parseInt(document.getElementById('message').style.left) + 1 + 'px';
            moving = setTimeout(function(){message();},1);
        }else{
            //reset the message position
            document.getElementById('message').style.display = 'none';
            document.getElementById('message').style.left = '5px';
            window.clearTimeout(moving);
        }
    }

</script>

    <?php include('assets/inc/scripts.php'); ?>

</body>
</html>
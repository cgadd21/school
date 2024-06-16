<?php
	/**
        * 1GG, ISTE-240, 2228
        * Final Project 
        * 
        * @author Cooper Gadd <ctg7866@rit.edu>
        * @author Joe Schultz <jxscad@rit.edu>
        * @author Blerta Kapllani <bk3017@rit.edu>
        * @author Yanzhi Wang <yw4595@rit.edu>
        *
        *	
	*/

	include '/home/iste240t95/repos/.dbConn.php';
	

    // Create database connection
    // Variables from include file in assets/inc/header.php
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // Page variables
    if(isset($_GET['subsectionID'])){
        $sql_verify_subsection = "SELECT * FROM Subsections WHERE subsection_id='".$_GET['subsectionID']."'";
        $result = $conn->query($sql_verify_subsection);
        if($result->num_rows > 0){
            $subsection_id = $_GET['subsectionID'];
        } else {
            header('Location: sections.php');
        }
    } else {
        header('Location: sections.php');
    }

    $sql_subsection = "SELECT * FROM Subsections WHERE subsection_id='".$subsection_id."'";
    $result = $conn->query($sql_subsection);
    if($result->num_rows > 0){
        while($subsections_data = $result->fetch_assoc()){
            $subsection_title = $subsections_data['subsection_title'];
            $topic_title = 'Introduction';
            $topic_text = $subsections_data['subsection_introduction'];
        }
    }

    if(isset($_GET['topicID'])){
        $topic_id = $_GET['topicID'];
        if($topic_id != 'introduction'){
            $sql_verify_topic = "SELECT * FROM Topics WHERE topic_id = '$topic_id' AND subsection_id = '$subsection_id'";
            $topic_result = $conn->query($sql_verify_topic);
            if($topic_result->num_rows < 1){
                $topic_id = 'introduction';
            } else {
                $topic = $topic_result->fetch_assoc();
                $topic_title = $topic['topic_title'];
                $topic_text = $topic['content'];
            }
        }
    } else {
        $topic_id = 'introduction';
    }

    $page = ''.$subsection_title;
	$path = '../';
	
	require $path.'assets/inc/header.php';
?>

<?php      

?>


<main class="main-subsection">
    <aside class="aside-subsection">
        <nav class="nav-side">
            <header class="sidenav-subsection">
                <!-- Header of side nav bar -->
                <!-- TO BE REPLACED WITH PHP -->
                <h2><?php echo $subsection_title; ?></h2>
            </header>
            <div class="sidenav-topics">

                <a 
                    <?php if ($topic_id == 'introduction'){ echo ' class="active-topic" '; } ?>
                    href="subsection?subsectionID=<?php echo $subsection_id; ?>&topicID=introduction">Introduction
                </a>
                <?php
                    $sql_topics = "SELECT * FROM Topics WHERE subsection_id = '$subsection_id'";
                    $topics_result = $conn->query($sql_topics);

                    if($topics_result->num_rows > 0){
                        while($topic = $topics_result->fetch_assoc()){
                            if ($topic_id == $topic['topic_id']){
                                $istopic = 'class="active-topic" ';
                            } else {
                                $istopic = "";
                            }
                            echo '
                                <a '.$istopic.'
                                href="subsection?subsectionID='.$subsection_id.'&topicID='.$topic['topic_id'].'">'.$topic['topic_title'].'</a>
                            ';
                        }
                    }
                ?>

            </div>
        </nav>
    </aside>
    <div class="topic-content-container">
        <section class="topic-content">
                <h2 class="topic-title">
                    <?php echo $topic_title; ?>
                </h2>
                <p class="topic-description">
                    <?php echo $topic_text; ?>
                </p>
        </section>
    </div>
</main>


<?php
	include $path.'assets/inc/footer.php';
?>
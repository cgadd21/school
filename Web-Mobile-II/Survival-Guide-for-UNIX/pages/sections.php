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

	$page = 'Sections';
	$path = '../';
	
	require $path.'assets/inc/header.php';

	// include '/home/iste240t95/.dbConn.php';
?>


<main class="main-sections">
    <div class="sections-container">
    <?php        
        // Create database connection
        // Variables from include file in assets/inc/header.php
        $conn = new mysqli($servername, $username, $password, $dbname);
        // Check connection
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }
        $sql_sections = "SELECT * FROM Sections";
        $result = $conn->query($sql_sections);

        if($result->num_rows > 0){
            while($row = $result->fetch_assoc()){
                
                echo '
                    <div class="sections-list-container">
                        <div class="sections-list-header">
                            <h3>'.$row['section_title'].'</h3>
                        </div>
                        <div class="sections-list">
                ';

                $sql_subsections = "SELECT * FROM Subsections WHERE section_id='".$row['section_id']."'";
                $sub_result = $conn->query($sql_subsections);
                while($sub_row = $sub_result->fetch_assoc()){
                    echo '<a class="section-list-link" href="subsection.php?subsectionID='.$sub_row['subsection_id'].'">'.$sub_row['subsection_title'].'</a>';
                }

                echo '
                        </div>
                    </div>
                ';
            }
        } else {
            // Display if there are no previous comments
            echo 'No data';
        }

        // Close the database connection
        $conn->close();  
    ?>   

    </div>
</main>


<?php
	include $path.'assets/inc/footer.php';
?>
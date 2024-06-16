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

	$page = 'Quizzes';
	$path = '../';
	
	require $path.'assets/inc/header.php';

	// include '/home/iste240t95/.dbConn.php';'
?>


<main class="main-quizzes">
        <div class="hero">
            
        </div>
        <div class="page-list">
            <header class="page-list-header">
                <h2>Quizzes</h2>
            </header>
            <div class="page-list-links">
                <a href="#">Quiz for Section 1</a>
                <a href="#">Quiz for Section 2</a>
                <a href="#">Quiz for Section 3</a>

            </div>
        </div>
</main>


<?php
	include $path.'assets/inc/footer.php';
?>
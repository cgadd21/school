<!-- Header for all pages, in index.php, the h2 will display a fun message. -->
<header>
    <h1>
        <a href="index.php">Orlando Destinations</a>
    </h1>
    <h2>
        <?php 
            if ($currentPage != 'Orlando Destinations'){
                echo $currentPage;
            }else{
                echo 'Welcome to the Orange State!';
            }
        ?>
    </h2>
    <div class="hamburgerMenu">&#9776;</div>
</header>
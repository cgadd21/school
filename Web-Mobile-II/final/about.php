<?php $currentPage = "About"; ?>

<?php include('assets/inc/paperworkTop.php'); ?>

    <article>This is the annotation file (about page) with descriptions of the above and locations of the additions.</article>

    <div>
        <h3>Original JavaScript component</h3>
        <p>When the form validation doesn't validate, an error message moves appears and across the top of the page. Is is located in comments.php.</p>
    </div>

    <div>
        <h3>DHTML component</h3>
        <p>When the form validation doesn't validate, an error message moves appears and across the top of the page. It is located in comments.php.</p>
    </div>

    <div>
        <h3>Extras</h3>
        <ol>
            <li>When a page is currently active, then it is highlighted in the menu. This is in menuHighlight.js.</li>
            <li>When a mobile user is using this webpage, a hamburger menu icon appears. This will display the menu when clicked. This is in hamburgerMenu.js. Also, hover over menu has been removed when in mobile view.</li>
            <li>New colors to improve contrast. This is located in styles.css.</li>
            <li>Animation for when a user hovers on a nav element. This is located in styles.css.</li>
            <li>New titles using php which are more descriptive. This is located in each page and is stored in a PHP variable. Then it is echoed in header.php and head.php.</li>
            <li>Added title for entire website that upon hover will change color, and size with animation. Upon click, the user is taken back to the home page. If the user is already on the home page, then a fun message appears for the h2. This is in header.php and head.php.</li>
            <li>Added footer for references in footer.php.</li>
            <li>PHP includes for everything, so there's no repeated code. All of these are located in the inc folder.</li>
            <li>Media queries for responsive design. Located in styles.css.</li>
            <li>Google maps embedded in iframe to clearly show users where locations are. These maps will decrease in size as the viewport shrinks.</li>
            <li>I personally took each photo and lived the experiences I wrote about.</li>
            <li>Added styles so when a user's mouse is over the div, then the background color changes. This is in styles.css.</li>
            <li>Top of page will stick as user scrolls. This is located in styles.css.</li>
        </ol>
    </div>

<?php include('assets/inc/paperworkBottom.php'); ?>
//JS function to make current page 'active' and highlight it in the nav menu.
const currentPage = window.location.pathname.substring(1);
const navLinks = document.querySelectorAll('nav a');

navLinks.forEach(link => {
    const href = link.getAttribute('href').substring(1);
    if (currentPage.includes(href)){
        link.classList.add('active');
    }
});
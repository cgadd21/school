//JS function to show the main menu when the viewport is mobile and the user clicks the hamburger menu.
document.getElementsByClassName('hamburgerMenu')[0].addEventListener('click',function(){
    document.getElementById('mainMenu').style.display = 
    document.getElementById('mainMenu').style.display == 
    'block' ? 'none' : 'block'
});
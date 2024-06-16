function navDropdown() {
    var menu = document.getElementById("main-nav");
    if (menu.style.display === "flex") {
      menu.style.display = "none";
    } else {
      menu.style.display = "flex";
    }
  }

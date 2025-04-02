var calender_btn = document.getElementById("calenderBtn");
var register_btn = document.getElementById("registerBtn");
var login_btn = document.getElementById("loginBtn");
var logout_btn = document.getElementById("logoutBtn");

function loadPage(){
    console.log("register clicked");
    window.location.href = "/register";
}

calender_btn.addEventListener("click", function () {
    window.location.href = "/calender";
});

register_btn.addEventListener("click", function () {
    window.location.href = "/register";
});

login_btn.addEventListener("click", function () {
    window.location.href = "/login";
});

logout_btn.addEventListener("click", function () {
    window.location.href = "/logout";
});
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("registerForm").addEventListener("submit", async function(event) {
        event.preventDefault();

        const formData = {
            username: document.getElementById("username").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        };

        try {
            const response = await fetch("/user/create", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(formData)
            });
            window.location.href = "/index.html";
            //const result = await response.text();
            //alert(result);
        } catch (error) {
            console.error("회원가입 요청 실패:", error);
            alert("회원가입 중 오류가 발생했습니다.");
        }
    });
});
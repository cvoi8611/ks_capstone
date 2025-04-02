document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("createDateForm").addEventListener("submit", async function(event) {
        event.preventDefault();

        const formData = {
            title: document.getElementById("title").value,
            description: document.getElementById("description").value,
            place: document.getElementById("place").value,
            start_time: document.getElementById("start_time").value,
            end_time: document.getElementById("end_time").value,
        };

        try {
            const response = await fetch("/user/readAll", {
                method: "GET",
                headers: { "Content-Type": "application/json" },
                // 필요 시 Authorization 헤더 추가
                // "Authorization": "Bearer YOUR_ACCESS_TOKEN"
            });
            const data = await response.json();
            console.log("Fetched Data:", data);

            function isEmailExist(data, targetEmail) {
                return data.filter(data => data.email === targetEmail);
            }

            const existingData = isEmailExist(data, formData.email);

            if (existingData.length > 0){
                console.log(`existingData : ${existingData}`);
                console.log(existingData);
                console.log("DB에 존재하는 email임");
                const existingPwd = existingData.map(item => item.password);
                console.log(`비밀번호 확인 ${formData.password} / ${existingPwd}`);

                if (formData.password == existingPwd){
                    window.location.href = "/";
                    // Cookie Logic
                }
                else {
                    console.log("비밀번호 틀림");
                    alert("비밀번호가 틀렸습니다. 다시 확인해주세요.");
                }
            }
            else {
                console.log("DB에 존재하지 않는 email임");
                alert("계정을 찾을 수 없습니다. 다시 확인해주세요.");
            }


            //alert(result);
        } catch (error) {
            console.error("fetch 요청 실패:", error);
            alert("데이터를 불러오던 중 오류가 발생했습니다.");
        }
    });
});
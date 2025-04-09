document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("peList_btn").addEventListener("click", async function () {
        try {
            const response = await fetch("/api_event/getPEList", {
                method: "GET",
                //headers: { "Content-Type": "application/json" },
                // 필요 시 Authorization 헤더 추가
                // "Authorization": "Bearer YOUR_ACCESS_TOKEN"
            });
            const data = await response.json();
            console.log("Fetched Data:", data);
            //const itemData = data.response.body.items.item;
            //console.log("Item Data:", itemData);

            const listElement = document.getElementById("List_Output");
            listElement.innerHTML = ""; // 기존 목록 초기화

            data.forEach(item => {
                const li = document.createElement("li");
                li.textContent = JSON.stringify(item); // 데이터를 문자열로 변환하여 표시
                listElement.appendChild(li);
            });
        } catch (error) {
            console.error("fetch 요청 실패:", error);
            alert("데이터를 불러오던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요.");
        }
    });

    document.getElementById("mcList_btn").addEventListener("click", async function () {
        try {
            const response = await fetch("/api_event/getMCList", {
                method: "GET",
                headers: { "Content-Type": "application/json" },
                // 필요 시 Authorization 헤더 추가
                // "Authorization": "Bearer YOUR_ACCESS_TOKEN"
            });
            const data = await response.json();
            console.log("Fetched Data:", data);
            const itemData = data.response.body.items.item;
            console.log("Item Data:", itemData);

            const listElement = document.getElementById("List_Output");
            listElement.innerHTML = ""; // 기존 목록 초기화

            itemData.forEach(item => {
                const li = document.createElement("li");
                li.textContent = JSON.stringify(item); // 데이터를 문자열로 변환하여 표시
                listElement.appendChild(li);
            });
        } catch (error) {
            console.error("fetch 요청 실패:", error);
            alert("데이터를 불러오던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요.");
        }
    });

    document.getElementById("eList_btn").addEventListener("click", async function () {
        try {
            const response = await fetch("/api_event/getEList", {
                method: "GET",
                headers: { "Content-Type": "application/json" },
                // 필요 시 Authorization 헤더 추가
                // "Authorization": "Bearer YOUR_ACCESS_TOKEN"
            });
            const data = await response.json();
            console.log("Fetched Data:", data);
            const itemData = data.response.body.items.item;
            console.log("Item Data:", itemData);

            const listElement = document.getElementById("List_Output");
            listElement.innerHTML = ""; // 기존 목록 초기화

            itemData.forEach(item => {
                const li = document.createElement("li");
                li.textContent = JSON.stringify(item); // 데이터를 문자열로 변환하여 표시
                listElement.appendChild(li);
            });
        } catch (error) {
            console.error("fetch 요청 실패:", error);
            alert("데이터를 불러오던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요.");
        }
    });

    document.getElementById("cList_btn").addEventListener("click", async function () {
        try {
            const response = await fetch("/api_event/getCList", {
                method: "GET",
                headers: { "Content-Type": "application/json" },
                // 필요 시 Authorization 헤더 추가
                // "Authorization": "Bearer YOUR_ACCESS_TOKEN"
            });
            const data = await response.json();
            console.log("Fetched Data:", data);
            const itemData = data.response.body.items.item;
            console.log("Item Data:", itemData);

            const listElement = document.getElementById("List_Output");
            listElement.innerHTML = ""; // 기존 목록 초기화

            itemData.forEach(item => {
                const li = document.createElement("li");
                li.textContent = JSON.stringify(item); // 데이터를 문자열로 변환하여 표시
                listElement.appendChild(li);
            });
        } catch (error) {
            console.error("fetch 요청 실패:", error);
            alert("데이터를 불러오던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요.");
        }
    });

    document.getElementById("feeList_btn").addEventListener("click", async function () {
        try {
            const response = await fetch("/api_event/getFeeList", {
                method: "GET",
                headers: { "Content-Type": "application/json" },
                // 필요 시 Authorization 헤더 추가
                // "Authorization": "Bearer YOUR_ACCESS_TOKEN"
            });
            const data = await response.json();
            console.log("Fetched Data:", data);
            const itemData = data.response.body.items.item;
            console.log("Item Data:", itemData);

            const listElement = document.getElementById("List_Output");
            listElement.innerHTML = ""; // 기존 목록 초기화

            itemData.forEach(item => {
                const li = document.createElement("li");
                li.textContent = JSON.stringify(item); // 데이터를 문자열로 변환하여 표시
                listElement.appendChild(li);
            });
        } catch (error) {
            console.error("fetch 요청 실패:", error);
            alert("데이터를 불러오던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요.");
        }
    });

    document.getElementById("jmList_btn").addEventListener("click", async function () {
        try {
            const response = await fetch("/api_event/getJMLList", {
                method: "GET",
                headers: { "Content-Type": "application/json" },
                // 필요 시 Authorization 헤더 추가
                // "Authorization": "Bearer YOUR_ACCESS_TOKEN"
            });
            const data = await response.json();
            console.log("Fetched Data:", data);
            const itemData = data.response.body.items.item;
            console.log("Item Data:", itemData);

            const listElement = document.getElementById("List_Output");
            listElement.innerHTML = ""; // 기존 목록 초기화

            itemData.forEach(item => {
                const li = document.createElement("li");
                li.textContent = JSON.stringify(item); // 데이터를 문자열로 변환하여 표시
                listElement.appendChild(li);
            });
        } catch (error) {
            console.error("fetch 요청 실패:", error);
            alert("데이터를 불러오던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요.");
        }
    });
});
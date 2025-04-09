// src/pages/Login.tsx

import React, { useState } from "react";

const Logout: React.FC = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    try {
      const response = await fetch("/user/readAll", {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });

      if (!response.ok) throw new Error("서버 오류");

      const data: { email: string; password: string }[] = await response.json();
      const user = data.find((u) => u.email === email);

      if (!user) return alert("계정을 찾을 수 없습니다.");
      if (user.password !== password) return alert("비밀번호가 틀렸습니다.");

      // 로그인 성공
      window.location.href = "/";
    } catch (err) {
      console.error("로그인 실패:", err);
      alert("로그인 중 오류 발생");
    }
  };

  return (
    <div>
      <h2>로그인</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          placeholder="이메일"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="비밀번호"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">로그인</button>
      </form>
    </div>
  );
};

export default Logout;
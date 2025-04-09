import React from "react";
import { useNavigate } from "react-router-dom";

const Index: React.FC = () => {
  const navigate = useNavigate();

  const handleMove = (path: string) => {
    navigate(path);
  };

  return (
    <div style={{ padding: "2rem", textAlign: "center" }}>
      <h2>Welcome to Index Page!</h2>
      <div style={{ display: "flex", justifyContent: "center", gap: "1rem", marginTop: "1rem" }}>
        <button onClick={() => handleMove("/searchUser")}>SearchUser</button>
        <button onClick={() => handleMove("/searchEvent")}>SearchEvent</button>
        <button onClick={() => handleMove("/event")}>Event</button>
        <button onClick={() => handleMove("/calendar")}>Calendar</button>
        <button onClick={() => handleMove("/register")}>Register</button>
        <button onClick={() => handleMove("/login")}>Login</button>
        <button onClick={() => handleMove("/logout")}>Logout</button>
      </div>
    </div>
  );
};

export default Index;
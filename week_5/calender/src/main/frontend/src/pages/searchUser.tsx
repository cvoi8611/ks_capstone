import React, { useEffect, useState, ChangeEvent } from "react";

interface User {
  id: number;
  username: string;
  email: string;
  password: string;
  date_created: string;
}

const Search: React.FC = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [query, setQuery] = useState("");

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await fetch("/user/readAll", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });

        if (!response.ok) throw new Error("서버 응답 오류");
        console.log(response);

        const data: User[] = await response.json();
        setUsers(data);
      } catch (error) {
        console.error("유저 데이터 불러오기 실패:", error);
      }
    };

    fetchUsers();
  }, []);

  const handleSearch = (e: ChangeEvent<HTMLInputElement>) => {
    setQuery(e.target.value);
  };

  const filteredUsers = users.filter((user) =>
    `${user.email} ${user.username}`.toLowerCase().includes(query.toLowerCase())
  );

  return (
    <div style={{ maxWidth: 600, margin: "0 auto", padding: "20px" }}>
      <h2>👥 유저 검색</h2>
      <input
        type="text"
        placeholder="이메일이나 이름으로 검색"
        value={query}
        onChange={handleSearch}
        style={{ width: "100%", padding: "10px", fontSize: "16px" }}
      />
      <ul>
        {filteredUsers.length > 0 ? (
          filteredUsers.map((user, index) => (
            <li key={index}>
              <strong>{user.email}</strong> ({user.username})
            </li>
          ))
        ) : (
          <li>검색 결과가 없습니다.</li>
        )}
      </ul>
    </div>
  );
};

export default Search;
import React, { useEffect, useState, ChangeEvent } from "react";

interface APIEvent {
  id: number;
  description: string;
  docexamdt: string;
  docpassdt: string;
  docregenddt: string;
  docregstartdt: string;
  docsubmitentdt?: string;
  docsubmitstartdt?: string;
  pracexamenddt: string;
  pracexamstartdt: string;
  pracpassdt: string;
  pracregenddt: string;
  pracregstartdt: string;
}

const Search: React.FC = () => {
  const [events, setEvents] = useState<APIEvent[]>([]);
  const [query, setQuery] = useState("");

  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const response = await fetch("/api_event/readAll", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });

        if (!response.ok) throw new Error("서버 응답 오류");
        console.log("✅ API 응답:", response);

        const data: APIEvent[] = await response.json();
        setEvents(data);
      } catch (error) {
        console.error("이벤트 데이터 불러오기 실패:", error);
      }
    };

    fetchEvents();
  }, []);

  const handleSearch = (e: ChangeEvent<HTMLInputElement>) => {
    setQuery(e.target.value);
  };

  const filteredEvents = events.filter((event) =>
    event.description.toLowerCase().includes(query.toLowerCase())
  );

  return (
    <div style={{ maxWidth: 800, margin: "0 auto", padding: "20px" }}>
      <h2>📅 시험 일정 검색</h2>
      <input
        type="text"
        placeholder="시험명으로 검색 (예: 정보처리기사)"
        value={query}
        onChange={handleSearch}
        style={{ width: "100%", padding: "10px", fontSize: "16px" }}
      />
      <ul>
        {filteredEvents.length > 0 ? (
          filteredEvents.map((event) => (
            <li key={event.id} style={{ margin: "10px 0", lineHeight: "1.6" }}>
              <strong>{event.description}</strong><br />
              📄 필기 시험: {event.docexamdt} ~ {event.docpassdt}<br />
              📝 필기 접수: {event.docregstartdt} ~ {event.docregenddt}<br />
              🧾 서류 제출: {event.docsubmitstartdt || "-"} ~ {event.docsubmitentdt || "-"}<br />
              🧪 실기 시험: {event.pracexamstartdt} ~ {event.pracexamenddt}<br />
              🗓 실기 접수: {event.pracregstartdt} ~ {event.pracregenddt}<br />
              ✅ 실기 발표: {event.pracpassdt}
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

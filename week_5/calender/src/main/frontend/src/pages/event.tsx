import React, { useState } from 'react';

const EventPage: React.FC = () => {
  const [listData, setListData] = useState<any[]>([]);

  const fetchData = async (url: string, isArrayDirect?: boolean) => {
    try {
      const response = await fetch(url, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },
      });
      const data = await response.json();
      console.log('Fetched Data:', data);

      // 데이터 위치에 따라 분기 처리
      const items = isArrayDirect ? data : data.response?.body?.items?.item;

      setListData(Array.isArray(items) ? items : [items]);
    } catch (error) {
      console.error('fetch 요청 실패:', error);
      alert('데이터를 불러오던 중 오류가 발생했습니다.\n잠시후 다시 시도해주세요.');
    }
  };

  return (
    <div>
      <h1>Welcome to Event Page</h1>
      <button onClick={() => fetchData('/api_event/getPEList', true)}>기술사 등급 시험 시행일정 조회</button>
      <button onClick={() => fetchData('/api_event/getMCList', true)}>기능장 등급 시험 시행일정 조회</button>
      <button onClick={() => fetchData('/api_event/getEList', true)}>기사, 산업기사 등급 시험 시행일정 조회</button>
      <button onClick={() => fetchData('/api_event/getCList', true)}>기능사 등급 시험 시행일정 조회</button>
      <button onClick={() => fetchData('/api_event/getFeeList', true)}>종목별 응시 수수료 조회</button>
      <button onClick={() => fetchData('/api_event/getJMLList', true)}>종목별 시행일정 조회</button>

      <ul>
        {listData.map((item, index) => (
          <li key={index}>{JSON.stringify(item)}</li>
        ))}
      </ul>
    </div>
  );
};

export default EventPage;
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import IndexPage from './pages/index.tsx'
import LoginPage from './pages/login.tsx'
import LogoutPage from './pages/logout.tsx'
import CalendarPage from './pages/calendar.tsx'
import EventPage from './pages/event.tsx'
import SearchUserPage from './pages/searchUser.tsx'
import SearchEventPage from './pages/searchEvent.tsx'

function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path="/" element={<IndexPage/>} />
          <Route path="/calendar" element={<CalendarPage/>} />
          <Route path="/login" element={<LoginPage/>} />
          <Route path="/logout" element={<LogoutPage/>} />
          <Route path="/event" element={<EventPage />} />
          <Route path="/searchUser" element={<SearchUserPage />} />
          <Route path="/searchEvent" element={<SearchEventPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App

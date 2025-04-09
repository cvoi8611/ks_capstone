import { Component } from 'react';
import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';

class MyCalendar extends Component {
    render() {
        return (
          <div className="App">
            <FullCalendar
              initialView="dayGridMonth"a
              plugins={[ dayGridPlugin ]}
            />
          </div>
        );
    }
}
export default MyCalendar;
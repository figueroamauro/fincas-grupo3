import { useState, useEffect } from "react";
import Header from "../../components/Header/Header";
import Filtro from "../../components/Filtro/Filtro";
import { useNavigate } from "react-router-dom";
import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
import "./Calendar.css";

function CalendarComponent() {
  const [myEventsList, setMyEventsList] = useState([]); // ✅ Corregido
  const navigate = useNavigate();
  const localizer = momentLocalizer(moment);

  useEffect(() => {
    const generateRandomEvents = () => {
      const events = [];

      for (let i = 0; i < 20; i++) {
        const randomDaysOffset = Math.floor(Math.random() * 60) - 30;
        const start = new Date();
        start.setDate(start.getDate() + randomDaysOffset);

        const startHour = Math.floor(Math.random() * 10) + 8; // 08:00–17:00
        start.setHours(startHour, 0, 0);

        const duration = Math.floor(Math.random() * 2) + 1; // 1–2 horas
        const end = new Date(start);
        end.setHours(startHour + duration);

        // Asegurar que termine antes de 18:00
        if (end.getHours() > 18) end.setHours(18);

        events.push({
          title: `${start.getHours().toString().padStart(2, "0")}:${start
            .getMinutes()
            .toString()
            .padStart(2, "0")} - ${end
            .getHours()
            .toString()
            .padStart(2, "0")}:${end.getMinutes().toString().padStart(2, "0")}`,
          start,
          end,
        });
      }

      setMyEventsList(events);
    };

    generateRandomEvents();
  }, []);

  return (
    <div className="layout">
      <header className="header">
        <Header />
      </header>

      <aside className="sidebar-left">
        <Filtro />
      </aside>

      <main className="calendar">
        <div style={{ height: "100%" }}>
          <Calendar
            localizer={localizer}
            events={myEventsList}
            startAccessor="start"
            endAccessor="end"
            style={{ height: 1150, width: 1150 }}
            defaultView="month"
            views={["month"]}
            selectable
            popup
            onSelectEvent={(event) => {
              navigate(`/fincadetalle/${event.start.toISOString()}`, {
                state: {
                  start: event.start.toISOString(),
                  end: event.end.toISOString(),
                  title: event.title,
                },
              });
            }}
          />
        </div>
      </main>
    </div>
  );
}

export default CalendarComponent;

import { useLocation } from "react-router-dom";
import moment from "moment";

function Finca() {
  const location = useLocation();
  const { start, end, title } = location.state || {};

  const startMoment = moment(start);
  const endMoment = moment(end);

  const isValid = startMoment.isValid() && endMoment.isValid();

  if (!isValid) {
    return <div>❌ Datos de evento inválidos</div>;
  }

  return (
    <>
    <div style={{ padding: "20px" }}>
      <h2> Detalle de la finca</h2>
      <p>Fecha seleccionada: <strong>{startMoment.format("dddd, D [de] MMMM [de] YYYY")}</strong></p>
      <p> Horario: <strong>{startMoment.format("HH:mm")} - {endMoment.format("HH:mm")}</strong></p>
      <p> Título del evento: <strong>{title}</strong></p>
    </div>
    </>
  );
}

export default Finca;

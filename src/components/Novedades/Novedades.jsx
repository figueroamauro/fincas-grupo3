import { useEffect, useState } from "react";
import Data from "../../data/Data";
import "./Novedades.css";

function Novedades() {
  const [datos, setDatos] = useState([]);

  useEffect(() => {
    setDatos(Data.slice(0, 5));
  }, []);

  return (
    <div className="novedades-grid-container">
      <h1>FINCAS DESTACADAS</h1>
      {datos.map((item) => (
        <div key={item.id}>
          <h3>{item.titulo}</h3>
          <p>{item.descripcion}</p>
          <img src={item.foto} alt={item.titulo} style={{ width: "200px" }} />
        </div>
      ))}
    </div>
  );
}

export default Novedades;

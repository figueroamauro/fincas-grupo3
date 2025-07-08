import { useEffect, useState } from "react";
import Data from "../../data/Data";
import "./Main.css";
import { useNavigate } from "react-router-dom";

function Main() {
  const [datos, setDatos] = useState([]);
  const navigate = useNavigate();

  const handleNavigate = () => {
    navigate("/calendar");
  };
  useEffect(() => {
    setDatos(Data);
  }, []);

  return (
    <>
      <h1>FINCAS DISPONIBLES</h1>
      <div className="grid-container">
        {datos.map((item) => (
          <div
            key={item.id}
            onClick={handleNavigate}
            style={{ cursor: "pointer" }}
          >
            <h3>{item.titulo}</h3>
            <p>{item.descripcion}</p>
            <img src={item.foto} alt={item.titulo} style={{ width: "200px" }} />
          </div>
        ))}
      </div>
    </>
  );
}

export default Main;

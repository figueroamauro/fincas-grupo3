import {  useState } from "react";
import "./Home.css";
import { useNavigate } from "react-router-dom";

function Home() {
  const [nombre, setNombre] = useState("");
  const [contraseña, setContraseña] = useState("");
  const navigate = useNavigate();

  const handleLogin = () => {
    setNombre ("")
    setContraseña("")
    navigate ('/dashboard')
    
  };


  return (
    <div className="container-background">
        <div className="container">
      <h1 className="title">Iniciar sesión</h1>

      <div className="container-input">
        <input
          placeholder="Usuario"
          className="input"
          onChange={(e) => setNombre(e.target.value)}
          value={nombre}
        />
        <input
          type="password"
          placeholder="Contraseña"
          className="input"
          onChange={(e) => setContraseña(e.target.value)}
          value={contraseña}
        />
        <p className="text">¿Olvidaste tu contraseña?</p>
      </div>

      <div className="container-button">
        <button className="button" onClick={handleLogin}>
          Ingresar
        </button>
      </div>
      </div>
    </div>
  );
}

export default Home;

import "./Filtro.css";

function Filtro() {
  return (
    <div className="filtro-box">
      <h4 className="filtro-title">Filtrar por:</h4>
      <ul className="filtro-lista">
        <li className="filtro-item">
          <label className="checkbox-label">
            <input type="checkbox" className="hidden-checkbox" />
            <span className="custom-checkbox"></span>
            Con pileta
          </label>
        </li>
        <li className="filtro-item">
          <label className="checkbox-label">
            <input type="checkbox" className="hidden-checkbox" />
            <span className="custom-checkbox"></span>
            Sin pileta
          </label>
        </li>
      </ul>
    </div>
  );
}

export default Filtro;

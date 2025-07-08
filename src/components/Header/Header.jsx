import "./Header.css"

function Header() {
  return (
    <div className="header-container">
      <div className="container-left">
        <img src="../../assets/react.svg" alt="Logo" className="logo" />
        <h3>Reserva Finca</h3>
      </div>


      <div className="container-right">
        <input placeholder="Buscar..." className="search-input" />
        <button className="contact-button">Contacto</button>
      </div>
    </div>
  );
}

export default Header;

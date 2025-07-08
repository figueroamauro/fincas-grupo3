import "./Dashboard.css";
import Header from "../../components/Header/Header";
import Filtro from "../../components/Filtro/Filtro";
import Main from "../../components/Main/Main";
import Novedades from "../../components/Novedades/Novedades";

function Dashboard() {
  return (
    <div className="dashboard-grid-container">
      <header className="dashboard-header">
        <Header />
      </header>

      <nav className="dashboard-sidebar-left">
        {" "}
        {/* Sidebar Izquierda */}
        <Filtro />
      </nav>

      <main className="dashboard-main-content">
        <Main />
      </main>

      <aside className="dashboard-sidebar-right">
        <Novedades />
      </aside>
    </div>
  );
}

export default Dashboard;

import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "../../pages/Login/Login";
import Home from "../../pages/Home/Home";
import Dashboard from "../../pages/Dashboard/Dashboard";
import Calendar from "../../pages/Calendar/Calendar";
import Finca from "../../pages/Finca/Finca";

function Navigation() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/calendar" element={<Calendar />} />
          <Route path="/fincadetalle/:dia" element={<Finca />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default Navigation;

import React from "react";
import Home from "./Home/Home";
import "bootstrap/dist/css/bootstrap.min.css";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import { useSelector } from "react-redux";
import { selectUser } from "./features/UserSlice";
import PageNotFound from "./PageNotFound/PageNotFound";
import Login from "./Login/Login";
import Register from "./Register/Register";
import Dashboard from "./Dashboard/Dashboard";
import DocDashboard from "./DocDashboard/DocDashboard";

const App = () => {
  const user = useSelector(selectUser);
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="login/:type" element={<Login />} />
        <Route path="register/:type" element={<Register />} />
        <Route
          path="/dashboard"
          element={
            user?.isLoggedIn && user.type === "patient" ? (
              <Dashboard />
            ) : (
              <Navigate replace to="/" />
            )
          }
        />
        <Route
          path="/doc_dashboard"
          element={
            user?.isLoggedIn && user.type === "doctor" ? (
              <DocDashboard />
            ) : (
              <Navigate replace to="/" />
            )
          }
        />
        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </Router>
  );
};

export default App;

import React from "react";
import logo from "../Assets/TOKEN.svg";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="main__body">
      <div className="home__card">
        <div>
          <h1 className="title">
            T
            <span>
              <img src={logo} alt="Logo" />
            </span>
            KEN
          </h1>
        </div>
        <hr />
        <div className="Welcome__button__custom__container">
          <Link className="button__custom" to="/login/doctor">
            Doctor Sign in
          </Link>
          <Link className="button__custom" to="/login/patient">
            Patient Sign in
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Home;

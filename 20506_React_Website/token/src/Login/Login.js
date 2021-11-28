import React from "react";
import { useParams, useNavigate, useLocation } from "react-router-dom";
import signIn from "../Assets/signup.svg";
import LoginForm from "./Components/LoginForm";

const Login = () => {
  const { type } = useParams();
  const navigate = useNavigate();
  const location = useLocation();

  if (type === ("doctor" || "patient")) {
    navigate("/");
  }
  return (
    <body className="main__page__body">
      <div className="lhs__image">
        <img src={signIn} alt="sign in" />
      </div>
      <div className="rhs__content">
        <h1>
          Hello
          <br />
          There<span>.</span>
        </h1>
        <div className="myForm">
          {location.state ? (
            <div className="success__popup">
              <p>{location.state}</p>
            </div>
          ) : (
            ""
          )}

          <LoginForm type={type} />
        </div>
      </div>
    </body>
  );
};

export default Login;

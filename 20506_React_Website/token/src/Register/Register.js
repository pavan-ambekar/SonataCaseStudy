import React from "react";
import { useParams } from "react-router-dom";
import signUp from "../Assets/signin.svg";
import RegisterForm from "./Components/RegisterForm";

const Register = () => {
  const { type } = useParams();
  return (
    <div className="main__page__body">
      <div className="lhs__image">
        <img src={signUp} alt="sign up" />
      </div>
      <div className="rhs__content">
        <h1>
          Sign Up<span>.</span>
        </h1>
        <div className="myForm">
          <RegisterForm type={type} />
        </div>
      </div>
    </div>
  );
};

export default Register;

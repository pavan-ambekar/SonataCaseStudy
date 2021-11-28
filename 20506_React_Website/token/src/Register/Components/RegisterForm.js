import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const RegisterForm = ({ type }) => {
  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (type === "patient") {
      patientRegister();
    } else if (type === "doctor") {
      doctorRegister();
    } else {
      navigate("/");
    }
  };

  const patientRegister = () => {
    let pat = {
      password: password,
      patient: {
        eMail: email,
        name: name,
      },
    };
    axios
      .post("http://localhost:8080/patient/add", pat)
      .then((res) => {
        if (res.status === 200) {
          navigate(`/login/${type}`, {
            state: "Your Account is successfully created please login.",
          });
        }
      })
      .catch((err) => console.error(err));
  };

  const doctorRegister = () => {
    let doc = {
      password: password,
      doctor: {
        eMail: email,
        drName: name,
      },
    };
    axios
      .post("http://localhost:8080/doctor/add", doc)
      .then((res) => {
        if (res.status === 200) {
          navigate(`/login/${type}`, {
            state: "Your Account is successfully created please login.",
          });
        }
      })
      .catch((err) => console.error(err));
  };

  return (
    <form onSubmit={(e) => handleSubmit(e)}>
      <div>
        <label htmlFor="name">Name</label>
        <br />
        <input
          className="textBox"
          type="text"
          name="name"
          id="name"
          value={name}
          onChange={(e) => {
            setName(e.target.value);
          }}
          required
        />
      </div>
      <div>
        <label htmlFor="email">Email</label>
        <br />
        <input
          className="textBox"
          type="email"
          name="email"
          id="email"
          value={email}
          onChange={(e) => {
            setEmail(e.target.value);
          }}
          required
        />
      </div>
      <div>
        <label htmlFor="password">Password</label>
        <br />
        <input
          className="textBox"
          type="password"
          name="password"
          id="password"
          minLength="6"
          value={password}
          onChange={(e) => {
            setPassword(e.target.value);
          }}
          required
        />
      </div>
      <div>
        <input className="button" type="submit" value="Sign up" />
      </div>
    </form>
  );
};

export default RegisterForm;

import axios from "axios";
import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { login } from "../../features/UserSlice";

const LoginForm = ({ type }) => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const dispatch = useDispatch();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (type === "patient") {
      patientLogin();
    } else if (type === "doctor") {
      doctorLogin();
    } else {
      navigate("/");
    }
  };

  const patientLogin = () => {
    let pat = {
      password: password,
      patient: {
        eMail: email,
      },
    };
    axios
      .post("http://localhost:8080/patient/getpassword", pat)
      .then((res) => {
        if (res.data === true) {
          storeState();
        } else if (res.data === false) {
          setError("Please check password");
          setPassword("");
        } else if (res.data === "") {
          setError("User not found.");
        }
      })
      .catch((err) => console.error(err));
  };

  const doctorLogin = () => {
    let doc = {
      password: password,
      doctor: {
        eMail: email,
      },
    };
    axios
      .post("http://localhost:8080/doctor/getpassword", doc)
      .then((res) => {
        if (res.data === true) {
          setError("User logged in");
          console.log(doc.doctor);
          storeState();
        } else if (res.data === false) {
          setError("Please check password");
          setPassword("");
        } else if (res.data === "") {
          setError("User not found.");
        }
      })
      .catch((err) => console.error(err));
  };

  const storeState = () => {
    let doc = {
      eMail: email,
    };
    axios
      .post(`http://localhost:8080/${type}/info`, doc)
      .then((res) => {
        console.log(res);
        if (type === "patient") {
          dispatch(
            login({
              id: res.data.patID,
              name: res.data.name,
              eMail: res.data.eMail,
              specialization: res.data.speclization,
              phoneNumber: res.data.phoneNumber,
              sex: res.data.sex,
              bloodGroup: res.data.bloodGroup,
              type: type,
              isLoggedIn: true,
            })
          );
          navigate("/dashboard");
        } else if (type === "doctor") {
          dispatch(
            login({
              id: res.data.drID,
              name: res.data.drName,
              eMail: res.data.eMail,
              specialization: res.data.speclization,
              phoneNumber: res.data.phoneNumber,
              type: type,
              isLoggedIn: true,
            })
          );
          navigate("/doc_dashboard");
        }
      })
      .catch((err) => console.error(err));
  };

  return (
    <form onSubmit={(e) => handleSubmit(e)}>
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
        <p className="error">
          <strong>{error}</strong>
        </p>
      </div>
      <div>
        <input className="button" type="submit" value="Sign in" />
      </div>
      <div>
        <p>
          New to TOKEN?
          <strong>
            <Link to={`/register/${type}`}>Register</Link>
          </strong>
        </p>
      </div>
    </form>
  );
};

export default LoginForm;

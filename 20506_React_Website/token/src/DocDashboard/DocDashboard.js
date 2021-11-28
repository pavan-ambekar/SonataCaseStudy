import React, { useEffect, useState } from "react";
import logo from "../Assets/logo.png";
import { useDispatch, useSelector } from "react-redux";
import { logout, selectUser } from "../features/UserSlice";
import axios from "axios";
import { Modal, Button, Form } from "react-bootstrap";
import YourAppointments from "./components/YourAppointments";
import CompletedAppointments from "./components/CompletedAppointments";

const DocDashboard = () => {
  const user = useSelector(selectUser);
  const dispatch = useDispatch();
  console.log(user);
  const [wish, setWish] = useState("");

  const [email, setEmail] = useState(user.eMail);
  const [phoneNumber, setPhoneNumber] = useState(user.phoneNumber);
  const [specialization, setSpecialization] = useState(user.specialization);

  const [editShow, setEditShow] = useState(false);
  const handleClose = () => setEditShow(false);
  const handleEditShow = () => setEditShow(true);
  const handleEditSubmit = (e) => {
    e.preventDefault();
    handleClose();
    console.log(email, phoneNumber, specialization);
    let doctor = {
      drID: user.id,
      drName: user.name,
      speclization: specialization,
      eMail: email,
      phoneNumber: phoneNumber,
    };
    axios
      .post("http://localhost:8080/doctor/updatedetails", doctor)
      .then((res) => {
        if (res.status === 200) {
          console.log("Updated Data");
        }
      })
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    let day = new Date();
    let hr = day.getHours();
    if (hr >= 0 && hr < 12) {
      setWish("Good Morning");
    } else if (hr >= 12 && hr <= 17) {
      setWish("Good Afternoon");
    } else {
      setWish("Good Evening");
    }
    if (user.specialization === null) {
      handleEditShow();
    }
  }, []);

  const handleLogOut = (e) => {
    e.preventDefault();
    dispatch(logout());
  };

  return (
    <div class="dash__page__body">
      <nav class="top__nav">
        <img src={logo} alt="logo" />
        <div style={{ cursor: "pointer" }}>
          <strong
            onClick={(e) => {
              handleLogOut(e);
            }}
          >
            Logout
          </strong>
        </div>
      </nav>
      <div class="dash__sub__body">
        <div class="user__details">
          <img
            src={`https://avatars.dicebear.com/api/micah/${user.name}.svg`}
            onClick={handleEditShow}
            alt="Profile"
          />
          <div>
            <p>{wish}</p>
            <h1>Dr. {user.name}</h1>
          </div>
        </div>
        <hr className="dashboard__hr" />
        <div class="book">
          <h3>Your Appointment's</h3>
          <YourAppointments />
        </div>
        <div class="book">
          <h3>Completed Appointment</h3>
          <CompletedAppointments />
        </div>
      </div>
      <Modal show={editShow} onHide={handleClose} size="lg" centered scrollable>
        <Modal.Header closeButton>
          <Modal.Title>Edit profile</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <div class="doc__details">
            <img
              src={`https://avatars.dicebear.com/api/micah/${user.name}.svg`}
              alt="Profile"
            />
            <div>
              <h1>{user.name}</h1>
            </div>
          </div>
          <hr style={{ width: " 100%" }} />
          <Form className="container">
            <Form.Group className="mb-3" controlId="forEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formPhoneNumber">
              <Form.Label>Phone number</Form.Label>
              <Form.Control
                type="pno"
                value={phoneNumber}
                onChange={(e) => setPhoneNumber(e.target.value)}
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formSpecialization">
              <Form.Label>Specialization</Form.Label>
              <Form.Control
                type="text"
                value={specialization}
                onChange={(e) => setSpecialization(e.target.value)}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" size="sm" onClick={handleClose}>
            Close
          </Button>
          <Button
            type="submit"
            variant="primary"
            size="sm"
            onClick={(e) => {
              handleEditSubmit(e);
            }}
          >
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default DocDashboard;

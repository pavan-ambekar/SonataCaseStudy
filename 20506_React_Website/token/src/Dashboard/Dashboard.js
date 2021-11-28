import React, { useEffect, useState } from "react";
import logo from "../Assets/logo.png";
import { useDispatch, useSelector } from "react-redux";
import { logout, selectUser } from "../features/UserSlice";
import BookAppointment from "./Components/BookAppointment";
import { Modal, Button, Form } from "react-bootstrap";
import axios from "axios";
import YourAppointment from "./Components/YourAppointment";
import YourPrescription from "./Components/YourPrescription";

const Dashboard = () => {
  const user = useSelector(selectUser);
  const dispatch = useDispatch();

  const [email, setEmail] = useState(user.eMail);
  const [phoneNumber, setPhoneNumber] = useState(user.phoneNumber);
  const [age, setAge] = useState(user.age);
  const [sex, setSex] = useState(user.sex);
  const [bloodGroup, setBloodGroup] = useState(user.bloodGroup);

  const [editShow, setEditShow] = useState(false);
  const handleClose = () => setEditShow(false);
  const handleEditShow = () => setEditShow(true);
  const handleEditSubmit = (e) => {
    e.preventDefault();
    handleClose();
    console.log(email, phoneNumber, age, sex, bloodGroup);
    let patient = {
      patID: user.id,
      name: user.name,
      age: Number(age),
      sex: sex,
      eMail: email,
      phoneNumber: phoneNumber,
      bloodGroup: bloodGroup,
    };
    axios
      .post("http://localhost:8080/patient/updatedetails", patient)
      .then((res) => {
        if (res.status === 200) {
          console.log("Updated Data");
        }
      })
      .catch((err) => console.error(err));
  };

  const [wish, setWish] = useState("");

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
    if (user.bloodGroup === null) {
      handleEditShow();
    }
  }, []);

  const handleLogOut = (e) => {
    e.preventDefault();
    dispatch(logout());
  };

  return (
    <div className="dash__page__body">
      <nav className="top__nav">
        <img src={logo} alt="logo" />
        <div>
          <strong
            onClick={(e) => {
              handleLogOut(e);
            }}
          >
            Logout
          </strong>
        </div>
      </nav>
      <div className="dash__sub__body">
        <div className="user__details">
          <img
            src={`https://avatars.dicebear.com/api/micah/${user.name}.svg`}
            alt="Profile"
            onClick={handleEditShow}
          />
          <div>
            <p>{wish}</p>
            <h1>{user.name}</h1>
          </div>
        </div>
        <hr className="dashboard__hr" />
        <Modal
          show={editShow}
          onHide={handleClose}
          size="lg"
          centered
          scrollable
        >
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
              <Form.Group className="mb-3" controlId="formAge">
                <Form.Label>Age</Form.Label>
                <Form.Control
                  type="number"
                  value={age}
                  onChange={(e) => setAge(e.target.value)}
                />
              </Form.Group>
              <Form.Group className="mb-3" controlId="formSex">
                <Form.Label>Sex</Form.Label>
                <Form.Select
                  value={sex}
                  aria-label="Select Gender"
                  onChange={(e) => setSex(e.target.value)}
                >
                  <option value="M">Male</option>
                  <option value="F">Female</option>
                  <option value="T">Transgender</option>
                </Form.Select>
              </Form.Group>
              <Form.Group className="mb-3" controlId="formSex">
                <Form.Label>Blood Group</Form.Label>
                <Form.Select
                  value={bloodGroup}
                  aria-label="Select Blood Group"
                  onChange={(e) => setBloodGroup(e.target.value)}
                >
                  <option value="A+">A Positive</option>
                  <option value="A-">A Negative</option>
                  <option value="B+">B Positive</option>
                  <option value="B-">B Negative</option>
                  <option value="O+">O Positive</option>
                  <option value="O-">O Negative</option>
                  <option value="AB+">AB Positive</option>
                  <option value="AB-">AB Negative</option>
                </Form.Select>
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
        <div className="book">
          <h3>Your Appointment's</h3>
          <YourAppointment />
        </div>
        <div className="book">
          <h3>Your Prescription</h3>
          <YourPrescription />
        </div>
        <div className="book">
          <h3>Book Appointment</h3>
          <BookAppointment />
        </div>
      </div>
    </div>
  );
};

export default Dashboard;

import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { selectUser } from "../../features/UserSlice";
import { Card, Button, Modal, Form } from "react-bootstrap";
import YourAppointment from "./YourAppointment";
const BookAppointment = () => {
  const user = useSelector(selectUser);
  const [docData, setDocData] = useState("");
  const [disData, setDisData] = useState("");
  const [show, setShow] = useState(false);
  const [selectedDoc, setSelectedDoc] = useState(0);

  const [date, setDate] = useState("");
  const [startTime, setStartTime] = useState("");
  const [endTime, setEndTime] = useState("");
  const [dis, setDis] = useState("");

  const handleClose = () => setShow(false);
  const handleShow = (id) => {
    setShow(true);
    setSelectedDoc(id);
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/doctor/getDoc")
      .then((res) => {
        setDocData(res.data);
      })
      .catch((err) => {
        console.error(err);
      });
  }, []);
  useEffect(() => {
    axios
      .get("http://localhost:8080/dis/show")
      .then((res) => {
        setDisData(res.data);
      })
      .catch((err) => console.error(err));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    handleClose();
    let slot = {
      doctor: {
        drID: selectedDoc,
      },
      patient: {
        patID: user.id,
      },
      diseases: {
        disID: Number(dis),
      },
      date: date,
      startTime: startTime + ":00",
      endTime: endTime + ":00",
    };

    axios
      .post("http://localhost:8080/slot/add", slot)
      .then((res) => {
        console.log("Slot Added");
        if (res.status === 200) {
          this.setState({ YourAppointments: "" });
          setDate("");
          setDis("");
          setStartTime("");
          setEndTime("");
        }
      })
      .catch((err) => {
        console.error(err);
      });
  };
  return (
    <div className="view_cards">
      {docData.length <= 0 ? (
        <p>No Doctors Found</p>
      ) : (
        docData.map((doc) => {
          return (
            <Card
              key={doc.slotID}
              style={{ minWidth: "13rem" }}
              className="view__border py-3 mb-1"
            >
              <Card.Img
                style={{ height: "10rem" }}
                variant="top"
                src={`https://avatars.dicebear.com/api/micah/${doc.drName}.svg`}
                alt={doc.drName}
              />
              <Card.Body>
                <Card.Title style={{ fontSize: "1rem", fontWeight: "bold" }}>
                  {doc.drName}
                </Card.Title>
                <Card.Text style={{ fontSize: "0.8rem" }}>
                  {doc.speclization}
                </Card.Text>
                <Button
                  variant="warning"
                  pill
                  size="sm"
                  onClick={() => {
                    handleShow(doc.drID);
                  }}
                >
                  Book Slot
                </Button>
              </Card.Body>
            </Card>
          );
        })
      )}
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Book Appointment</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="formDate">
              <Form.Label>Date</Form.Label>
              <Form.Control
                type="date"
                value={date}
                onChange={(e) => setDate(e.target.value)}
              />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formStartTime">
              <Form.Label>Start Time</Form.Label>
              <Form.Control
                type="time"
                value={startTime}
                onChange={(e) => setStartTime(e.target.value)}
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formEndTime">
              <Form.Label>End Time</Form.Label>
              <Form.Control
                type="time"
                value={endTime}
                onChange={(e) => setEndTime(e.target.value)}
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formDis">
              <Form.Label>Treatments</Form.Label>
              <Form.Select
                aria-label="Select Treatment"
                value={dis}
                onChange={(e) => {
                  setDis(e.target.value);
                }}
              >
                <option>Select Treatment</option>
                {disData.length === 0 ? (
                  <p>Diseases not available</p>
                ) : (
                  disData.map((d) => {
                    return (
                      <option key={d.disID} value={d.disID}>
                        {d.disName}
                      </option>
                    );
                  })
                )}
              </Form.Select>
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose} size="sm">
            Close
          </Button>
          <Button
            type="submit"
            variant="primary"
            onClick={(e) => handleSubmit(e)}
            size="sm"
          >
            Book
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default BookAppointment;

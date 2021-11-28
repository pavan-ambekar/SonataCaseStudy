import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Card, Modal, Form } from "react-bootstrap";
import { useSelector } from "react-redux";
import { selectUser } from "../../features/UserSlice";
const YourAppointments = () => {
  const user = useSelector(selectUser);
  const [appointData, setAppointData] = useState([]);
  const [selectedSlot, setSelectedSlot] = useState("");
  const [presc, setPresc] = useState("");

  const [show, setShow] = useState(false);

  const handleClose = () => {
    setShow(false);
    setPresc("");
    setSelectedSlot("");
  };
  const handleShow = (id) => {
    setShow(true);
    setSelectedSlot(id);
  };
  const handleSubmit = (e) => {
    setShow(false);
    e.preventDefault();
    console.log(selectedSlot, presc);
    let p = {
      slot: {
        slotID: selectedSlot,
      },
      prescription: presc,
    };
    axios
      .post("http://localhost:8080/pres/add", p)
      .then((res) => {
        console.log("Slot Added");
        if (res.status === 200) {
          console.log(res.data);
        }
      })
      .catch((err) => {
        console.error(err);
        setPresc("");
        setSelectedSlot("");
      });
  };
  useEffect(() => {
    axios
      .post("http://localhost:8080/slot/bydoc", { drID: user.id })
      .then((res) => {
        setAppointData(res.data);
        // setappointData(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const timeConvert = (time) => {
    // Check correct time format and split into components
    time = time
      .toString()
      .match(/^([01]\d|2[0-3])(:)([0-5]\d)(:[0-5]\d)?$/) || [time];

    if (time.length > 1) {
      // If time format correct
      time = time.slice(1); // Remove full string match value
      time[5] = +time[0] < 12 ? "AM" : "PM"; // Set AM/PM
      time[0] = +time[0] % 12 || 12; // Adjust hours
    }
    return time.join(""); // return adjusted time or original string
  };

  return (
    <div class="view_cards">
      {appointData.length <= 0 ? (
        <p>No Appointments for Today</p>
      ) : (
        appointData.map((appint) => {
          return (
            <Card
              key={appint.slotID}
              className="view__border py-3 "
              style={{ minWidth: "13rem" }}
            >
              <Card.Img
                variant="left"
                style={{ height: "10rem" }}
                src={`https://avatars.dicebear.com/api/micah/${appint.patient.name}.svg`}
                alt={appint.patient.name}
              />
              <Card.Body>
                <Card.Title style={{ fontSize: "1rem", fontWeight: "bold" }}>
                  {appint.patient.name}
                </Card.Title>
                <Card.Text style={{ fontSize: "0.8rem" }}>
                  <p style={{ marginBottom: 0 }}>{appint.date}</p>
                  <span>{timeConvert(appint.startTime)}</span> to{" "}
                  <span>{timeConvert(appint.endTime)}</span>
                </Card.Text>
                <Button
                  variant="primary"
                  pill
                  size="sm"
                  onClick={() => handleShow(appint.slotID)}
                >
                  Add Prescription
                </Button>
              </Card.Body>
            </Card>
          );
        })
      )}
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Add Prescription</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="formPrescription">
              <Form.Label>Prescription</Form.Label>
              <Form.Control
                as="textarea"
                rows={5}
                placeholder="Add Prescription"
                value={presc}
                onChange={(e) => setPresc(e.target.value)}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" size="sm" onClick={handleClose}>
            Close
          </Button>
          <Button
            variant="primary"
            type="submit"
            size="sm"
            onClick={(e) => handleSubmit(e)}
          >
            Add Prescription
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default YourAppointments;

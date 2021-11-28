import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Card, Modal, Form } from "react-bootstrap";
import { useSelector } from "react-redux";
import { selectUser } from "../../features/UserSlice";
const CompletedAppointments = () => {
  const user = useSelector(selectUser);
  const [cAppount, setCAppount] = useState([]);
  const [selectedSlot, setSelectedSlot] = useState("");
  const [feedback, setFeedback] = useState("");

  const [show, setShow] = useState(false);
  useEffect(() => {
    axios
      .post("http://localhost:8080/pres/bydoc", { drID: user.id })
      .then((res) => {
        console.log(res.data);
        setCAppount(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const handleClose = () => {
    setShow(false);
    setFeedback("");
    setSelectedSlot("");
  };
  const handleShow = (id) => {
    setShow(true);
    axios
      .post("http://localhost:8080/feedback/byslot", { slotID: id })
      .then((res) => {
        console.log("Slot Added");
        if (res.status === 200) {
          console.log(res.data);
          if (res.data.length > 0) {
            setFeedback(res.data[0].feedback);
          } else {
            setFeedback("Patient is not added FeedBack");
          }
        }
      })
      .catch((err) => {
        console.error(err);
        setFeedback("");
        setSelectedSlot("");
      });
  };

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
      {cAppount.length <= 0 ? (
        <p>Not Completed Appointments Today</p>
      ) : (
        cAppount.map((appint) => {
          return (
            <Card
              key={appint.feedbackriptionID}
              className="view__border py-3 "
              style={{ width: "13rem" }}
            >
              <Card.Img
                variant="left"
                style={{ height: "10rem" }}
                src={`https://avatars.dicebear.com/api/micah/${appint.slot.patient.name}.svg`}
                alt={appint.slot.patient.name}
              />
              <Card.Body>
                <Card.Title style={{ fontSize: "1rem", fontWeight: "bold" }}>
                  {appint.slot.patient.name}
                </Card.Title>
                <Card.Text style={{ fontSize: "0.8rem" }}>
                  <p style={{ marginBottom: 0 }}>{appint.slot.date}</p>
                  <span>{timeConvert(appint.slot.startTime)}</span> to{" "}
                  <span>{timeConvert(appint.slot.endTime)}</span>
                </Card.Text>
                <Button
                  variant="primary"
                  pill
                  size="sm"
                  onClick={() => handleShow(appint.slot.slotID)}
                >
                  View FeedBack
                </Button>
              </Card.Body>
            </Card>
          );
        })
      )}
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Show Feedack</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="formFeedback">
              <Form.Label>Feedback</Form.Label>
              <Form.Control
                as="textarea"
                rows={5}
                readOnly
                value={feedback}
                onChange={(e) => setFeedback(e.target.value)}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" size="sm" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default CompletedAppointments;

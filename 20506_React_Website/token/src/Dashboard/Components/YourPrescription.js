import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Card, Modal, Form } from "react-bootstrap";
import { useSelector } from "react-redux";
import { selectUser } from "../../features/UserSlice";

const YourPrescription = () => {
  const user = useSelector(selectUser);
  useEffect(() => {
    axios
      .post("http://localhost:8080/pres/bypat", { patID: user.id })
      .then((res) => {
        console.log(res.data);
        setCAppount(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  const [cAppount, setCAppount] = useState([]);
  const [show, setShow] = useState(false);
  const [selectedSlot, setSelectedSlot] = useState("");
  const [feedback, setfeedback] = useState("");
  const handleClose = () => {
    setShow(false);
    setfeedback("");
    setSelectedSlot("");
  };
  const handleShow = (id) => {
    setShow(true);
    setSelectedSlot(id);
  };
  const handleSubmit = (e) => {
    setShow(false);
    e.preventDefault();
    console.log(selectedSlot, feedback);
    let p = {
      slot: {
        slotID: selectedSlot,
      },
      feedback: feedback,
    };
    console.log(p);
    axios
      .post("http://localhost:8080/feedback/add", p)
      .then((res) => {
        console.log("Slot Added");
        if (res.status === 200) {
          console.log("FeedBack added");
        }
      })
      .catch((err) => {
        console.error(err);
        setfeedback("");
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
        <p>No feedbackriptions</p>
      ) : (
        cAppount.map((appint) => {
          return (
            <Card
              key={appint.feedbackriptionID}
              className="view__border py-3 mb-1"
              style={{ width: "13rem" }}
            >
              <Card.Img
                variant="left"
                style={{ height: "10rem" }}
                src={`https://avatars.dicebear.com/api/micah/${appint.slot.doctor.drName}.svg`}
                alt={appint.slot.doctor.drName}
              />
              <Card.Body>
                <Card.Title style={{ fontSize: "1rem", fontWeight: "bold" }}>
                  {appint.slot.doctor.drName}
                </Card.Title>
                <Card.Text style={{ fontSize: "0.8rem" }}>
                  <p style={{ marginBottom: 0 }}>
                    {appint.slot.diseases.disName}
                  </p>
                  <p style={{ marginBottom: 0 }}>{appint.slot.date}</p>
                </Card.Text>
                <Button
                  variant="primary"
                  pill
                  size="sm"
                  onClick={() => handleShow(appint.slot.slotID)}
                >
                  Add FeedBack
                </Button>
              </Card.Body>
            </Card>
          );
        })
      )}
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Add FeedBack</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="formFeedback">
              <Form.Label>Feedback</Form.Label>
              <Form.Control
                as="textarea"
                rows={5}
                placeholder="Add Feedback"
                value={feedback}
                onChange={(e) => setfeedback(e.target.value)}
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
            Add Feedback
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default YourPrescription;

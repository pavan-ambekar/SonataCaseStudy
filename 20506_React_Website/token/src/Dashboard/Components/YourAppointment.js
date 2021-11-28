import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Card } from "react-bootstrap";
import { useSelector } from "react-redux";
import { selectUser } from "../../features/UserSlice";

const YourAppointment = () => {
  const user = useSelector(selectUser);

  const [appointData, setAppointData] = useState([]);
  useEffect(() => {
    axios
      .post("http://localhost:8080/slot/bypat", { patID: user.id })
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
        <p>No Appointments, Please Book you are Appointment.</p>
      ) : (
        appointData.map((appint) => {
          return (
            <Card
              key={appint.slotID}
              className="view__border py-3 mb-1"
              style={{ minWidth: "13rem" }}
            >
              <Card.Img
                variant="top"
                style={{ height: "10rem" }}
                src={`https://avatars.dicebear.com/api/micah/${appint.doctor.drName}.svg`}
                alt={appint.doctor.drName}
              />
              <Card.Body>
                <Card.Title style={{ fontSize: "1rem", fontWeight: "bold" }}>
                  {appint.doctor.drName}
                </Card.Title>
                <Card.Text style={{ fontSize: "0.8rem" }}>
                  <strong style={{ marginBottom: 0 }}>
                    {appint.diseases.disName}
                  </strong>
                  <p style={{ marginBottom: 0 }}>{appint.date}</p>
                  <span>{timeConvert(appint.startTime)}</span> to{" "}
                  <span>{timeConvert(appint.endTime)}</span>
                </Card.Text>
                <Button variant="danger" pill size="sm">
                  Delete Slot
                </Button>
              </Card.Body>
            </Card>
          );
        })
      )}
    </div>
  );
};

export default YourAppointment;

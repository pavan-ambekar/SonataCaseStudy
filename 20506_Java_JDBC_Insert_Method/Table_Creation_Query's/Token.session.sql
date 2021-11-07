CREATE TABLE Diseases (
  dis_id INT PRIMARY KEY AUTO_INCREMENT,
  dis_name VARCHAR(255)
);
--@block
CREATE TABLE Patient (
  pat_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARBINARY(45),
  age INT,
  sex varchar(1),
  e_mail varchar(45) UNIQUE,
  phone_number varchar(12) UNIQUE,
  blood_group varchar(2)
) --@block
CREATE TABLE Doctor (
  dr_id INT PRIMARY KEY AUTO_INCREMENT,
  dr_name VARBINARY(45),
  specliation varchar(45),
  e_mail varchar(45) UNIQUE,
  phone_number varchar(12) UNIQUE
) --@block
CREATE TABLE Doctor_login (
  dr_id INT,
  password varchar(45),
  FOREIGN KEY (dr_id) REFERENCES Doctor(dr_id)
) --@block
CREATE TABLE Patient_login (
  pat_id INT,
  password varchar(45),
  FOREIGN KEY (pat_id) REFERENCES Patient(pat_id)
) --@block
CREATE TABLE Slot (
  slot_id int PRIMARY KEY AUTO_INCREMENT,
  dr_id int,
  pat_id int,
  dis_id int,
  slot_date DATE,
  start_time TIME,
  end_time TIME,
  FOREIGN KEY (pat_id) REFERENCES Patient(pat_id),
  FOREIGN KEY (dr_id) REFERENCES Doctor(dr_id),
  FOREIGN KEY (dis_id) REFERENCES Diseases(dis_id)
);
--@block
CREATE TABLE Paitent_Feedback (
  feedback_id int PRIMARY KEY AUTO_INCREMENT,
  dr_id int,
  pat_id int,
  feedback VARCHAR(255),
  fb_date DATETIME,
  FOREIGN KEY (pat_id) REFERENCES Patient(pat_id),
  FOREIGN KEY (dr_id) REFERENCES Doctor(dr_id)
);
--@block
select *
from patient;
--@block
ALTER TABLE patient
MODIFY COLUMN name varchar(45);
--@block
DROP PROCEDURE addPrescription;
--@block
CREATE PROCEDURE addDoctor(
  IN drID INT,
  IN drName VARCHAR(45),
  IN specliazation VARCHAR(45),
  IN eMail VARCHAR(45),
  IN phoneNumber VARCHAR(12)
) BEGIN
INSERT INTO doctor (
    dr_id,
    dr_name,
    specliation,
    e_mail,
    phone_number
  )
VALUES(drID, drName, specliazation, eMail, phoneNumber);
END --@block 
CREATE PROCEDURE addPatient(
  pat_id INT,
  name VARBINARY(45),
  age INT,
  sex varchar(1),
  e_mail varchar(45),
  phone_number varchar(12),
  blood_group varchar(2)
) BEGIN
INSERT INTO patient
VALUES(
    pat_id,
    name,
    age,
    sex,
    e_mail,
    phone_number,
    blood_group
  );
END --@block
CREATE PROCEDURE addDiseases(dis_id INT, dis_name VARCHAR(255)) BEGIN
INSERT INTO diseases
VALUES(dis_id, dis_name);
END --@block
CREATE PROCEDURE addDoctorLogin(dr_id INT, password varchar(45)) BEGIN
INSERT INTO doctor_login
VALUES(dr_id, password);
END --@block
CREATE PROCEDURE addPatientLogin(pat_id INT, password varchar(45)) BEGIN
INSERT INTO patient_login
VALUES(pat_id, password);
END --@block
CREATE PROCEDURE addPaitentFeedback(
  feedback_id int,
  dr_id int,
  pat_id int,
  feedback VARCHAR(255),
  fb_date DATETIME
) BEGIN
INSERT INTO paitent_feedback
VALUES(feedback_id, dr_id, pat_id, feedback, fb_date);
END --@block
call addDoctor(
  555,
  "RAVAN",
  "mbbs",
  "tyu@yyu.com",
  "5656565656"
);
--@block
CREATE PROCEDURE addSlot(
  slot_id int,
  dr_id int,
  pat_id int,
  dis_id int,
  slot_date DATE,
  start_time TIME,
  end_time TIME
) BEGIN
INSERT INTO Slot
VALUES(
    slot_id,
    dr_id,
    pat_id,
    dis_id,
    slot_date,
    start_time,
    end_time
  );
END --@block
CREATE TABLE Prescription (
  slot_id int,
  prescription VARCHAR(255),
  FOREIGN KEY (slot_id) REFERENCES Slot(slot_id)
) --@block
CREATE PROCEDURE addPrescription(slot_id int, prescription VARCHAR(255)) BEGIN
INSERT INTO prescription
VALUES (slot_id, prescription);
END 

--@block
select d.dr_name as name, dl.password as password from doctor as d JOIN doctor_login as dl ON d.dr_id = dl.dr_id WHERE d.dr_name = "arow"

--@block
select * from doctor_login
--@block
select d.dr_name as name, dl.password as password from doctor as JOIN doctor_login as dl ON d.dr_id = dl.dr_id WHERE d.dr_name = "AROW"
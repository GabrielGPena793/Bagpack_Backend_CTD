DROP TABLE IF EXISTS airPlane;

CREATE TABLE airPlane (
id INT PRIMARY KEY,
brand VARCHAR(60),
model VARCHAR(60),
registration INT,
dateEntryIntoservice DATE
);

CREATE TABLE Hostel.Student(
	usn VARCHAR(10) PRIMARY KEY,
    f_name VARCHAR(20),
    l_name VARCHAR(20),
    passwd VARCHAR(24),
    dob DATE,
    department VARCHAR(3),
    semester VARCHAR(1),
    gpa DOUBLE(3,2),
    gender VARCHAR(1),
    guardian_name VARCHAR(40),
    guardian_contact VARCHAR(10),
    perm_address VARCHAR(255),
    warden VARCHAR(10),
    room VARCHAR(5),
    mobile_no VARCHAR(10),
    
	FOREIGN KEY (warden) REFERENCES Warden (emp_id),
    FOREIGN KEY (room) REFERENCES Room (r_id)
);

CREATE TABLE Warden (
	emp_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR (40),
    contact VARCHAR(10),
    passwd VARCHAR(24)
);

CREATE TABLE Room (
	r_id VARCHAR(5) PRIMARY KEY,
    r_type_id VARCHAR(5),
    b_id VARCHAR(5),
    
    FOREIGN KEY (r_type_id) REFERENCES RoomType (r_type_id),
    FOREIGN KEY (b_id) REFERENCES Block (b_id)
);

CREATE TABLE Block (
	b_id VARCHAR(5) PRIMARY KEY,
    b_name VARCHAR(20),
    no_of_floors INT,
    b_type VARCHAR(5),
    warden VARCHAR(10),
    
    FOREIGN KEY (warden) REFERENCES Warden (emp_id)
);

CREATE TABLE RoomType (
	r_type_id VARCHAR(5) PRIMARY KEY,
    occupancy INT,
    bathroom VARCHAR(3),
    fees INT,
    room_desc VARCHAR(255)
);
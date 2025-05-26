create database CARRENTAL;

use Carrental;

create table Customer(Customerid int primary key auto_increment,
Customername varchar(255) not null,
Address varchar(255) not null,
ContactInfo varchar(255) not null,
Email varchar(255) unique not null,
driverlicense varchar(255) not null,
Created_time datetime default current_timestamp);


create table Manager(ManagerID int primary key,
ManagerName varchar(255) not null,
Address varchar(255) not null,
ContactInfo varchar(255) default "No Contact Info",
Email varchar(255) unique );

alter table manager add column Branch_id int,ADD Constraint fk_manager_branch foreign key(branch_id) references Branch(Branchid);

create table CAR(carID int primary key auto_increment,
Source_type enum ("Lender","Company") default "Company",
Lender_id int default null,
Brand varchar(255) not null,
Model varchar(255),
Year int,
License_plate varchar(255) not null unique,
status enum ("Available","Rented","Maintenance"),
daily_rate Decimal(10,2),
CHECK (
    (Source_type = 'Company' AND Lender_id IS NULL) OR
    (Source_type = 'Lender' AND Lender_id IS NOT NULL)
),
Foreign key(Lender_id) references Lender(LenderId) on delete cascade
);

create table branch(BranchID int primary key auto_increment,
BranchName varchar(255),
Location varchar(255) not null);

create table Lender(LenderId int primary key auto_increment,
LenderName varchar(255) not null,
ContactInfo varchar(255) not null,
email varchar(255) unique not null,
Address varchar(255)); 

show tables;

alter table car add column currentbranch_ID int not null,
add constraint fk_car_branch foreign key(currentbranch_id) references branch(branchID);

create table rental(rentalID int primary key not null auto_increment,
car_id int,
customer_id int,
manager_id int,
pickup_branch int,
dropoff_branch int,
Start_date datetime default current_timestamp,
End_date datetime not null,
total_cost decimal(10,2),
rentalstatus enum ('Completed','Ongoing','Cancelled'),
Foreign key fk_rental_car (car_id) references car(carid),
Foreign key fk_rental_customer (customer_id) references customer(customerid),
Foreign key fk_rental_manager (manager_id) references manager(managerid),
Foreign key fk_rental_pickupbranch (pickup_branch) references branch(branchid),
Foreign key fk_rental_dropoffbranch (dropoff_branch) references branch(branchid)
);

CREATE TABLE Employee (
    EmpID INT PRIMARY KEY AUTO_INCREMENT,
    EmpName VARCHAR(255) NOT NULL,
    JoinDate DATE NOT NULL,
    IsManager BOOLEAN DEFAULT FALSE,
    ManagerID INT,
    BranchID INT,
    FOREIGN KEY (ManagerID) REFERENCES Manager(ManagerID),
    FOREIGN KEY (BranchID) REFERENCES Branch(BranchID)
);

CREATE TABLE Login(
    LoginID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255) UNIQUE NOT NULL,
    PasswordHash VARCHAR(255) NOT NULL,
    UserType ENUM('Customer', 'Manager', 'Employee') NOT NULL,
    UserRefID INT NOT NULL 
);



CREATE TABLE ReservationLog (
    ResID INT PRIMARY KEY AUTO_INCREMENT,
    CarID INT NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME NOT NULL,
    Status ENUM('Booked', 'Cancelled', 'Completed') DEFAULT 'Booked',
    FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);

CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT,
    RentalID INT NOT NULL,
    PaymentDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Amount DECIMAL(10,2) NOT NULL,
    PaymentMode ENUM('Credit Card', 'Debit Card', 'UPI', 'Cash', 'NetBanking') NOT NULL,
    PaymentStatus ENUM('Success', 'Failed', 'Pending') DEFAULT 'Pending',
    FOREIGN KEY (RentalID) REFERENCES Rental(RentalID)
);

CREATE TABLE CarMaintenance (
    MaintenanceID INT PRIMARY KEY AUTO_INCREMENT,
    CarID INT NOT NULL,
    ServiceDate DATE NOT NULL,
    Description TEXT,
    Cost DECIMAL(10,2),
    FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);


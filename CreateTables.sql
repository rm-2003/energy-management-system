CREATE TABLE Appliance (
    Appliance_Id int AUTO_INCREMENT,
    Appliance_Name VARCHAR(100),
    Power_Consumption_Rating INT,
    PRIMARY KEY (Appliance_Id)
);

CREATE TABLE Household_Consumer (
    Household_Consumer_Id bigint AUTO_INCREMENT ,
    City VARCHAR(100),
    Street VARCHAR(100),
    Plot_no int,
    Name VARCHAR(100),
    Mobile_Number bigint,
    No_Solar_Panels INT,
    Balance INT,
    password varchar(5),
    PRIMARY KEY (Household_Consumer_Id)
);

CREATE TABLE Industrial_Consumer (
    Industrial_Consumer_Id bigint AUTO_INCREMENT,
    NON_REC_permits INT,
    Industry_Size VARCHAR(100),
    Name VARCHAR(100),
    Mobile_Number BIGINT,
    City VARCHAR(100),
    Street VARCHAR(100),
    Plot_no INT,
    Balance_Industry INT,
    Balance_Industry_Renew INT,
    password varchar(5),
    PRIMARY KEY (Industrial_Consumer_Id)
);

CREATE TABLE Supplier (
    Supplier_ID int auto_increment,
    Supplier_Type VARCHAR(50),
    City VARCHAR(100),
    Street VARCHAR(100),
    Plot_No INT,
    Name VARCHAR(100),
    Mobile_Number BIGINT,
    password varchar(5),
    PRIMARY KEY (Supplier_ID)
);

CREATE TABLE Transaction(
	Transaction_Id bigint auto_increment,
    Consumer_Id bigint,
    Consumer_type varchar(10),
    Supplier_Id bigint,
    No_of_Credits int,
    Pre_subsidy_amount int,
    Post_subsidy_amount int,
    Timestamp datetime,
    PRIMARY key (Transaction_Id)
);

CREATE TABLE Complain(
    Consumer_Id bigint,
    Consumer_type varchar(10),
    Supplier_Id bigint,
    Timestamp datetime,
	Complain_Id bigint AUTO_INCREMENT,
    Description varchar(100),
    PRIMARY key (Complain_Id)
);

CREATE TABLE Consumption(
    Consumer_Id bigint,
    Consumer_type varchar(10),
    Month int,
    Year int,
    units_consumed int
);

create table RegisterUser
( emp_id int(50),
pwd varchar(50),
emp_name varchar(200),
cont_no BIGINT(20),
alt_cont_no BIGINT(20),
email_id varchar(30),
address varchar(300),
user_role varchar(50),
vehicle_no varchar(50),
vehicle_type varchar(100),
seat_count int (5),
created_at varchar(50),
update_at varchar(50),
primary key (emp_id)
);

create table RideDetails
( 
rid int(50) auto_increment,
emp_id int(50),
source_add varchar(300),
destination_add  varchar(300),
journey_date  date,
journey_time time,
user_role varchar(50),
vehicle_no varchar(50),
available_seat_count int(20),
primary key (rid),
foreign key (emp_id) references RegisterUser(emp_id)
);

create table ProviderDetails
( 
pid int(50) auto_increment,
empId varchar(50),
route varchar(50),
fromAdd  varchar(300),
toAdd  varchar(300),
pdate varchar(30),
contact varchar(20),
altContact varchar(20),
email varchar(50),
vehicleNo varchar(50),
vehType varchar(10),
noOfSeats varchar(20),
primary key (pid),
);
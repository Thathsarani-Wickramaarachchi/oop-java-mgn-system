create database pay; 
use pay;
create table info
(
id int primary key auto_increment,
	firstname varchar(25) ,
	email varchar(25),
	address varchar(25),
    state varchar(25),
	city varchar(25),
    zip varchar(25),
    cardname varchar(25),
    cardnumber varchar(25)
);


use pay;
CREATE TABLE user (
  cid int(11) NOT NULL,
  fname varchar(40) NOT NULL,
  lname varchar(40) NOT NULL,
  uname varchar(20) NOT NULL,
  telephone varchar(40) NOT NULL,
  email varchar(40) NOT NULL,
  password varchar(20) NOT NULL
);

use pay;
create table deliveryreq(
id int primary key auto_increment,
	cnic varchar(25) ,
	caddress varchar(25),
	cnumber varchar(25),
    cemail varchar(25),
	dldate varchar(25),
);


use pay;
create table item(
id int primary key auto_increment,
icode varchar(25),
iName varchar(25),
iCategory varchar(25),
iPrice varchar(25)
);






CREATE TABLE user (
id int NOT NULL,
username LONG DEFAULT NULL,
password LONG DEFAULT NULL ,
PRIMARY KEY (id));

CREATE TABLE Comments (
id int not NULL ,
description LONG DEFAULT NULL ,
postedby LONG DEFAULT NULL ,
deleted bool DEFAULT NULL ,
postedon DATE DEFAULT NULL ,
PRIMARY KEY (id)
);

CREATE TABLE products (
id int not NULL ,
name LONG DEFAULT NULL ,
description LONG DEFAULT NULL ,
cost int not NULL ,
imageurl LONG DEFAULT NULL ,
updatedon DATE DEFAULT NULL ,
PRIMARY KEY (id)
);

CREATE TABLE events (
id int not NULL ,
name LONG DEFAULT NULL ,
description LONG DEFAULT NULL ,
startdate DATE DEFAULT NULL ,
enddate DATE DEFAULT NULL ,
eventtime time DEFAULT NULL ,
location LONG DEFAULT NULL ,
city int not NULL ,
updatedon DATE DEFAULT NULL ,
PRIMARY KEY (id)
);

CREATE TABLE eventimages (
id int not NULL ,
eventid INT DEFAULT NULL ,
imageurl BLOB DEFAULT NULL ,
description LONG DEFAULT NULL ,
updatedon DATE DEFAULT NULL ,
PRIMARY KEY (id)
);

CREATE TABLE productenquiry(
id int not NULL ,
productid INT DEFAULT NULL ,
description LONG DEFAULT NULL ,
email LONG DEFAULT NULL ,
duedate DATE DEFAULT NULL ,
updatedon DATE DEFAULT NULL ,
phone INT4 DEFAULT NULL ,
PRIMARY KEY (id)
);

CREATE TABLE assets(
id int not NULL ,
category LONG DEFAULT NULL ,
description LONG DEFAULT NULL ,
url LONG DEFAULT NULL ,
uploadedby LONG DEFAULT NULL ,
updatedon DATE DEFAULT NULL ,
PRIMARY KEY (id)
);
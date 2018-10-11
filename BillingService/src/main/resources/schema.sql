DROP DATABASE IF EXISTS Gabesupermarket;
CREATE DATABASE IF NOT EXISTS Gabesupermarket;

DROP USER IF EXISTS 'gabe'@'localhost' ;

CREATE USER 'gabe'@'localhost' IDENTIFIED BY 'gabe';
GRANT ALL PRIVILEGES ON *.* TO 'gabe'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE Gabesupermarket;

create table product
(
  id BIGINT UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PRODUCTNAME varchar(100) not null,
  barcode varchar(100),
  description varchar(100),
  image varchar(100),
  units BIGINT,
  amount DECIMAL(20, 2),
  barcodeImage varchar(100)
);


create table invoice
(
  id BIGINT UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  client varchar(100) not null,
  vatrate BIGINT not null,
  invoicedate datetime not null,
  dueDate datetime not null,
  dateSent datetime,
  datePaid datetime,
  tax DECIMAL(20, 2),
  totalBalanceDue DECIMAL(20, 2),
  balanceDue DECIMAL(20, 2),
  amountPaid DECIMAL(20, 2),
  productID BIGINT,
  FOREIGN KEY (productID) REFERENCES product(ID) 
);



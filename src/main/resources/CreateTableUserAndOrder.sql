create TABLE if NOT EXISTS users(
id int (10) AUTO_INCREMENT,
firstname varchar(20) NOT NULL,
lastname varchar(20) NOT NULL,
email varchar(50) UNIQUE NOT NULL,
phone varchar(20) UNIQUE NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE orders
(
id int (10) AUTO_INCREMENT,
product varchar(20) NOT NULL,
price int NOT NULL,
userId int NOT NULL,
PRIMARY KEY (id),
CONSTRAINT orders_price_chk CHECK(price > 0),
FOREIGN KEY (userId)  REFERENCES users (Id) ON DELETE CASCADE
);

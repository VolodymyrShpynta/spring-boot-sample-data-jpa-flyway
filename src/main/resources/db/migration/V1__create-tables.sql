CREATE TABLE address (
  id     BIGINT      NOT NULL AUTO_INCREMENT,
  street VARCHAR(60) NOT NULL,
  phone  VARCHAR(40) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE employee (
  id          BIGINT      NOT NULL AUTO_INCREMENT,
  first_name  VARCHAR(60) NOT NULL,
  last_name   VARCHAR(40) NOT NULL,
  description VARCHAR(60) NOT NULL,
  address_id  BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE TABLE student (
  id         BIGINT      NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(60) NOT NULL,
  last_name  VARCHAR(40) NOT NULL,
  meta_data  VARCHAR(60) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE lecturer (
  id         BIGINT      NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(60) NOT NULL,
  last_name  VARCHAR(40) NOT NULL,
  meta_data  VARCHAR(60) NOT NULL,
  PRIMARY KEY (id)
);
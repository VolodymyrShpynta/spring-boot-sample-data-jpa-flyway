CREATE TABLE ADDRESS (
  ID     BIGINT      NOT NULL AUTO_INCREMENT,
  STREET VARCHAR(60) NOT NULL,
  PHONE  VARCHAR(40) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE EMPLOYEE (
  ID          BIGINT      NOT NULL AUTO_INCREMENT,
  FIRST_NAME  VARCHAR(60) NOT NULL,
  LAST_NAME   VARCHAR(40) NOT NULL,
  DESCRIPTION VARCHAR(60) NOT NULL,
  ADDRESS_ID  BIGINT,
  PRIMARY KEY (ID),
  FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID)
);

CREATE TABLE STUDENT (
  ID         BIGINT      NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR(60) NOT NULL,
  LAST_NAME  VARCHAR(40) NOT NULL,
  META_DATA  VARCHAR(60) NOT NULL,
  PRIMARY KEY (ID)
);
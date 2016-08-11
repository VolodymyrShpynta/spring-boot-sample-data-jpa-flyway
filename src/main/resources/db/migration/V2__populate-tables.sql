INSERT INTO ADDRESS (ID, STREET, PHONE) VALUES
  (1, 'Bozhenko', '044-111-11-11');

INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, DESCRIPTION, ADDRESS_ID) VALUES
  (1, 'Ivan', 'Ivanov', 'Ivan Ivanov is Java Dev.', 1),
  (2, 'Petro', 'Petrov', 'Petro Petrov is Scala Dev.', NULL);

INSERT INTO STUDENT (ID, FIRST_NAME, LAST_NAME, META_DATA) VALUES
  (1, 'Mike', 'Ivanov', 'Mike metadata'),
  (2, 'Bob', 'Petrov', 'Bob metadata');

INSERT INTO LECTURER (ID, FIRST_NAME, LAST_NAME, META_DATA) VALUES
  (1, 'Bill', 'Ivanov', 'Bill metadata'),
  (2, 'Frank', 'Petrov', 'Frank metadata');
INSERT INTO address (id, street, phone) VALUES
  (1, 'Bozhenko', '044-111-11-11');

INSERT INTO employee (id, first_name, last_name, description, address_id) VALUES
  (1, 'Ivan', 'Ivanov', 'Ivan Ivanov is Java Dev.', 1),
  (2, 'Petro', 'Petrov', 'Petro Petrov is Scala Dev.', NULL);

INSERT INTO student (id, first_name, last_name, meta_data) VALUES
  (1, 'Mike', 'Ivanov', 'Mike metadata'),
  (2, 'Bob', 'Petrov', 'Bob metadata');

INSERT INTO lecturer (id, first_name, last_name, meta_data) VALUES
  (1, 'Bill', 'Ivanov', 'Bill metadata'),
  (2, 'Frank', 'Petrov', 'Frank metadata');
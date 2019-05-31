INSERT INTO course(id, name, created_date, last_updated_date) 
VALUES (1001, 'Computer Science 101', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) 
VALUES (1002, 'Computer Science 102', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) 
VALUES (1003, 'Computer Science 103', sysdate(), sysdate());

INSERT INTO passport(id, number) VALUES (3001, 'N86823');
INSERT INTO passport(id, number) VALUES (3002, 'L930033');
INSERT INTO passport(id, number) VALUES (3003, 'Z906830');

-- INSERT INTO student(id, name) VALUES (2001, 'Harshit');
-- INSERT INTO student(id, name) VALUES (2002, 'James');
-- INSERT INTO student(id, name) VALUES (2003, 'Adam');

INSERT INTO student(id, name, passport_id) VALUES (2001, 'Harshit', 3001);
INSERT INTO student(id, name, passport_id) VALUES (2002, 'James', 3002);
INSERT INTO student(id, name, passport_id) VALUES (2003, 'Adam', 3003);

INSERT INTO reviews(id, rating, description) VALUES (4001, '4','Good course could be imporved');
INSERT INTO reviews(id, rating, description) VALUES (4002, '5', 'Very good course');
INSERT INTO reviews(id, rating, description) VALUES (4003, '3', 'Average course');
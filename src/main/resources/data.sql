--booking_status data
INSERT INTO booking_status (id, name) VALUES (1,'ACTIVE');
INSERT INTO booking_status (id, name) VALUES (2,'CANCELLED');
INSERT INTO booking_status (id, name) VALUES (3,'COMPLETED');

--room_status data
INSERT INTO room_status (id, name) VALUES (1,'OCCUPIED');
INSERT INTO room_status (id, name) VALUES (2,'AVAILABLE');
INSERT INTO room_status (id, name) VALUES (3,'UNDER_MAINTENANCE');

--room_type data
INSERT INTO room_type (id, name, rent_per_hour) VALUES (1,'SINGLE',7.5);
INSERT INTO room_type (id, name, rent_per_hour) VALUES (2,'DOUBLE',11);
INSERT INTO room_type (id, name, rent_per_hour) VALUES (3,'TWIN',13);
INSERT INTO room_type (id, name, rent_per_hour) VALUES (4,'KING',15);

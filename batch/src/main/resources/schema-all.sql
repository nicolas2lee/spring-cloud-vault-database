

CREATE TABLE if not exists people  (
                                       person_id serial NOT NULL PRIMARY KEY,
                                       first_name VARCHAR(20),
                                       last_name VARCHAR(20)
);
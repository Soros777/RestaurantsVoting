DELETE FROM dishes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO dishes (dish_name, price)
VALUES ('Omars', 150),
       ('Omlet', 35);

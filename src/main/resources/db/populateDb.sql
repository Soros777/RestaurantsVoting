DELETE FROM lunch_dishes;
DELETE FROM dishes;
DELETE FROM lunch_menus;
DELETE FROM restaurants;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO restaurants (name)
VALUES ('Okolica'),
       ('Dubrava'),
       ('Shaiba');

INSERT INTO dishes (dish_name, price)
VALUES ('Omars', 150),
       ('Omlet', 35),
       ('Biffshtex', 75),
       ('Olivie', 30),
       ('Borshch', 45),
       ('Porridge', 25);

INSERT INTO lunch_menus (restaurant_id)
VALUES (100000),
       (100001),
       (100002);

INSERT INTO lunch_dishes (lunch_id, dish_id)
VALUES (100009, 100003),
       (100009, 100004),
       (100010, 100005),
       (100010, 100006),
       (100011, 100007),
       (100011, 100008);

INSERT INTO users (voted_today)
VALUES (FALSE),
       (FALSE),
       (FALSE),
       (FALSE);

INSERT INTO user_roles (user_id, role)
VALUES (100012, 'ADMIN'),
       (100013, 'USER'),
       (100014, 'USER'),
       (100015, 'USER');

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

INSERT INTO lunch_menus (restaurant_id)
VALUES (100000),
       (100001),
       (100002);

INSERT INTO dishes (dish_name, price, LUNCH_MENU_ID)
VALUES ('Omars', 150, 100003),
       ('Omlet', 35, 100003),
       ('Biffshtex', 75, 100004),
       ('Olivie', 30, 100004),
       ('Borshch', 45, 100005),
       ('Porridge', 25, 100005);

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

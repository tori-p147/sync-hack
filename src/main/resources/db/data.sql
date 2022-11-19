DELETE
FROM users_client;
DELETE
FROM users_admin;
DELETE
FROM balance;
DELETE
FROM operation;
DELETE
FROM operation_type;

INSERT INTO users_client (USERNAME, EMAIL, PASSWORD, REGISTERED, ENABLED, VALIDATED)
VALUES ('user', 'user@gmail.com', '{noop}password', now(), true, false);

INSERT INTO users_admin (USERNAME, EMAIL, PASSWORD)
VALUES ('admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO balance (CLIENT_ID, CURRENCY, AMOUNT, LOCKED_AMOUNT)
VALUES (1, 'RUB', 1000, 0),
       (1, 'USD', 2000, 0);
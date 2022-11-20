DROP TABLE IF EXISTS balance;
DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS operation_type;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS USER_ROLE;



CREATE TABLE USER_ROLE
(
    role    VARCHAR PRIMARY KEY
);

CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)            NOT NULL,
    password   VARCHAR(255)            NOT NULL,
    enabled    BOOLEAN   DEFAULT FALSE NOT NULL,
    role       VARCHAR,
    FOREIGN KEY (role) REFERENCES USER_ROLE (role) ON DELETE CASCADE
);

CREATE UNIQUE INDEX users_unique_email_idx
    ON users (email);

CREATE TABLE balance
(
    id            BIGSERIAL PRIMARY KEY,
    client_id     INTEGER    NOT NULL,
    currency      VARCHAR(3) NOT NULL,
    amount        INTEGER,
    locked_amount INTEGER,
    CONSTRAINT user_balance_currency_unique UNIQUE (client_id, currency),
    FOREIGN KEY (client_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE operation
(
    id             BIGSERIAL PRIMARY KEY,
    client_id      INTEGER      NOT NULL,
    currency       VARCHAR(3)   NOT NULL,
    amount         INTEGER      NOT NULL,
    commission     INTEGER      NOT NULL,
    type           VARCHAR(255) NOT NULL,
    operation_time TIMESTAMP    NOT NULL
);

CREATE TABLE operation_type
(
    operation_id BIGSERIAL NOT NULL,
    type         VARCHAR(255),
    CONSTRAINT operation_type_unique UNIQUE (operation_id, type)
);

INSERT INTO USER_ROLE(ROLE)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO users (USERNAME, EMAIL, PASSWORD, ENABLED, ROLE)
VALUES ('user1', 'user1@gmail.com', '$2a$12$9tWrzyak6cuaEKc3M6jJ4e5TjzRn7.FjAzIK3yv5WqFt3P.oyOzEK', false, 'USER'),
       ('user2', 'user2@gmail.com', '$2a$12$9tWrzyak6cuaEKc3M6jJ4e5TjzRn7.FjAzIK3yv5WqFt3P.oyOzEK', true, 'USER'),
       ('admin', 'admin@gmail.com', '$2a$12$9tWrzyak6cuaEKc3M6jJ4e5TjzRn7.FjAzIK3yv5WqFt3P.oyOzEK', true, 'ADMIN');

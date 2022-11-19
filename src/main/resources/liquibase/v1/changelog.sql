--liquibaseformatted sql
--changeset 19112022-1813-changelog.sql

DROP TABLE IF EXISTS users_client;
DROP TABLE IF EXISTS users_admin;
DROP TABLE IF EXISTS balance;
DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS operation_type;

CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)            NOT NULL,
    password   VARCHAR(255)            NOT NULL,
    enabled    BOOLEAN   DEFAULT FALSE NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON users (email);

CREATE TABLE USER_ROLE
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_role_unique UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

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

INSERT INTO users (USERNAME, EMAIL, PASSWORD, ENABLED)
VALUES ('user1', 'user1@gmail.com', '{noop}password1', false),
       ('user2', 'user2@gmail.com', '{noop}password2', true),
       ('admin', 'admin@gmail.com', '{noop}admin', true);

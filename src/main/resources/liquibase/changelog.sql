--liquibaseformatted sql
--changeset 19112022-1813-changelog.sql

DROP TABLE IF EXISTS users_client;
DROP TABLE IF EXISTS users_admin;
DROP TABLE IF EXISTS balance;
DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS operation_type;

CREATE TABLE users_client
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)            NOT NULL,
    password   VARCHAR(255)            NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL,
    enabled    BOOLEAN   DEFAULT TRUE  NOT NULL,
    validated  BOOLEAN   DEFAULT FALSE NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON USERS_CLIENT (email);

CREATE TABLE users_admin
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX users_admin_unique_email_idx
    ON USERS_ADMIN (email);

CREATE TABLE balance
(
    id            BIGSERIAL PRIMARY KEY,
    client_id     INTEGER    NOT NULL,
    currency      VARCHAR(3) NOT NULL,
    amount        INTEGER,
    locked_amount INTEGER,
    CONSTRAINT user_balance_currency_unique UNIQUE (id, currency),
    FOREIGN KEY (client_id) REFERENCES USERS_CLIENT (id) ON DELETE CASCADE
);

CREATE TABLE operation
(
    id             BIGSERIAL PRIMARY KEY,
    client_id      INTEGER      NOT NULL,
    currency       VARCHAR(3)   NOT NULL,
    amount         INTEGER      NOT NULL,
    type           VARCHAR(255) NOT NULL,
    operation_time TIMESTAMP    NOT NULL
);

CREATE TABLE operation_type
(
    operation_id BIGSERIAL NOT NULL,
    type         VARCHAR(255),
    CONSTRAINT operation_type_unique UNIQUE (operation_id, type)
);

INSERT INTO users_client (USERNAME, EMAIL, PASSWORD, REGISTERED, ENABLED, VALIDATED)
VALUES ('user', 'user@gmail.com', '{noop}password', now(), true, false);

INSERT INTO users_admin (USERNAME, EMAIL, PASSWORD)
VALUES ('admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO balance (CLIENT_ID, CURRENCY, AMOUNT, LOCKED_AMOUNT)
VALUES (1, 'RUB', 1000, 0),
       (1, 'USD', 2000, 0);
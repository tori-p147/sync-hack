DROP TABLE IF EXISTS users_client;
DROP TABLE IF EXISTS users_admin;
DROP TABLE IF EXISTS balance;
DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS operation_type;

CREATE TABLE users_client
(
    id         SERIAL PRIMARY KEY,
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
    id       SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX users_admin_unique_email_idx
    ON USERS_ADMIN (email);


CREATE TABLE balance
(
    id            SERIAL PRIMARY KEY,
    client_id     INTEGER    NOT NULL,
    currency      VARCHAR(3) NOT NULL,
    amount        INTEGER,
    locked_amount INTEGER,
    CONSTRAINT user_balance_currency_unique UNIQUE (id, currency),
    FOREIGN KEY (client_id) REFERENCES USERS_CLIENT (id) ON DELETE CASCADE
);

CREATE TABLE operation
(
    id             SERIAL PRIMARY KEY,
    client_id      INTEGER      NOT NULL,
    currency       VARCHAR(3)   NOT NULL,
    amount         INTEGER      NOT NULL,
    type           VARCHAR(255) NOT NULL,
    operation_time TIMESTAMP    NOT NULL
);

CREATE TABLE operation_type
(
    operation_id INTEGER NOT NULL,
    type         VARCHAR(255),
    CONSTRAINT operation_type_unique UNIQUE (operation_id, type)
);


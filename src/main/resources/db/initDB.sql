DROP TABLE IF EXISTS user_roles;

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

CREATE TABLE active_balance
(
    id        SERIAL PRIMARY KEY,
    client_id INTEGER    NOT NULL,
    currency  VARCHAR(3) NOT NULL,
    amount    INTEGER,
    CONSTRAINT user_account_unique UNIQUE (id, client_id),
    FOREIGN KEY (client_id) REFERENCES USERS_CLIENT (id) ON DELETE CASCADE
);

CREATE TABLE locked_balance
(
    id        SERIAL PRIMARY KEY,
    client_id INTEGER    NOT NULL,
    currency  VARCHAR(3) NOT NULL,
    amount    INTEGER,
    CONSTRAINT user_locked_balance_unique UNIQUE (id, client_id),
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

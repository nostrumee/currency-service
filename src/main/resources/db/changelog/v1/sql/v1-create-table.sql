CREATE TABLE currencies
(
    id   BIGINT PRIMARY KEY,
    date DATE       NOT NULL,
    code VARCHAR(3) NOT NULL,
    rate FLOAT      NOT NULL
);

CREATE SEQUENCE primary_key_seq START WITH 1 INCREMENT BY 1;

CREATE INDEX code_date_idx ON currencies(code, date);
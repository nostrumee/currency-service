CREATE TABLE currencies
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE       NOT NULL,
    code VARCHAR(3) NOT NULL,
    rate NUMERIC    NOT NULL
);
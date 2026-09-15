CREATE TABLE IF NOT EXISTS car
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NOT NULL,
    model      VARCHAR(255)          NULL,
    color      VARCHAR(255)          NULL,
    driver_id  BIGINT                NULL,
    CONSTRAINT pk_car PRIMARY KEY (id),
    CONSTRAINT FK_CAR_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id)
);
ALTER TABLE booking
DROP
FOREIGN KEY FKei2mjigb4hb2sm4htt6jhwn6;

CREATE TABLE car
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime NOT NULL,
    updateat      datetime NOT NULL,
    plate_numberr VARCHAR(255) NULL,
    color_id      BIGINT NULL,
    brand         VARCHAR(255) NULL,
    model         VARCHAR(255) NULL,
    car_type      VARCHAR(255) NULL,
    driver_id     BIGINT NULL,
    CONSTRAINT pk_car PRIMARY KEY (id)
);

CREATE TABLE color
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime     NOT NULL,
    updateat   datetime     NOT NULL,
    name       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_color PRIMARY KEY (id)
);

CREATE TABLE exact_location
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NOT NULL,
    updateat   datetime NOT NULL,
    latitude DOUBLE NULL,
    longitude DOUBLE NULL,
    CONSTRAINT pk_exactlocation PRIMARY KEY (id)
);

CREATE TABLE named_location
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    created_at        datetime NOT NULL,
    updateat          datetime NOT NULL,
    exact_location_id BIGINT NULL,
    name              VARCHAR(255) NULL,
    city              VARCHAR(255) NULL,
    zip_code          VARCHAR(255) NULL,
    country           VARCHAR(255) NULL,
    state             VARCHAR(255) NULL,
    CONSTRAINT pk_namedlocation PRIMARY KEY (id)
);

CREATE TABLE otp
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_at   datetime NOT NULL,
    updateat     datetime NOT NULL,
    code         VARCHAR(255) NULL,
    senttonumber VARCHAR(255) NULL,
    CONSTRAINT pk_otp PRIMARY KEY (id)
);

CREATE TABLE passenger_review
(
    id                       BIGINT NOT NULL,
    passenger_review_content VARCHAR(255) NULL,
    passenger_ratting        VARCHAR(255) NULL,
    CONSTRAINT pk_passengerreview PRIMARY KEY (id)
);

ALTER TABLE driver
    ADD aadhar_number VARCHAR(255) NULL;

ALTER TABLE driver
    ADD driver_approval_status VARCHAR(255) NULL;

ALTER TABLE driver
    ADD email VARCHAR(255) NULL;

ALTER TABLE driver
    ADD is_available BIT(1) NULL;

ALTER TABLE driver
    ADD last_location_id BIGINT NULL;

ALTER TABLE passenger
    ADD active_booking_id BIGINT NULL;

ALTER TABLE passenger
    ADD home_location_id BIGINT NULL;

ALTER TABLE passenger
    ADD last_known_location_id BIGINT NULL;

ALTER TABLE passenger
    ADD rating DOUBLE NULL;

ALTER TABLE booking
    ADD end_location_id BIGINT NULL;

ALTER TABLE booking
    ADD start_location_id BIGINT NULL;

ALTER TABLE driver
    MODIFY is_available BIT (1) NOT NULL;

ALTER TABLE passenger
    MODIFY rating DOUBLE NOT NULL;

ALTER TABLE booking
    ADD CONSTRAINT uc_booking_end_location UNIQUE (end_location_id);

ALTER TABLE booking
    ADD CONSTRAINT uc_booking_start_location UNIQUE (start_location_id);

ALTER TABLE color
    ADD CONSTRAINT uc_color_name UNIQUE (name);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_END_LOCATION FOREIGN KEY (end_location_id) REFERENCES exact_location (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_START_LOCATION FOREIGN KEY (start_location_id) REFERENCES exact_location (id);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_COLOR FOREIGN KEY (color_id) REFERENCES color (id);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_LASTLOCATION FOREIGN KEY (last_location_id) REFERENCES exact_location (id);

ALTER TABLE named_location
    ADD CONSTRAINT FK_NAMEDLOCATION_ON_EXACTLOCATION FOREIGN KEY (exact_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES bookingreview (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_ACTIVEBOOKING FOREIGN KEY (active_booking_id) REFERENCES booking (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_HOMELOCATION FOREIGN KEY (home_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_LASTKNOWNLOCATION FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);

DROP TABLE booking_review;

ALTER TABLE driver
DROP
COLUMN address;

ALTER TABLE driver
DROP
COLUMN license_number;

ALTER TABLE driver
DROP
COLUMN phone_number;

ALTER TABLE driver
DROP
COLUMN updated_at;

ALTER TABLE booking
DROP
COLUMN getupdated_at;

ALTER TABLE booking
DROP
COLUMN review_id;

ALTER TABLE booking
DROP
COLUMN booking_status;

ALTER TABLE bookingreview
DROP
COLUMN getupdated_at;

ALTER TABLE passenger
DROP
COLUMN getupdated_at;

ALTER TABLE booking
    ADD booking_status VARCHAR(255) NULL;

ALTER TABLE passenger
    MODIFY email VARCHAR (255);

ALTER TABLE passenger
    MODIFY mobile_number VARCHAR (255) NOT NULL;
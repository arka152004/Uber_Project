-- Restructure review tables to match JPA JOINED inheritance model

-- Create parent review table (maps to Review entity with @Table(name="bookingreview"))
CREATE TABLE IF NOT EXISTS bookingreview
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    update_at  datetime              NOT NULL,
    content    VARCHAR(255)          NOT NULL,
    rating     DOUBLE                NULL,
    booking_id BIGINT                NULL,
    CONSTRAINT pk_bookingreview PRIMARY KEY (id),
    CONSTRAINT FK_BOOKINGREVIEW_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id)
);

-- Create child table for PassengerReview (JOINED inheritance)
CREATE TABLE IF NOT EXISTS passenger_review
(
    id                       BIGINT NOT NULL,
    passenger_review_content VARCHAR(255) NULL,
    passenger_ratting        VARCHAR(255) NULL,
    CONSTRAINT pk_passenger_review PRIMARY KEY (id),
    CONSTRAINT FK_PASSENGER_REVIEW_ON_BOOKINGREVIEW FOREIGN KEY (id) REFERENCES bookingreview (id)
);
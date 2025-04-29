CREATE TABLE Events (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        description TEXT,
        start_of_the_event TIMESTAMP NOT NULL,
        end_of_event TIMESTAMP NOT NULL,
        identifier VARCHAR(255) NOT NULL UNIQUE,
        capacity INTEGER NOT NULL,
        event_location VARCHAR(255) NOT NULL,
        organizer VARCHAR(255) NOT NULL,
        event_type VARCHAR(255) NOT NULL
)
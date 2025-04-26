CREATE TABLE Events (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        description VARCHAR(255),
        start_of_the_event DATE,
        end_of_event DATE,
        identifier VARCHAR(255),
        capacity INTEGER,
        local VARCHAR(255),
        organizer VARCHAR(255),
        event_type VARCHAR(255)

)
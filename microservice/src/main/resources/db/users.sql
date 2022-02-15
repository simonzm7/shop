CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    country_id TEXT NOT NULL,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    unique(country_id)
);

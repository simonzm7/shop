CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    country_id TEXT NOT NULL,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    unique(country_id)
);

CREATE TYPE product_category AS ENUM ('ELECTRONICS', 'VIDEO_GAMES', 'FASHION');

CREATE TABLE products(
    id BIGSERIAL PRIMARY KEY,
    product_name TEXT NOT NULL,
    description TEXT NOT NULL,
    product_category TEXT NOT NULL,
    product_image_url TEXT NOT NULL,
    product_stock INTEGER NOT NULL,
    product_discount INTEGER NOT NULL,
    user_id  BIGINT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id)
);
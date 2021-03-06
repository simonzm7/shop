CREATE TABLE balance(
    id BIGSERIAL PRIMARY KEY,
    total_balance DECIMAL NOT NULL DEFAULT 0.0,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id)
);
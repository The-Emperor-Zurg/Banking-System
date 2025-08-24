CREATE TABLE banks (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) NOT NULL UNIQUE,
    debit_percent DECIMAL(5, 2) NOT NULL,
    credit_limit DECIMAL(15, 2) NOT NULL,
    credit_fee DECIMAL(15, 2) NOT NULL,
    suspicious_limit DECIMAL(15, 2) NOT NULL
);

CREATE TABLE central_bank_deposit_rates (
    id SERIAL PRIMARY KEY,
    upper_limit INTEGER NOT NULL,
    percentage DECIMAL(5, 2) NOT NULL,
    order_index INTEGER NOT NULL
);

CREATE TABLE deposit_interest_rates (
    id SERIAL PRIMARY KEY,
    bank_id INTEGER NOT NULL,
    upper_limit INTEGER NOT NULL,
    percentage DECIMAL(5, 2) NOT NULL,
    order_index INTEGER NOT NULL,

    FOREIGN KEY (bank_id) REFERENCES banks(id)
);

CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    passport INTEGER,
    address TEXT
);

CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    client_id INTEGER NOT NULL,
    bank_id INTEGER NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL DEFAULT 0,
    interest_on_balance DECIMAL(15, 2),             -- NULL для CREDIT
    days_counter INTEGER,                           -- NULL для CREDIT
    previous_check_day DATE,                        -- NULL для CREDIT
    deposit_end_date DATE,                          -- только для DEPOSIT
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (bank_id) REFERENCES banks(id)
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    transaction_type VARCHAR(20) NOT NULL,                    -- discriminator: ADD_MONEY, WITHDRAW_MONEY, TRANSFER
    sender_account_id INTEGER,
    receiver_account_id INTEGER,
    amount DECIMAL(15, 2) NOT NULL,
    status VARCHAR(20) DEFAULT 'COMPLETED',                   -- COMPLETED, CANCELLED

    FOREIGN KEY (sender_account_id) REFERENCES accounts(id),
    FOREIGN KEY (receiver_account_id) REFERENCES accounts(id)
);
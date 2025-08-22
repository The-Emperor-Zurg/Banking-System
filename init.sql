CREATE TABLE banks (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) NOT NULL UNIQUE,
    debit_percent DECIMAL(5, 2) NOT NULL,
    credit_limit DECIMAL(15, 2) NOT NULL,
    credit_fee DECIMAL(15, 2) NOT NULL,
    suspicious_limit DECIMAL(15, 2) NOT NULL CHECK (suspicious_limit >= 0)
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
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (bank_id) REFERENCES banks(id)
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    transaction_type VARCHAR(20) NOT NULL,
    sender_account_id INTEGER,
    receiver_account_id INTEGER,
    amount DECIMAL(15, 2) NOT NULL,
    status VARCHAR(20) DEFAULT 'COMPLETED',
    FOREIGN KEY (sender_account_id) REFERENCES accounts(id),
    FOREIGN KEY (receiver_account_id) REFERENCES accounts(id)
);
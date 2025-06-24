CREATE TABLE public.users (
    id                  SERIAL PRIMARY KEY,
    firstname           VARCHAR(100) NOT NULL,
    lastname            VARCHAR(100) NOT NULL,
    username            VARCHAR(50) NOT NULL UNIQUE,
    email               VARCHAR(150) NOT NULL UNIQUE,
    password            VARCHAR(255) NOT NULL,
    phone_number        VARCHAR(20),

    profile_image       TEXT,
    company_name        VARCHAR(150),
    country             VARCHAR(100),
    city                VARCHAR(100),
    address             TEXT,

    enabled             BOOLEAN NOT NULL DEFAULT true,
    is_verified         BOOLEAN NOT NULL DEFAULT false,

    reset_token         VARCHAR(255),
    reset_token_expiry  TIMESTAMP,

    last_login_at       TIMESTAMP,
    login_count         INTEGER DEFAULT 0,

    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE public.user_roles (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE public.languages (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE public.user_languages (
    user_id INTEGER NOT NULL,
    language_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, language_id)
);

CREATE TABLE public.currencies (
    code VARCHAR(5) PRIMARY KEY,
    symbol VARCHAR(5),
    name VARCHAR(50)
);

CREATE TABLE public.user_currencies (
    user_id INTEGER NOT NULL,
    currency_code VARCHAR(5) NOT NULL,
    PRIMARY KEY (user_id, currency_code)
);

CREATE TABLE public.user_registration_logs (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    ip_address VARCHAR(45),
    user_agent TEXT,
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.user_email_verifications (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    verification_token VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    verified_at TIMESTAMP,
    is_expired BOOLEAN NOT NULL DEFAULT false
);


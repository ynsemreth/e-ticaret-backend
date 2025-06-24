ALTER TABLE public.user_languages
    ALTER COLUMN user_id TYPE BIGINT,
    ALTER COLUMN language_id TYPE BIGINT;

ALTER TABLE public.user_currencies
    ALTER COLUMN user_id TYPE BIGINT,
    ALTER COLUMN currency_code TYPE VARCHAR(10);
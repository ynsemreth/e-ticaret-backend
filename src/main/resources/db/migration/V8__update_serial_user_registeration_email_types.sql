ALTER TABLE public.user_email_verifications
    ALTER COLUMN user_id TYPE BIGINT;

ALTER TABLE public.user_registration_logs
    ALTER COLUMN user_id TYPE BIGINT;

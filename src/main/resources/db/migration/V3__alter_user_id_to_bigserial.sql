
ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;

ALTER TABLE public.users ALTER COLUMN id TYPE BIGINT;

CREATE SEQUENCE IF NOT EXISTS public.users_id_seq;

ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('users_id_seq');
ALTER SEQUENCE users_id_seq OWNED BY users.id;
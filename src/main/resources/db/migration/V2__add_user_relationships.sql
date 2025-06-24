ALTER TABLE public.user_roles
    ADD CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;

ALTER TABLE public.user_roles
    ADD CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES public.roles(id) ON DELETE CASCADE;

ALTER TABLE public.user_languages
    ADD CONSTRAINT fk_user_languages_user FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;

ALTER TABLE public.user_languages
    ADD CONSTRAINT fk_user_languages_lang FOREIGN KEY (language_id) REFERENCES public.languages(id) ON DELETE CASCADE;

ALTER TABLE public.user_currencies
    ADD CONSTRAINT fk_user_currencies_user FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;

ALTER TABLE public.user_currencies
    ADD CONSTRAINT fk_user_currencies_code FOREIGN KEY (currency_code) REFERENCES public.currencies(code) ON DELETE CASCADE;

ALTER TABLE public.user_registration_logs
    ADD CONSTRAINT fk_user_registration_logs_user FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;

ALTER TABLE public.user_email_verifications
    ADD CONSTRAINT fk_user_email_verifications_user FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;
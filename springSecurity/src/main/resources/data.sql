INSERT INTO public.users(userid,username,email,password,enabled)VALUES (1,'jack','abc@abc.com','jack', 1);
INSERT INTO public.user_roles (user_role_id,userid, role)VALUES (1,1, 'ROLE_USER');
INSERT INTO public.users(userid,username,email,password,enabled)VALUES (2,'peter','abc@abc.com','peter', 1);
INSERT INTO public.user_roles (user_role_id,userid, role)VALUES (2,2, 'ROLE_USER');
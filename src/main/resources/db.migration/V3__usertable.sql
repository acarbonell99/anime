CREATE TABLE usser (
    userid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    username varchar(24) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role varchar(10),
    enabled boolean DEFAULT true
  );

CREATE EXTENSION IF NOT EXISTS pgcrypto;
    INSERT INTO usser (username, password) VALUES ('user01', crypt('user01', gen_salt('bf')));
CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES ('user01', crypt('pass', gen_salt('bf')));

INSERT INTO anime(name, description, type, year, imageurl) VALUES
    ('One Piece','Pirates infinity series', 'TV dairy', 1998, 'movie1.jpg'),
    ('Konosuba','Sex, Gags, Iseakai','TV', 2010, 'movie2.jpg'),
    ('Mushishi','Folklore japanesse','TV', 2020, 'movie3.jpg'),
    ('Dororo','Mutilated Sacred Tradition', 'TV', 2000, 'movie4.jpg');

INSERT INTO genre(label, imageurl) values
    ('patata', 'patata.jpg');

INSERT INTO favorite values(
(SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT userid FROM usser WHERE username= 'user01')
);


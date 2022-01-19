CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES ('user01', crypt('pass', gen_salt('bf')));

INSERT INTO anime(name, description, type, year, imageurl) VALUES
    ('One Piece','Pirates infinity series', 'TV dairy', 1998, 'movie1.jpg'),
    ('Shingeki no Kyojin','Titan', 'TV dairy', 2013, 'movie2.jpg');


INSERT INTO genre(label, imageurl) values
    ('Acción', 'Acción.jpg'),
    ('Fantasía', 'fantasia.jpg'),
    ('Aventura', 'aventura.jpg');

INSERT INTO author(name, imageurl) values
    ('Eiichirō Oda', 'imgOda.jpg'),
    ('Hajime Isayama', 'imgHajime.jpg');

INSERT INTO anime_author values
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT authorid FROM author WHERE name = 'Eiichirō Oda')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT authorid FROM author WHERE name = 'Hajime Isayama'));

INSERT INTO anime_genre values
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT genreid FROM genre WHERE label = 'Acción')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT genreid FROM genre WHERE label = 'Fantasía')),
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT genreid FROM genre WHERE label = 'Fantasía')),
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT genreid FROM genre WHERE label = 'Aventura'));


INSERT INTO favorite values(
(SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT userid FROM usser WHERE username= 'user01')
);


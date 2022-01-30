CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES
    ('user01', crypt('pass', gen_salt('bf'))),
    ('user02', crypt('pass', gen_salt('bf'))),
    ('user03', crypt('pass', gen_salt('bf'))),
    ('user04', crypt('pass', gen_salt('bf')));

INSERT INTO anime(name, description, type, year, imageurl) VALUES
    ('One Piece','Pirates infinity series', 'TV dairy', 1998, 'anime1.jpg'),
    ('Shingeki no Kyojin','Titan', 'TV dairy', 2013, 'anime2.jpg'),
    ('Dragon Ball','Saiyajin', 'TV dairy', 1984, 'anime4.jpg'),
    ('Tengen Toppa Gurren Lagann','Taladros', 'TV dairy', 2007, 'anime3.jpg');


INSERT INTO genre(label, imageurl) values
    ('Acción', 'Acción.jpg'),
    ('Fantasía', 'fantasia.jpg'),
    ('Aventura', 'aventura.jpg');

INSERT INTO author(name, imageurl) values
    ('Eiichirō Oda', 'imgOda.jpg'),
    ('Hajime Isayama', 'imgHajime.jpg'),
    ('Akira Toriyama', 'akiratoriyama.jpg'),
    ('Hiroyuki Imaishi', 'hiroyuki.jpg');

INSERT INTO anime_author values
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT authorid FROM author WHERE name = 'Eiichirō Oda')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT authorid FROM author WHERE name = 'Hajime Isayama')),
    ((SELECT animeid FROM anime WHERE name = 'Dragon Ball'), (SELECT authorid FROM author WHERE name = 'Akira Toriyama')),
    ((SELECT animeid FROM anime WHERE name = 'Tengen Toppa Gurren Lagann'), (SELECT authorid FROM author WHERE name = 'Hiroyuki Imaishi'));

INSERT INTO anime_genre values
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT genreid FROM genre WHERE label = 'Acción')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT genreid FROM genre WHERE label = 'Fantasía')),
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT genreid FROM genre WHERE label = 'Fantasía')),
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT genreid FROM genre WHERE label = 'Aventura')),
    ((SELECT animeid FROM anime WHERE name = 'Dragon Ball'), (SELECT genreid FROM genre WHERE label = 'Aventura')),
    ((SELECT animeid FROM anime WHERE name = 'Dragon Ball'), (SELECT genreid FROM genre WHERE label = 'Fantasía')),
    ((SELECT animeid FROM anime WHERE name = 'Dragon Ball'), (SELECT genreid FROM genre WHERE label = 'Acción')),
    ((SELECT animeid FROM anime WHERE name = 'Tengen Toppa Gurren Lagann'), (SELECT genreid FROM genre WHERE label = 'Aventura')),
    ((SELECT animeid FROM anime WHERE name = 'Tengen Toppa Gurren Lagann'), (SELECT genreid FROM genre WHERE label = 'Fantasía'));


INSERT INTO favorite values
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT userid FROM usser WHERE username= 'user01')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT userid FROM usser WHERE username= 'user01')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT userid FROM usser WHERE username= 'user02')),
    ((SELECT animeid FROM anime WHERE name = 'Tengen Toppa Gurren Lagann'), (SELECT userid FROM usser WHERE username= 'user04'));

INSERT INTO following values
    ((SELECT userid FROM usser WHERE username= 'user01'), (SELECT userid FROM usser WHERE username= 'user02')),
    ((SELECT userid FROM usser WHERE username= 'user01'), (SELECT userid FROM usser WHERE username= 'user03')),
    ((SELECT userid FROM usser WHERE username= 'user02'), (SELECT userid FROM usser WHERE username= 'user04'));

INSERT INTO grup(grupname) values
    ('grup1'),
    ('grup2'),
    ('grup3');

INSERT INTO user_grup values
    ((SELECT grupid FROM grup WHERE grupname= 'grup1'), (SELECT userid FROM usser WHERE username= 'user01')),
    ((SELECT grupid FROM grup WHERE grupname= 'grup1'), (SELECT userid FROM usser WHERE username= 'user02')),
    ((SELECT grupid FROM grup WHERE grupname= 'grup2'), (SELECT userid FROM usser WHERE username= 'user03')),
    ((SELECT grupid FROM grup WHERE grupname= 'grup2'), (SELECT userid FROM usser WHERE username= 'user04')),
    ((SELECT grupid FROM grup WHERE grupname= 'grup3'), (SELECT userid FROM usser WHERE username= 'user04')),
    ((SELECT grupid FROM grup WHERE grupname= 'grup3'), (SELECT userid FROM usser WHERE username= 'user01'));

INSERT INTO image_group (imgtext) VALUES
( 'imageOne2.png' ),
( 'imageOne3.png' ),
( 'imageOne4.png' ),
( 'imageShingeki1.png' ),
( 'imageShingeki2.png' ),
( 'imageDragon1.png' ),
( 'imageDragon2.png' ),
( 'imageDragon3.png' );

INSERT INTO image_anime values
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT imgid FROM image_group WHERE imgtext = 'imageOne2.png')),
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT imgid FROM image_group WHERE imgtext = 'imageOne3.png')),
    ((SELECT animeid FROM anime WHERE name = 'One Piece'), (SELECT imgid FROM image_group WHERE imgtext = 'imageOne4.png')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT imgid FROM image_group WHERE imgtext = 'imageShingeki1.png')),
    ((SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin'), (SELECT imgid FROM image_group WHERE imgtext = 'imageShingeki2.png'));


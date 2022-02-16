CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES
    ('user01', crypt('pass', gen_salt('bf'))),
    ('user02', crypt('pass', gen_salt('bf'))),
    ('user03', crypt('pass', gen_salt('bf'))),
    ('user04', crypt('pass', gen_salt('bf')));

INSERT INTO anime(name, description, type, year, imageurl) VALUES
    ('One Piece','Esta serie relata las aventuras y desventuras de uno de esos piratas, Monkey D. Luffy, quien accidentalmente de pequeño, comió una Fruta del Diablo (Akuma no Mi en japonés), en particular una Gomu Gomu no Mi que hizo que su cuerpo ganara las propiedades físicas de la goma, convirtiéndose en el hombre de goma. Luffy, después de dicho suceso, decide que se convertirá en el próximo Rey de los Piratas y para ello, deberá encontrar el "One Piece"', 'Serie de TV', 1999, 'https://pics.filmaffinity.com/wan_pisu_one_piece_tv_series-830418147-mmed.jpg'),
    ('Shingeki no Kyojin','Serie basada en el manga del mismo nombre, dirigida por Tetsuro Araki y protagonizada por un grupo de residentes de una ciudad rodeada de murallas, las cuales sirven para proteger a la población de los ataques de gigantes caníbales, quienes de vez en cuando consiguen entrar en el lugar.', 'Serie de TV', 2013, 'https://pics.filmaffinity.com/shingeki_no_kyojin_attack_on_titan_tv_series-890399004-mmed.jpg'),
    ('Dragon Ball','Dragon Ball narra la historia de Goku, un excepcional niño que llegó a la Tierra en una cápsula durante una noche tormentosa. Sin saber nada de su pasado, un anciano lo cuidó como su nieto hasta los ocho años. Después de morir su abuelo, Goku accede a la Kame House, lugar donde un estrambótico anciano le convertirá en un campeón de artes marciales. Conocerá por el camino a Bulma, una muchacha obsesionada con algo denominado las Bolas de Dragón, y Krilin, su compañero de aventuras, entre otros...', 'Serie de TV', 1986, 'https://pics.filmaffinity.com/doragon_boru_dragon_ball_tv_series-973171538-mmed.jpg'),
    ('Tengen Toppa Gurren Lagann','El pueblo de Jiiha es uno de los tantos pueblos subterráneos que hay en el mundo. Muchos de sus habitantes se dedican a excavar con sus taladros, expandiendo horizontalmente el territorio del pueblo, ya que desde hace mucho tiempo, existe una prohibición por la cual nadie puede subir a la "superficie". Simon es uno de esos excavadores que, un día, mientras realiza su trabajo, descubre algo excepcional que le conducirá a vivir una nueva vida más allá de Jiiha. Animado por su compañero Kamina, se despedirán para siempre de su pueblo natal y descubrirán un mundo nuevo donde el único límite que existe por encima de ellos es el gran cielo azul.', 'Serie de TV', 2007, 'https://pics.filmaffinity.com/tengen_toppa_gurren_lagann_maiking_break_through_gurren_lagann_tv_series-125771804-mmed.jpg');


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


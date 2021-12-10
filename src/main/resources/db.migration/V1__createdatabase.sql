CREATE TABLE IF NOT EXISTS anime (
	animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMERY KEY,
	name text,
	description text,
	type text,
	year integer,
	imegeurl text);

CREATE TABLE IF NOT EXISTS autor (
    autorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    imageurl text);

CREATE TABLE IF NOT EXISTS genre (
    genreid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    label text,
    imageurl text);

CREATE TABLE anime_autor (
    movieid uuid REFERENCES movie(movieid) ON DELETE CASCADE,
    autorid uuid REFERENCES autor(autorid) ON DELETE CASCADE,
    PRIMARY KEY (movieid, autorid));

CREATE TABLE genre (
    movieid uuid REFERENCES movie(movieid) ON DELETE CASCADE,
    genreid uuid REFERENCES genre(genreid) ON DELETE CASCADE,
    PRIMARY KEY (movieid, genreid));

INSERT INTO animes(name, description, type, year, imegeurl) VALUES
    ('One Piece','Pirates infinity series', “TV dairy”,1998, 'movie1.jpg'),
    ('Konosuba','Sex, Gags, Iseakai',“TV”, 2010, 'movie2.jpg'),
    ('Mushishi','Folklore japanesse',“TV”, 2020, 'movie3.jpg'),
    ('Dororo','Mutilated Sacred Tradition', “TV”, 2000, 'movie4.jpg');
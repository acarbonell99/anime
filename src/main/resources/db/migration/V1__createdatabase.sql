
CREATE TABLE IF NOT EXISTS anime (
	animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	name text,
	description text,
	type text,
	year integer,
	imageurl text);

CREATE TABLE  author (
    authorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    imageurl text);

CREATE TABLE genre (
    genreid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    label text,
    imageurl text);

CREATE TABLE anime_autor (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    authorid uuid REFERENCES author(authorid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, authorid));

CREATE TABLE genre_anime (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    genreid uuid REFERENCES genre(genreid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, genreid));

CREATE TABLE usser (
  userid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  username varchar(24) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  role varchar(10),
  enabled boolean DEFAULT true);

CREATE TABLE favorite (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    userid uuid REFERENCES usser(userid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, userid));

CREATE TABLE file (
    fileid UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    contenttype TEXT,
    data bytea);



CREATE TABLE IF NOT EXISTS anime (
	animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	name text,
	description text,
	type text,
	year integer,
	imageurl text,
	video text
	);

CREATE TABLE  author (
    authorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    imageurl text);

CREATE TABLE genre (
    genreid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    label text,
    imageurl text);

CREATE TABLE anime_author (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    authorid uuid REFERENCES author(authorid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, authorid));

CREATE TABLE anime_genre (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    genreid uuid REFERENCES genre(genreid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, genreid));

CREATE TABLE usser (
  userid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  username varchar(24) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  email varchar,
  phone integer,
  role varchar(10),
  enabled boolean DEFAULT true);

CREATE TABLE favorite (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    userid uuid REFERENCES usser(userid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, userid));

CREATE TABLE following (
    userid uuid REFERENCES usser(userid) ON DELETE CASCADE,
    useridfollowed uuid REFERENCES usser(userid) ON DELETE CASCADE,
    PRIMARY KEY (userid, useridfollowed));

CREATE TABLE file (
    fileid UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    contenttype TEXT,
    data bytea);

CREATE TABLE grup(
    grupid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    grupname text NOT NULL);

CREATE TABLE user_grup(
    grupid uuid REFERENCES grup(grupid) ON DELETE CASCADE,
    userid uuid REFERENCES usser(userid) ON DELETE CASCADE,
    PRIMARY KEY (grupid, userid));


CREATE TABLE image_group(
    imgid uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    imgtext text);

CREATE TABLE image_anime(
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    imgid uuid REFERENCES image_group(imgid) ON DELETE CASCADE,
    PRIMARY KEY (animeid,imgid)
);



--CREATE TABLE anime_video(
--    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
--    videoid uuid NOT NULL DEFAULT gen_random_uuid(),
--    episode integer,
--    url text,
--    PRIMARY KEY (animeid,videoid));

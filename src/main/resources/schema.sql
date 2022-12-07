create table Director (
director_id int primary key,
firstName varchar(30),
lastName varchar(30),
stillActive boolean
);

create table movies (
    movie_id int PRIMARY KEY,
    title VARCHAR(30),
    yearReleased smallint,
    taking float,
    director_id int,
    foreign key (director_id) references Director(director_id) on delete cascade
);

create table users(
	id int not null primary key,
    login varchar(150) not null,
    password varchar(150) not null
);

create table user_authorities(
	id int not null primary key,
    role varchar(50) not null,

    user_id int
);
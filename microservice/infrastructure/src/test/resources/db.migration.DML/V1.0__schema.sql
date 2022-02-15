create table users (
 id int(11) not null auto_increment,
 country_id int(10) not null,
 name varchar(100) not null,
 email varchar(45) not null,
 password varchar(60) not null,
 primary key (id),
 unique(country_id)
);
create table users (
 id int(11) not null auto_increment,
 country_id int(10) not null,
 name varchar(100) not null,
 email varchar(45) not null,
 password varchar(60) not null,
 primary key (id),
 unique(country_id)
);

CREATE TABLE products(
    id int(11) not null auto_increment,
    product_name varchar(100) NOT NULL,
    description varchar(200) NOT NULL,
    product_category varchar(15) NOT NULL,
    product_image_url varchar(50) NOT NULL,
    product_stock int(5) NOT NULL,
    product_discount int(3) NOT NULL,
    user_id  int(11) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key (id)
);
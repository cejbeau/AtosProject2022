CREATE DATABASE gameshop_ims;
use gameshop_ims;
create table product_inventory(
id int not null unique auto_increment,
game_name varchar(150) not null,
game_description varchar(250) default "no description at this time",
price decimal(6,2) not null,
Primary key(id));

Select * from product_inventory;
insert into product_inventory(game_name, game_description, price) Values("The Last of Us", default, 24.99);
insert into product_inventory(game_name, game_description, price) Values("Horizon Zero Dawn", default, 16.99);
insert into product_inventory(game_name, game_description, price) Values("Animal Crossing New Horizons", default, 34.99);

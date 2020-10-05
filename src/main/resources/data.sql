insert into user_role(role, description) VALUES ("ROLE_USER", "default role for user");
insert into user_role(role, description) VALUES ("ROLE_ADMIN", "default role for admin");



insert into product_group(name) VALUE ("Napędy przesuwne");
insert into product_group(name) VALUE ("Napędy przymykowe");

insert into product_type(name, product_group_id) VALUES ("ECDrive", 1);
insert into product_type(name, product_group_id) VALUES ("SlimDrive", 1);
insert into product_type(name, product_group_id) VALUES ("PowerDrive", 1);
insert into product_type(name, product_group_id) VALUES ("ECTurn", 2);
insert into product_type(name, product_group_id) VALUES ("SlimDrive EMD-F", 2);
insert into product_type(name, product_group_id) VALUES ("PowerTurn", 2);

insert into math_formula(name) VALUE ("szyna");

insert into product(def_quantity, id_number, name, product_type_id, math_formula_id) VALUES (1, 116395, "szyna jezdna", 1, 1);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 128733, "wspornik modułów", 1);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 234456, "pokrywa", 2);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 345565, "zawieszenie", 2);


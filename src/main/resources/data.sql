insert into user_role(role, description) VALUES ("ROLE_USER", "default role for user");
insert into user_role(role, description) VALUES ("ROLE_ADMIN", "default role for admin");



insert into product_group(name) VALUE ("Napędy przesuwne");
insert into product_group(name) VALUE ("Napędy przymykowe");

insert into product_type(name, product_group_id) VALUES ("ECDrive", 1);
insert into product_type(name, product_group_id) VALUES ("SlimDrive", 1);
insert into product_type(name, product_group_id) VALUES ("SlimDrive EMD-F", 2);
insert into product_type(name, product_group_id) VALUES ("PowerTurn", 2);

insert into math_formula(name) VALUE ("RUNNING_RAIL");
insert into math_formula(name) VALUE ("MODULE_CARRIER");

insert into product(def_quantity, id_number, name, product_type_id, math_formula_id) VALUES (1, 116395, "SZYNA JEZDNA", 1, 1);
insert into product(def_quantity, id_number, name, product_type_id, math_formula_id) VALUES (1, 128733, "WSPORNIK MODUŁÓW", 1, 2);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 117764, "ECDRIVE VP-KIT", 1);

insert into product(def_quantity, id_number, name, product_type_id, math_formula_id) VALUES (1, 142253, "SZYNA JEZDNA", 2, 1);
insert into product(def_quantity, id_number, name, product_type_id, math_formula_id) VALUES (1, 130113, "WSPORNIK MODUŁÓW", 2, 2);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 133088, "SLIMDRIVE VP-KIT", 2);

insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 107577, "NAPĘD SLIMDRIVE EMD-F", 3);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 106652, "POKRYWA NAPĘDU SLIMDRIVE EMD", 3);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 123456, "SZYNA JEZDNA SLIMDRIVE EMD 710MM", 3);

insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 153065, "NAPĘD POWERTURN", 4);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 161927, "POKRYWA NAPĘDU POWERTURN", 4);
insert into product(def_quantity, id_number, name, product_type_id) VALUES (1, 153787, "SZYNA JEZDNA POWERTURN 330",4);


INSERT INTO  CLIENT (id, direction,first_name,last_name, indetification_card)  values (1, 'Calle 56', 'eddi', 'avila', '123456');
INSERT INTO  CLIENT (id, direction,first_name,last_name, indetification_card)  values (2, 'Calle 100', 'Daniel', 'Rodiguez', '12432134');


INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (1, 'TV', '20000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (2, 'Phone 12', '35000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (3, 'Samsung g3', '114000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (4, 'Microondas', '440000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (5, 'laptop gamer asus', '342000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (6, 'Monito', '445000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (7, 'Tablet apple', '20000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (8, 'Neveras', '14400');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (9, 'Control', '150000');
INSERT INTO PRODUCT (id, `NAME`, `VALUE`) VALUES (10, 'Teclado', '24000');


INSERT INTO RECEIPT_PRODUCT(id, id_client, id_product,create_at, send_value, iva_product, product_total) VALUES (1, 1, 1, '2021-04-21 12:41:14.234196', 2000, 5000, 7000);
INSERT INTO RECEIPT_PRODUCT(id, id_client, id_product,create_at, send_value, iva_product, product_total) VALUES (2, 1, 2, NOW(), 0, 5000, 7000);
INSERT INTO RECEIPT_PRODUCT(id, id_client, id_product,create_at, send_value, iva_product, product_total) VALUES (3, 2, 6, NOW(), 2000, 5000, 70000);
INSERT INTO RECEIPT_PRODUCT(id, id_client, id_product,create_at, send_value, iva_product, product_total) VALUES (4, 2, 5, NOW(), 0, 5000, 70000);

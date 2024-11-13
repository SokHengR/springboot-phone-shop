-- -- Init Customer Table
-- CREATE TABLE Customer (
--     id TEXT PRIMARY KEY,
--     address TEXT,
--     auth_token TEXT,
--     name TEXT,
--     password TEXT,
--     phone_number TEXT
-- );

-- DELETE FROM Customer;

-- CREATE TABLE Product (
--     id VARCHAR(255) PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     price DOUBLE NOT NULL,
--     in_stock INT NOT NULL,
--     brand_name VARCHAR(255),
--     detail TEXT,
--     star_count INT
-- );

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('013942c0-d5f6-4a01-9d34-21f92369e9cd', 'iPhone 16 Pro', 1399, 10, 'Apple', 'Apple iPhone 16 Pro smartphone. Announced Sep 2024. Features 6.3″ display, Apple A18 Pro chipset, 3582 mAh battery, 1024 GB storage, 8 GB RAM.', 4);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('4f10b3f8-5bfe-403d-a1ba-67c3336af590', 'iPhone 15', 799, 20, 'Apple', 'Apple iPhone 15 smartphone. Announced Sep 2023. Features 6.1″ display, Apple A16 Bionic chipset, 3349 mAh battery, 512 GB storage, 6 GB RAM.', 3);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('78e09108-d124-48ec-9ec1-a9f75841af8a', 'iPhone 11', 469, 23, 'Apple', 'Apple iPhone 11 smartphone. Announced Sep 2019. Features 6.1″ display, Apple A13 Bionic chipset, 3110 mAh battery, 256 GB storage, 4 GB RAM.', 4);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('9630ae1f-8448-40e8-91f4-472ce00cc5fb', 'Vivo V40 5G', 499, 20, 'Vivo', 'vivo V40 Android smartphone. Announced Jun 2024. Features 6.78″ display, Snapdragon 7 Gen 3 chipset, 5500 mAh battery, 512 GB storage, 12 GB RAM.', 4);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('ba3ef260-8861-408e-8704-6e9a828fbb10', 'Xiaomi 14T', 399, 24, 'Xiaomi', 'Xiaomi 14T Android smartphone. Announced Sep 2024. Features 6.67″ display, Dimensity 8300 Ultra chipset, 5000 mAh battery, 512 GB storage, 16 GB RAM.', 4);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('f0a92f8c-b1ce-4020-85d6-c0723067d89a', 'Galaxy S24 FE', 699, 13, 'Samsung', 'Galaxy S24 FE Android smartphone. Announced Sep 2024. Features 6.7″ display, Exynos 2400e chipset, 4700 mAh battery, 512 GB storage, 8 GB RAM.', 4);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('354aa611-0c92-4b9d-9e31-140d9a08bbcb', 'Galaxy A06', 119, 25, 'Samsung', 'Galaxy A06 Android smartphone. Announced Aug 2024. Features 6.7″ display, Helio G85 chipset, 5000 mAh battery, 128 GB storage, 6 GB RAM.', 3);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('4b121fcb-6e06-4255-940f-0765a258e4a9', 'Oppo A3', 159, 12, 'Oppo', 'Oppo A3 Android smartphone. Announced Aug 2024. Features 6.67″ display, Dimensity 6300 chipset, 5100 mAh battery, 128 GB storage, 6 GB RAM.', 2);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('a6be15f4-3fda-4155-aafd-6ba6d1ea0bc7', 'Pixel 9 Pro', 849, 21, 'Google', 'Pixel 9 Pro Android smartphone. Announced Aug 2024. Features 6.3″ display, Google Tensor G4 chipset, 4700 mAh battery, 1024 GB storage, 16 GB RAM.', 4);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('40f19ffc-47dc-4130-8ba8-995665f120b4', 'Xiaomi 14 Ultra', 1199, 5, 'Xiaomi', 'Xiaomi 14 Ultra Android smartphone. Announced Feb 2024. Features 6.73″ display, Snapdragon 8 Gen 3 chipset, 5000 mAh battery, 1024 GB storage, 16 GB RAM.', 4);

-- INSERT INTO Product (id, name, price, in_stock, brand_name, detail, star_count) VALUES
-- ('8c0caaf9-f6a8-459c-a814-76e8610e70f9', 'Galaxy A35', 349, 35, 'Samsung', 'Galaxy A35 Android smartphone. Announced Mar 2024. Features 6.6″ display, Exynos 1380 chipset, 5000 mAh battery, 256 GB storage, 8 GB RAM.', 2);

-- DELETE FROM Product;

SELECT * FROM Customer WHERE auth_token = '895c29da-cf52-4218-9795-cf40c5ff8d26';
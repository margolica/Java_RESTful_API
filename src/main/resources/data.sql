INSERT INTO address (country, city, street) VALUES
    ('Россия', 'Москва', 'ул. Ленина'),
    ('Россия', 'Санкт-Петербург', 'Невский проспект'),
    ('Россия', 'Екатеринбург', 'ул. Малышева'),
    ('Россия', 'Новосибирск', 'Красный проспект'),
    ('Россия', 'Казань', 'ул. Баумана'),
    ('Польша', 'Москва', 'ул. Ленина'),
    ('Польша', 'Санкт-Петербург', 'Невский проспект'),
    ('Польша', 'Екатеринбург', 'ул. Малышева'),
    ('Польша', 'Новосибирск', 'Красный проспект'),
    ('Польша', 'Казань', 'ул. Баумана');

INSERT INTO client (firstName, lastName, birthday, gender, registration_date, address_id) VALUES
    ('Иван', 'Иванов', '1990-05-15', 1, '2023-01-10', 6),
    ('Мария', 'Петрова', '1985-08-20', 2, '2023-02-15', 7),
    ('Алексей', 'Сидоров', '1995-03-25', 1, '2023-03-20', 8),
    ('Ольга', 'Кузнецова', '1980-11-30', 2, '2023-04-25', 9),
    ('Дмитрий', 'Смирнов', '1992-07-12', 1, '2023-05-30', 10);

INSERT INTO supplier (name, address_id, phone_number) VALUES
    ('ООО "Ромашка"', 1, '+79161234567'),
    ('ИП "Солнце"', 2, '+79262345678'),
    ('ЗАО "Ветер"', 3, '+79373456789'),
    ('ОАО "Луна"', 4, '+79484567890'),
    ('ТОО "Звезда"', 5, '+79595678901');

INSERT INTO images (id, data) VALUES
    ('f47ac10b-58cc-4372-a567-0e02b2c3d471', '89504E470D0A1A0A0000000D49484452000000100000001008020000009091683600000183694343504943432070726F66696C65000028917D913D48C3401CC55F53A52A15053B883864A84E1644451CB50A45A8106A85561D4C2EFD82260D498A8BA3E05A70F063B1EAE0E2ACAB83AB20087E80B80B4E8A2E52E2FF92428B180F8EFBF1EEDEE3EE1D20D4CB4CB33AC6014DB7CD54222E66B2AB62E81502FAD18D308232B38C39494AC2777CDD23C0D7BB18CFF23FF7E7E8557316030222F12C334C9B7883787AD33638EF134758515689CF89C74CBA20F123D7158FDF38175C167866C44CA7E68923C462A18D9536664553239E228EAA9A4EF942C66395F31667AD5C65CD7BF2178673FACA32D7690E2381452C41820805559450868D18AD3A291652B41FF7F10FB97E895C0AB94A60E45840051A64D70FFE07BFBBB5F293135E52380E74BE38CEC70810DA051A35C7F93E769CC609107C06AEF496BF5207663E49AFB5B4E811D0B70D5C5CB734650FB8DC01069F0CD9945D294853C8E781F733FAA62C30700BF4AC79BD35F771FA00A4A9ABE40D7070088C16287BDDE7DD5DEDBDFD7BA6D9DF0FDFE1726C1D5F4123000000097048597300002E2300002E230178A53F760000000774494D4507E90210090D129E80D09F0000001974455874436F6D6D656E74004372656174656420776974682047494D5057810E170000001A4944415428CF633CE6748A8114C0C4402218D530AA61E8680000C3D301F2691ADBD70000000049454E44AE426082'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d472', '89504E470D0A1A0A0000000D49484452000000100000001008020000009091683600000183694343504943432070726F66696C65000028917D913D48C3401CC55F53A52A15053B883864A84E1644451CB50A45A8106A85561D4C2EFD82260D498A8BA3E05A70F063B1EAE0E2ACAB83AB20087E80B80B4E8A2E52E2FF92428B180F8EFBF1EEDEE3EE1D20D4CB4CB33AC6014DB7CD54222E66B2AB62E81502FAD18D308232B38C39494AC2777CDD23C0D7BB18CFF23FF7E7E8557316030222F12C334C9B7883787AD33638EF134758515689CF89C74CBA20F123D7158FDF38175C167866C44CA7E68923C462A18D9536664553239E228EAA9A4EF942C66395F31667AD5C65CD7BF2178673FACA32D7690E2381452C41820805559450868D18AD3A291652B41FF7F10FB97E895C0AB94A60E45840051A64D70FFE07BFBBB5F293135E52380E74BE38CEC70810DA051A35C7F93E769CC609107C06AEF496BF5207663E49AFB5B4E811D0B70D5C5CB734650FB8DC01069F0CD9945D294853C8E781F733FAA62C30700BF4AC79BD35F771FA00A4A9ABE40D7070088C16287BDDE7DD5DEDBDFD7BA6D9DF0FDFE1726C1D5F4123000000097048597300002E2300002E230178A53F760000000774494D4507E90210090D129E80D09F0000001974455874436F6D6D656E74004372656174656420776974682047494D5057810E170000001A4944415428CF633CE6748A8114C0C4402218D530AA61E8680000C3D301F2691ADBD70000000049454E44AE426082'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d473', '89504E470D0A1A0A0000000D49484452000000100000001008020000009091683600000183694343504943432070726F66696C65000028917D913D48C3401CC55F53A52A15053B883864A84E1644451CB50A45A8106A85561D4C2EFD82260D498A8BA3E05A70F063B1EAE0E2ACAB83AB20087E80B80B4E8A2E52E2FF92428B180F8EFBF1EEDEE3EE1D20D4CB4CB33AC6014DB7CD54222E66B2AB62E81502FAD18D308232B38C39494AC2777CDD23C0D7BB18CFF23FF7E7E8557316030222F12C334C9B7883787AD33638EF134758515689CF89C74CBA20F123D7158FDF38175C167866C44CA7E68923C462A18D9536664553239E228EAA9A4EF942C66395F31667AD5C65CD7BF2178673FACA32D7690E2381452C41820805559450868D18AD3A291652B41FF7F10FB97E895C0AB94A60E45840051A64D70FFE07BFBBB5F293135E52380E74BE38CEC70810DA051A35C7F93E769CC609107C06AEF496BF5207663E49AFB5B4E811D0B70D5C5CB734650FB8DC01069F0CD9945D294853C8E781F733FAA62C30700BF4AC79BD35F771FA00A4A9ABE40D7070088C16287BDDE7DD5DEDBDFD7BA6D9DF0FDFE1726C1D5F4123000000097048597300002E2300002E230178A53F760000000774494D4507E90210090D129E80D09F0000001974455874436F6D6D656E74004372656174656420776974682047494D5057810E170000001A4944415428CF633CE6748A8114C0C4402218D530AA61E8680000C3D301F2691ADBD70000000049454E44AE426082'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d474', '89504E470D0A1A0A0000000D49484452000000100000001008020000009091683600000183694343504943432070726F66696C65000028917D913D48C3401CC55F53A52A15053B883864A84E1644451CB50A45A8106A85561D4C2EFD82260D498A8BA3E05A70F063B1EAE0E2ACAB83AB20087E80B80B4E8A2E52E2FF92428B180F8EFBF1EEDEE3EE1D20D4CB4CB33AC6014DB7CD54222E66B2AB62E81502FAD18D308232B38C39494AC2777CDD23C0D7BB18CFF23FF7E7E8557316030222F12C334C9B7883787AD33638EF134758515689CF89C74CBA20F123D7158FDF38175C167866C44CA7E68923C462A18D9536664553239E228EAA9A4EF942C66395F31667AD5C65CD7BF2178673FACA32D7690E2381452C41820805559450868D18AD3A291652B41FF7F10FB97E895C0AB94A60E45840051A64D70FFE07BFBBB5F293135E52380E74BE38CEC70810DA051A35C7F93E769CC609107C06AEF496BF5207663E49AFB5B4E811D0B70D5C5CB734650FB8DC01069F0CD9945D294853C8E781F733FAA62C30700BF4AC79BD35F771FA00A4A9ABE40D7070088C16287BDDE7DD5DEDBDFD7BA6D9DF0FDFE1726C1D5F4123000000097048597300002E2300002E230178A53F760000000774494D4507E90210090D129E80D09F0000001974455874436F6D6D656E74004372656174656420776974682047494D5057810E170000001A4944415428CF633CE6748A8114C0C4402218D530AA61E8680000C3D301F2691ADBD70000000049454E44AE426082'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d475', '89504E470D0A1A0A0000000D49484452000000100000001008020000009091683600000183694343504943432070726F66696C65000028917D913D48C3401CC55F53A52A15053B883864A84E1644451CB50A45A8106A85561D4C2EFD82260D498A8BA3E05A70F063B1EAE0E2ACAB83AB20087E80B80B4E8A2E52E2FF92428B180F8EFBF1EEDEE3EE1D20D4CB4CB33AC6014DB7CD54222E66B2AB62E81502FAD18D308232B38C39494AC2777CDD23C0D7BB18CFF23FF7E7E8557316030222F12C334C9B7883787AD33638EF134758515689CF89C74CBA20F123D7158FDF38175C167866C44CA7E68923C462A18D9536664553239E228EAA9A4EF942C66395F31667AD5C65CD7BF2178673FACA32D7690E2381452C41820805559450868D18AD3A291652B41FF7F10FB97E895C0AB94A60E45840051A64D70FFE07BFBBB5F293135E52380E74BE38CEC70810DA051A35C7F93E769CC609107C06AEF496BF5207663E49AFB5B4E811D0B70D5C5CB734650FB8DC01069F0CD9945D294853C8E781F733FAA62C30700BF4AC79BD35F771FA00A4A9ABE40D7070088C16287BDDE7DD5DEDBDFD7BA6D9DF0FDFE1726C1D5F4123000000097048597300002E2300002E230178A53F760000000774494D4507E90210090D129E80D09F0000001974455874436F6D6D656E74004372656174656420776974682047494D5057810E170000001A4944415428CF633CE6748A8114C0C4402218D530AA61E8680000C3D301F2691ADBD70000000049454E44AE426082');

INSERT INTO product (name, category, price, available_stock, last_update_date, supplier_id, image_id) VALUES
    ('Ноутбук', 'Электроника', 50000, 10, '2023-10-01', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d471'),
    ('Смартфон', 'Электроника', 30000, 20, '2023-10-02', 2, 'f47ac10b-58cc-4372-a567-0e02b2c3d472'),
    ('Кофеварка', 'Бытовая техника', 15000, 5, '2023-10-03', 3, 'f47ac10b-58cc-4372-a567-0e02b2c3d473'),
    ('Микроволновка', 'Бытовая техника', 20000, 8, '2023-10-04', 4, 'f47ac10b-58cc-4372-a567-0e02b2c3d474'),
    ('Пылесос', 'Бытовая техника', 25000, 12, '2023-10-05', 5, 'f47ac10b-58cc-4372-a567-0e02b2c3d475');
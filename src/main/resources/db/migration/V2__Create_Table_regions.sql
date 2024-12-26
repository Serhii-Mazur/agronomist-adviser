CREATE TABLE IF NOT EXISTS regions
(
    id   INTEGER        NOT NULL    UNIQUE  PRIMARY KEY,
    name VARCHAR(200)   NOT NULL,
    description VARCHAR(250)
);

INSERT INTO public.regions (id, "name", "description") VALUES
    (1, 'Crimea', 'Autonomic rep. Crimea'),
    (2, 'Cherkasy', 'Cherkasy reg.'),
    (3, 'Chernihiv', 'Chernihiv reg.'),
    (4, 'Chernivtsi', 'Chernivtsi reg.'),
    (5, 'Dnipro', 'Dnipro reg.'),
    (6, 'Donetsk', 'Donetsk reg.'),
    (7, 'IvanoFrankivsk', 'IvanoFrankivsk reg.'),
    (8, 'Kharkiv', 'Kharkiv reg.'),
    (9, 'Kherson', 'Kherson reg.'),
    (10, 'Khmelnytskyi', 'Khmelnytskyi reg.'),
    (11, 'Kropyvnytskyi', 'Kropyvnytskyi reg.'),
    (12, 'Kyiv', 'Kyiv reg.'),
    (13, 'Luhansk', 'Luhansk reg.'),
    (14, 'Lviv', 'Lviv reg.'),
    (15, 'Mykolaiv', 'Mykolaiv reg.'),
    (16, 'Odesa', 'Odesa reg.'),
    (17, 'Poltava', 'Poltava reg.'),
    (18, 'Rivne', 'Rivne reg.'),
    (19, 'Sumy', 'Sumy reg.'),
    (20, 'Ternopil', 'Ternopil reg.'),
    (21, 'Vinnytsia', 'Vinnytsia reg.'),
    (22, 'Volyn', 'Volyn reg.'),
    (23, 'Zakarpattia', 'Zakarpattia reg.'),
    (24, 'Zaporizhzhia', 'Zaporizhzhia reg.'),
    (25, 'Zhytomyr', 'Zhytomyr reg.')
;

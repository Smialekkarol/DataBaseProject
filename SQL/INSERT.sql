INSERT INTO Project.department (department_ID, name, description) 
VALUES
(1,'Elektronarzędzia','Dział zajmujący się sprzedażą elektronarzędzi przewodowych i bezprzewodowych'),
(2,'Ubrania robocze','Dział zajmujący się sprzedażą ubrań roboczych, obuwia i akcesoriów BHP'),
(3,'Narzędzia ręczne','Dział zajmujący się sprzedażą narzędzi ręcznych każdego rodzaju'),
(4,'Ogród','Dział zajmujący się sprzedaża materiałów i narzędzi używanych w ogrodzie'),
(5,'Dom','Dział zajmujący się sprzedaża akcesorii domowych'),
(6,'Chemia','Dział zajmujący się sprzedażą chemii różnego zastosowania'),
(7,'Materiały budowlane','Dział zajmujący się sprzedażą materiałów budowlanych');


INSERT INTO Project.category (Category_ID, Department_ID, Name)
VALUES
(100, 1, 'Przewodowe'),
(101, 1, 'Bezprzewodowe'),
(102, 2, 'Odzież'),
(103, 2, 'Obuwie'),
(104, 2, 'BHP'),
(105, 3, 'Stolarstwo i ciesielstwo'),
(106, 3, 'Elektryka'),
(107, 3, 'Mechanika samochodowa'),
(108, 4, 'Zieleń'),
(109, 4, 'Wypoczynek i rekreacja'),
(110, 4, 'Narzędzia ogrodowe'),--
(111, 5, 'Podłogi i wykończenie'),--
(112, 5, 'Wyposażenie kuchenne i sanitarne'),
(113, 5, 'Okna i drzwi'),--
(114, 6, 'Chemia budowlana'),--
(115, 6, 'Farby i lakiery'),
(116, 6, 'Kleje, i uszczelniacze'),--
(117, 7, 'Bloczki, cegły i pustaki'),--
(118, 7, 'Cement i akcesoria do betonu'),--
(119, 7, 'Ocieplenie');


INSERT INTO Project.supplier (Supplier_ID, Name, NIP, Country, Postcode, City, Address, Phone)
VALUES
(10, 'Bud-Trade', '6193252523', 'Polska', '10-034', 'Olsztyn', 'ul. Hugona 14 ', '+48542642236'),
(11, 'Techtar', '8425925583', 'Polska', '63-911', 'Rawicz', 'ul. Kolejowa 441', '+48232884923');


INSERT INTO Project.brand (Brand_ID, Supplier_ID, Name, Manufacture_country)
VALUES
(99, 11, 'Makita', 'Chiny'),--Elektronarzedzia
(98, 11, 'Dewalt', 'Chiny'),--Elektronarzedzia
(97, 11, 'Mewa', 'Polska'),--odzież i obuwie robocze, akcesoria BHP
(96, 11, 'Wolfcraft', 'Chiny'),--Stolarstwo i ciesielstwo
(95, 11, 'HighVoltage', 'Polska'),--elektryka
(94, 11, 'Autoexpert', 'Chiny'), --mechanika samochodowa
(93, 10, 'Alpa', 'Chiny, Polska'), --zielen, wypoczynek i rekreacja
(92, 10, 'Fiskars', 'Chiny'), --narzedzia ogrodowe
(91, 10, 'PolDor', 'Polska'), -- Okna, Drzwi, podłogi drewniane
(90, 10, 'CementForm', 'Polska'), --płytki betonowe i ceramiczne,cement, bloczki betonowe, akcesoria do betonu
(89, 10, 'Murdom', 'Polska'), --cegły i pustaki
(88, 10, 'Stabill', 'Polska'), --Chemia budowlana, kleje i uszczelniacze
(87, 10, 'Selena', 'Polska'), --Ocieplenie
(86, 10, 'Roco', 'Hiszpania'); --akcesoria kuchenne i sanitarne

INSERT INTO Project.product (Product_ID, Brand_ID, Category_ID, Name, Description, Price)
VALUES
(0001, 99, 100, 'Klucz udarowy Makita 2352113','', 590.00),
(0002, 99, 100, 'Wyrzynarka przewodowa 4350FCT 720 W MAKITA', '', 1200.00),
(0003, 98, 100,'Wkrętarka sieciowa 540W 230V 1/4 G/K DEWALT DW274', '', 599.99),
(0004, 98, 100, 'Ukośnica Dewalt DWS780 1675 W', '', 2899.99),--Przewodowe

(0005, 99, 101, 'SZLIFIERKA KĄTOWA DO Makita 18V 125mm 10000rpm', '', 170.99),
(0006, 99, 101, 'MŁOTOWIERTARKA MAKITA SDS+ 780 W 2.7 J HR2470', '', 600.00), 
(0007, 98, 101, 'ZAKRĘTARKA UDAROWA ATOMIC DCF850', '', 639.99),
(0008, 97, 102,'KOSZULA odziez robocza SKÓRA POLSKA', '', 59.99),
(0009, 97, 102,'KOSZULA odziez robocza FLANELOWA POLSKA', '', 39.99),
(0010, 97, 102,'KURTKA ROBOCZA OCIEPLANA zimowa ODBLASKOWA','', 159.99),
(0011, 97, 102,'KOMPLET MĘSKIEJ odzieży roboczej BHP','',199.99),
(0012, 97, 102,'SPODNIE ROBOCZE', '', 99.99),--Odzież

(0013, 97, 103, 'OBUWIE ROBOCZE Z NOSKIEM','',99.99),
(0014, 97, 103, 'OBUWIE ŻAROODPORNE', '', 129.99),
(0015, 97, 103, 'OBUWIE DACHOWE ATEST', '', 149.99),
(0016, 97, 103, 'KALOSZE GUMOWE', 'WODOODPORNE', 49.99),--Obuwie

(0017, 97, 104, 'NAUSZNIKI OCHRONNE', 'ŻÓŁTE', 19.99),
(0018, 97, 104, 'MASKA PRZECIWPYŁOWA', '', 14.00),
(0019, 97, 104, 'OKULARY OCHRONNE', 'ATEST BALISTYCZNY', 29.99),
(0020, 97, 104, 'KASK BUDOWLANY', 'ODPORNY NA UDERZENIA', 49.99),--BHP

(0021, 96, 105, 'STOJAK DO WIERTARKI STATYW', '', 199.99),
(0022, 96, 105, 'MŁOTEK CIESIELSKI', '', 49.99),
(0023, 96, 105, 'ŚCISKI STOLARSKIE', '4 SZTUKI', 69.99),
(0024, 96, 105, 'ZESTAW BITÓW I WIERTEŁ', '', 99.99),--stolarstwo i ciesielstwo

(0025, 95, 106, 'WALIZKA NARZĘDZIOWA', '', 159.99),
(0026, 95, 106, 'WKRĘTAKI IZOLOWANE', '', 39.99 ),
(0027, 95, 106, 'KABLE ZESTAW', '50M', 49.99),
(0028, 95, 106, 'DŁUTOWNICA RĘCZNA', '', 199.99),--elektryka

(0029, 94, 107, 'ZESTAW ŚCIĄGACZY TAPICERSKICH', '', 14.99),
(0030, 94, 107, 'ZESTAW KLUCZY DO KORKÓW OLEJOWYCH', '', 79.99),
(0031, 94, 107, 'PODNOŚNIK SAMOCHODOWY RĘCZNY', '', 129.99),
(0032, 94, 107, 'KLUCZ DO KÓŁ', 'ZESTAW', 69.99),--Mechanika samochodowa

(0033, 93, 108, 'NAWÓZ DO TRAWY', 'AZOTOWY 5KG', 19.99),
(0034, 93, 108, 'TRAWA UNIWERSALNA', '2KG', 14.99),
(0035, 93, 108, 'KOSIARKA SPALINOWA', '', 999.99),
(0036, 93, 108, 'OBRZEŻE CHODNIKOWE PLASTIK', '10M', 59.99),--Zieleń

(0037, 93, 109, 'ZESTAW WYPOCZYNKOWY ANTRACYT', '', 499.99),
(0038, 93, 109, 'ZESTAW WYPOCZYNKOWY BRĄZ', '', 499.99),
(0039, 93, 109, 'HAMAK BIWAKOWY', '', 69.99),
(0040, 93, 109, 'PARASOL OGRODOWY', '', 199.99),--Wypoczynek i rekreacja

(0041, 92, 110, '', '', 0.0 ),
(0042, 92, 110, '', '', 0.0),
(0043, 92, 110, '', '', 0.0),
(0044, 92, 110, '', '', 0.0),--Narzędzia ogrodowe

(0045, 91, 111, '', '',0.0 ),
(0046, 91, 111, '', '', 0.0),
(0047, 91, 111, '', '', 0.0),
(0048, 91, 111, '', '', 0.0),--Podłogi i wykończenie

(0049, 86, 112, '', '', 0.0),
(0050, 86, 112, '', '', 0.0),
(0051, 86, 112, '', '', 0.0),
(0052, 86, 112, '', '', 0.0),--Wyposażenie kuchenne i sanitarne

(0053, 91, 113, '', '', 0.0),
(0054, 91, 113, '', '',0.0 ),
(0055, 91, 113, '', '', 0.0),
(0056, 91, 113, '', '', 0.0),--Okna i drzwi

(0057, 88, 114, '', '', 0.0),
(0058, 88, 114, '', '', 0.0),
(0059, 88, 114, '', '', 0.0),
(0060, 88, 114, '', '', 0.0),--Chemia budowlana

(0061, 88, 115, '', '', 0.0),
(0062, 88, 115, '', '',0.0 ),
(0063, 88, 115, '', '', 0.0),
(0064, 88, 115, '', '', 0.0),--Farby i lakiery

(0065, 88, 116, '', '', 0.0),
(0066, 88, 116, '', '', 0.0),
(0067, 88, 116, '', '',0.0 ),
(0068, 88, 116, '', '',0.0 ),--Kleje, i uszczelniacze

(0069, 89, 117, '', '', 0.0),
(0070, 89, 117, '', '', 0.0),
(0071, 89, 117, '', '', 0.0),
(0072, 90, 117, '', '', 0.0),--Bloczki, cegły i pustaki

(0073, 90, 118, '', '', 0.0),
(0074, 90, 118, '', '',0.0 ),
(0075, 90, 118, '', '', 0.0),
(0076, 90, 118, '', '',0.0 ),--Cement i akcesoria do betonu

(0077, 87, 119, '', '',0.0 ),
(0078, 87, 119, '', '',0.0 ),
(0079, 87, 119, '', '',0.0 ),
(0080, 87, 119, '', '',0.0 );--Ocieplenie
 




INSERT INTO Project.employee (Employee_ID, Fname, Lname, Country, Postcode, City, Address, Phone)
VALUES
(1101100, 'Jolanta', 'Czerwińska', 'Polska', '01-376', 'Warszawa', 'ul. Chrobrego 13a/4', '+48234042539'),
(1101101, 'Danuta', 'Szymczak', 'Polska', '01-394', 'Warszawa', 'ul. Parkowa 93', '+48934634532'),
(1101102, 'Kamila', 'Majewska', 'Polska', '01-373', 'Warszawa', 'ul. Potokowa 324', '+48421321424'),
(1101103, 'Agata', 'Maleńczuk', 'Polska', '01-351', 'Warszawa', 'ul. Torowa 87', '+48774285942'),
(1101104, 'Michalina', 'Kropowska', 'Polska', '01-376', 'Warszawa', 'ul. Przy wale 123', '+48772649228'),
(1100105, 'Yurii', 'Nowicki', 'Polska', '01-373', 'Warszawa', 'ul. Kormoranów 1a/42', '+48125334995'),
(1100106, 'Karol', 'Korona', 'Polska', '01-336', 'Warszawa', 'ul. Plac wyzwolenia 1/53', '+48156942778'),
(1100107, 'Dariusz', 'Reduta', 'Polska', '01-376', 'Warszawa', 'ul. Koronna 111/23a', '+48235025022'),
(1100108, 'Sebastian', 'Chwałek', 'Polska', '01-373', 'Warszawa', 'ul. Zielona górka 421', '+48234923592'),
(1100109, 'Mateusz', 'Morawa', 'Polska', '01-361', 'Warszawa', 'ul. Karol wielkiego 18/25b', '+48635994867');

INSERT INTO Project.employee_data (Employee_ID, username, password) 
VALUES
(1101100, 'root', 'root'),
(1101101, '1111', '1111'),
(1101102, '2222', '2222'),
(1101103, '3333', '3333'),
(1101104, '4444', '4444'),
(1100105, '5555', '5555'),
(1100106, '6666', '6666'),
(1100107, '7777', '7777'),
(1100108, '8888', '8888'),
(1100109, '9999', '9999');



INSERT INTO Project.vip (VIP_level, Discount)
VALUES
(0,0),
(1,1.5),
(2,2.5),
(3,5);

INSERT INTO Project.customer(Customer_ID, VIP_level, NIP, Organization_name, Fname, Lname, Country, Postcode, City, Address, Phone)
VALUES
(100999, 0, 9541234359, 'Wszystko do domu S.C', 'Kamil', 'Korybut', 'Polska', '39-400', 'Tarnobrzeg', 'ul. Sienkiewicza 44', '+48600655638'),
(110998, 2, 1245520042, 'Alpan sp. z o.o.', 'Mariusz', 'Ruchała', 'Polska', '22-532', 'Poznań', 'ul. kalinowska 194', '+48125532884'),
(111997, 3, 8674420484, 'PSB S. A.', 'Marcin', 'Płatek', 'Polska', '01-425', 'Warszawa', 'ul. Rozmowna 23', '+48435236923');

INSERT INTO Project.customer_data (Customer_ID, username, password)
VALUES
(100999,'username', 'password'),
(110998,'username', 'password'),
(111997,'username', 'password');




INSERT INTO Project.store (Store_ID, Name, Country, Postcode, City, Address, Phone)
VALUES
(10099901, 'Wszystko do domu', 'Polska', '39-400', 'Tarnobrzeg', 'ul. Sienkiewicza 44', '+48600655638'),
(10099801, 'Magazyn Krajowy Alpan nr. 1', 'Polska', '22-532', 'Poznań', 'ul. kalinowkska 193', '+48125532884'),
(10099802, 'Magazyn Krajowy Alpan nr. 2', 'Polska', '52-324', 'Wrocław', 'ul. Miła 6', '+48235643233'),
(10099701, 'Mrówka PSB PŁN',   'Polska', '12-423', 'Toruń', 'ul. Kopernika 11', '+48324224992'),
(10099702, 'Mrówka PSB PŁD',   'Polska', '95-442', 'Kraków', 'ul. Juliusza Lea 114', '+48234242442'),
(10099703, 'Mrówka PSB Zach',   'Polska', '64-013', 'Łódź', 'ul. Cara mikołaja 152', '+48232522999'),
(10099704, 'Mrówka PSB Wsch',   'Polska', '22-223', 'Lublin', 'ul. Bismarka 1918', '+481231939228' );



INSERT INTO Project.magazine (Magazine_ID, Customer_ID, Employee_ID, Sale_transaction_ID)
VALUES
()
 
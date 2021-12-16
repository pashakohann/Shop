INSERT INTO users(account,password,role_id)VALUES ('admin','1111',1);

INSERT INTO roles(id,name)VALUES (1,'ADMIN'),(2,'USER');

INSERT INTO brands(id,name) VALUES(1, 'ASRock'),(2, 'Gigabyte'),(3, 'ASUS'),(4,'BIOSTAR'),(5, 'MSI'),(6, 'Crucial'),(7, 'Kingston'),(8, 'Chieftec'),(9, 'AeroCool'),
(10, 'WD'),( 11, 'Seagate'),(12, 'AMD'),(13, 'Intel'),(14, 'Zalman'),(15, 'DeepCool');

INSERT INTO categories(id,name) VALUES(1, 'motherboard'),(2, 'ram'),(3, 'power_unit'),(4, 'hdd'),(5, 'cpu'),(6, 'case'),(7, 'cooler'),(8, 'gpu');

INSERT INTO products(id,name,cost,category_id,brand_id) VALUES
(1, 'B460MPro4', 316.2, 1, 1, 'https://content2.onliner.by/catalog/device/header/311ca4005163b22c43dfe02aeebd3414.jpeg'),
(2, 'B560 Pro4', 314.1, 1, 1, 'https://content2.onliner.by/catalog/device/header/6e49d64f9434f66bfb1713800c4e1041.jpeg'),
(3, 'B560M Pro4', 286.7, 1, 1, 'https://content2.onliner.by/catalog/device/header/44ff9643ce506f60df9ce3f930d8ad2b.jpeg'),
(4, 'B560M-HDV', 226.1, 1, 1, 'https://content2.onliner.by/catalog/device/header/474e943d62c95de8139becf91db45f50.jpeg'),
(5, 'B450Pro4R2.0', 255.5, 1, 1, 'https://content2.onliner.by/catalog/device/header/02a0e7b38b7df1a33796d8eeea427458.jpeg'),
(6, 'H410 MH V3(rev.1.0)', 175.3, 1, 2, 'https://content2.onliner.by/catalog/device/header/f78954c01c767d9adab41733456aca5a.jpeg'),
(7, 'Z690 UD(rev.1.0)', 623.1, 1, 2, 'https://content2.onliner.by/catalog/device/header/d6a8a26936713e057e461c17b151dabf.jpeg'),
(8, 'Z690 Gaming X DDR4 (rev. 1.0)', 322.7, 1, 2, 'https://content2.onliner.by/catalog/device/header/d93e262702ab45f32b970fd15294cd4f.jpeg'),
(9, 'B450M DS3H (rev. 1.0)', 175.1, 1, 2, 'https://content2.onliner.by/catalog/device/header/05cd9ab80e6a9ac348848e2097ff00d0.jpeg'),
(10, 'B560M D3H (rev. 1.0)', 322.5, 1, 2, 'https://content2.onliner.by/catalog/device/header/3ecf6f7c27dc74dcdfa83335fd3b57b9.jpeg'),
(11, 'TUF B450M-Pro Gaming', 165.2, 1, 3, 'https://content2.onliner.by/catalog/device/header/a188dd6b81eaf9383c58282c4125a8bc.jpeg'),
(12, 'ROG STRIX B550-E Gaming', 102.2, 1, 3, 'https://content2.onliner.by/catalog/device/header/8b22c8bf078702d873e4a63b475590c2.jpeg'),
(13, 'TUF Gaming B550-Plus', 356.5, 1, 3, 'https://content2.onliner.by/catalog/device/header/5aa5c04b1cbee1400dc6a26379974620.jpeg'),
(14, 'TUF B450-Pro Gaming', 174.2, 1, 3, 'https://content2.onliner.by/catalog/device/header/76abaf40eab0946410ee409e11fcb25a.jpeg'),
(15, 'Prime B560M-A', 286.3, 1, 3, 'https://content2.onliner.by/catalog/device/header/fcf3926df7cb81936be1bd7ce2415595.jpeg'),
(16, 'A320MH Ver. 6.x', 322.3, 1, 4, 'https://content2.onliner.by/catalog/device/header/5107171c15b8a41e7d95e05f4bc7017e.jpg'),
(17, 'H61MHV3 Ver. 7.0', 135.3, 1, 4, 'https://content2.onliner.by/catalog/device/header/4d31421d118fad1a1cb871fb6786a211.jpeg'),
(18, 'H81MHV3 Ver. 7.x', 105.5, 1, 4, 'https://content2.onliner.by/catalog/device/header/e6b43ec1463dc2abe7382821e80e9b86.jpeg'),
(19, 'H510MX/E 2.0 Ver. 6.0', 111.2, 1, 4, 'https://content2.onliner.by/catalog/device/header/9228bb63e3b6351465a06a6a91530867.jpeg'),
(20, 'H510MH/E 2.0 Ver. 6.0', 315.3, 1, 4, 'https://content2.onliner.by/catalog/device/header/d8145ad46738ff3a00317faa69f1f347.jpeg'),
(21, 'MPG X570 Gaming Plus', 311.2, 1, 5, 'https://content2.onliner.by/catalog/device/header/50a9b7415dcd337ea6225f8c333ccdcb.jpeg'),
(22, 'B550-A Pro', 175.3, 1, 5, 'https://content2.onliner.by/catalog/device/header/55c172764757e58d867b3076a2287fd1.jpeg'),
(23, 'H81MHV3 Ver. 7.x', 105.5, 1, 5, 'https://content2.onliner.by/catalog/device/header/8ddb34d4f30e700ba00d7a7aaca61f2d.jpeg'),
(24, 'MPG Z490 Gaming Plus', 134.2, 1, 5, 'https://content2.onliner.by/catalog/device/header/d6eb58eb774a9f33fe5d8e803f612a07.jpeg'),
(25, 'PRO Z690-A DDR4', 378.3, 1, 5, 'https://content2.onliner.by/catalog/device/header/f39592621d8272510b4d41f2f4ad8672.jpeg'),
(26, '2x8GB DDR4 PC4-25600 BL2K8G32C16U4B', 224.3, 2, 6, 'https://content2.onliner.by/catalog/device/header/26fd3c63ebb4e71d50c90381911c440c.jpeg'),
(27, 'B550-A Pro', 175.3, 2, 6, 'https://content2.onliner.by/catalog/device/header/bd746c29435133b6d513465cb5cb8d77.jpeg'),
(28, '2x8GB DDR4 PC4-25600 BL2K8G32C16U4W', 245.3, 2, 6, 'https://content2.onliner.by/catalog/device/header/f73e9dbb40053f94bf9c9c9a9b59ab83.jpeg'),
(29, 'FURY Beast 2x16GB DDR5 PC5-38400 KF548C38BBK2-32', 1304.3, 2, 7, 'https://content2.onliner.by/catalog/device/header/f5c59160931d4850c4f4b9cb4328b6ae.jpeg'),
(30, 'ValueRAM 8GB DDR3 PC3-12800 (KVR16N11/8)', 122.4, 2, 7, 'https://content2.onliner.by/catalog/device/header/822cbb90e468362558633e15c3bbf1fa.jpeg'),
(31, 'Task TPS-700S', 137.3, 3, 8, 'https://content2.onliner.by/catalog/device/header/6500c90df0a79289de8e429f90fa3e9e.jpeg'),
(32, 'Core BBS-600S', 155.4, 3, 8, 'https://content2.onliner.by/catalog/device/header/b13e833c755d39ab77d930ea29ff4e25.jpeg'),
(33, 'Eco Series GPE-600S', 125.4, 3, 8, 'https://content2.onliner.by/catalog/device/header/120c6bed84b646c2a60ba05c373f720b.jpeg'),
(34, 'KCAS Plus 700W', 152.0, 3, 9, 'https://content2.onliner.by/catalog/device/header/d20943138cfb44d014ad502d15bfd8af.jpeg'),
(35, 'ECO-600W', 74.4, 3, 9, 'https://content2.onliner.by/catalog/device/header/20ef8528ccfd05a662b03cc987184e55.jpeg'),
(36, 'Caviar Blue 1TB (WD10EZEX)', 93.2, 4, 10, 'https://content2.onliner.by/catalog/device/header/c5640e5b99a02df1e74196250fe0b4e6.jpeg'),
(37, 'Plus 8TB WD80EFBX', 560.3, 4, 10, 'https://content2.onliner.by/catalog/device/header/096f2a9c442b0373e762adb1deb0ca71.jpeg'),
(38, '2TB WD20EZBXS', 95.3, 4, 10, 'https://content2.onliner.by/catalog/device/header/59ff775ad2ccd63dce0517a03278bbca.jpeg'),
(39, 'BarraCuda 1TB [ST1000DM010]', 96.1, 4, 11, 'https://content2.onliner.by/catalog/device/header/8ff65cc441bd44a55d85aff8ccb5bf95.jpeg'),
(40, 'Mobile HDD 1TB [ST1000LM035]', 322.6, 4, 11, 'https://content2.onliner.by/catalog/device/header/79923b8558103135f5891f4f78f6f826.jpeg'),
(41, 'Ryzen 5 5600G', 799.0, 5, 12, 'https://content2.onliner.by/catalog/device/header/fca7b5fa257c9cfb99429ef84fa54f9e.jpeg'),
(42, 'Ryzen 5 5600X', 853.4, 5, 12, 'https://content2.onliner.by/catalog/device/header/fa2d488cd454e83ebb1663504c2dc508.jpeg'),
(43, 'Ryzen 5 3600', 685.9, 5, 12, 'https://content2.onliner.by/catalog/device/header/733866fd1ddee0660637f96a86af11f7.jpeg'),
(44, 'Comet Lake, LGA1200, 6 ', 425.1, 5, 13, 'https://content2.onliner.by/catalog/device/header/9d79b9d626c90273b27765ba535dd065.jpeg'),
(45, 'Core i5-12600K', 906.9, 5, 13, 'https://content2.onliner.by/catalog/device/header/fb078eb7abffe5cda1b67caae6a24969.jpeg'),
(46, 'S2', 93.0, 6, 14, 'https://content2.onliner.by/catalog/device/header/5e8e702ef61e30afbf13c41c02102ef6.jpeg'),
(47, 'S5', 183.3, 6, 14, 'https://content2.onliner.by/catalog/device/header/ec2297aebb9b65fefe534b35ebab0b3e.jpeg'),
(48, 'N4', 12945.0, 6, 14, 'https://content2.onliner.by/catalog/device/header/ccad652babccc56dd245637a5496d584.jpeg'),
(49, 'Matrexx 50 Mesh 4FS DP-ATX-MATREXX50-MESH-4FS', 153.2, 6, 15, 'https://content2.onliner.by/catalog/device/header/2973f183e8a4c96ee7dc5fb1439a2569.jpeg'),
(50, 'CL500 4F R-CL500-BKNMA4N-A-1', 228.8, 6, 15, 'https://content2.onliner.by/catalog/device/header/5646df584c47c596fa7f8a24fae137a8.jpeg'),
(51, 'GAMMAXX GTE v2 DP-MCH4-GMX-GTEV2', 60.0, 7, 15, 'https://content2.onliner.by/catalog/device/header/1caec286fbf527dc7508a88773c14169.jpeg'),
(52, 'GAMMAXX 300 R', 59.1, 7, 15, 'https://content2.onliner.by/catalog/device/header/931254e036213c4fa124a7f462710708.jpeg'),
(53, 'GeForce RTX 3080 Ti Gaming OC 12GB GDDR6X GV-N308TGAMING OC-12GD', 6667.3, 8, 2, 'https://content2.onliner.by/catalog/device/header/8a2a1cd366b95669a31e6de2f592b640.jpeg'),
(54, 'GeForce RTX 3060 Gaming OC 12GB GDDR6 (rev. 2.0)', 2793.2, 8, 2, 'https://content2.onliner.by/catalog/device/header/84edacc756c8e95dc74e4dab2279e166.jpeg'),
(55, 'TUF Gaming GeForce RTX 3060 Ti V2 OC Edition 8GB GDDR6', 3359.6, 8, 3, 'https://content2.onliner.by/catalog/device/header/496c4acbada15e29a43afabb5568f2a2.jpeg'),
(57, 'B350 Aorus Elite (rev. 1.0)', 237.9, 1, 2, 'https://content2.onliner.by/catalog/device/header/fc68c8f90ea264ca2c900c68f4c2b59c.jpeg');











;
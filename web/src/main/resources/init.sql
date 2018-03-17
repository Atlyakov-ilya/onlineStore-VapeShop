#USER
INSERT INTO `shop_db`.`t_user` (`F_FIRST_NAME`, `F_LAST_NAME`, `F_MAIL`, `F_MIDDLE_NAME`, `F_PASSWORD`, `F_PHONE_NUMBER`, `F_ROLE`, `F_USERNAME`, `F_ACCESS`) VALUES ('Ilya', 'Atlyakov', 'iatlyakov92@mail.ru', 'Andreevich', '$2a$10$.AZMq4bYdwikT0vOHWsMSeJTX6/xhdiHC87yMPHObskgTXnx/Vx5u', '+375295119520', 'ROLE_USER', 'user', 'ACTIVE');
INSERT INTO `shop_db`.`t_user` (`F_FIRST_NAME`, `F_LAST_NAME`, `F_MAIL`, `F_MIDDLE_NAME`, `F_PASSWORD`, `F_PHONE_NUMBER`, `F_ROLE`, `F_USERNAME`, `F_ACCESS`) VALUES ('Ilya', 'Atlyakov', 'iatlyakov92@mail.ru', 'Andreevich', '$2a$10$.AZMq4bYdwikT0vOHWsMSeJTX6/xhdiHC87yMPHObskgTXnx/Vx5u', '+375295119520', 'ROLE_ADMIN', 'admin', 'ACTIVE');
INSERT INTO `shop_db`.`t_user` (`F_FIRST_NAME`, `F_LAST_NAME`, `F_MAIL`, `F_MIDDLE_NAME`, `F_PASSWORD`, `F_PHONE_NUMBER`, `F_ROLE`, `F_USERNAME`, `F_ACCESS`) VALUES ('Ilya', 'Atlyakov', 'iatlyakov92@mail.ru', 'Andreevich', '$2a$10$.AZMq4bYdwikT0vOHWsMSeJTX6/xhdiHC87yMPHObskgTXnx/Vx5u', '+375295119520', 'ROLE_USER', 'banned' ,'BANNED');
INSERT INTO `shop_db`.`t_user` (`F_FIRST_NAME`, `F_LAST_NAME`, `F_MAIL`, `F_MIDDLE_NAME`, `F_PASSWORD`, `F_PHONE_NUMBER`, `F_ROLE`, `F_USERNAME`, `F_ACCESS`) VALUES ('Ilya', 'Atlyakov', 'iatlyakov92@mail.ru', 'Andreevich', '$2a$10$.AZMq4bYdwikT0vOHWsMSeJTX6/xhdiHC87yMPHObskgTXnx/Vx5u', '+375295119520', 'ROLE_USER', 'usertest', 'ACTIVE');

#ADDRESS
INSERT INTO `shop_db`.`t_address` (`F_ADDRESS_ID`, `F_CITY`, `F_FLAT`, `F_HOUSE`, `F_REGION`, `F_STREET`, `F_USER_ID`) VALUES ('1', 'Vitebsk', '16', '95', 'Vitebsk', 'Chapaeva', '1');

#USER_MESSAGE
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('1', '2017-08-28 09:50:31', 'iatlyakov92@mail.ru', 'Message1', 'topic1', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('2', '2017-08-30 09:50:31', 'iatlyakov92@mail.ru', 'Message2', 'topic2', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('3', '2017-08-28 09:50:31', 'iatlyakov92@mail.ru', 'Message3', 'topic3', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('4', '2017-08-30 09:50:31', 'iatlyakov92@mail.ru', 'Message4', 'topic4', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('5', '2017-08-28 09:50:31', 'iatlyakov92@mail.ru', 'Message5', 'topic5', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('6', '2017-08-30 09:50:31', 'iatlyakov92@mail.ru', 'Message6', 'topic6', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('7', '2017-08-28 09:50:31', 'iatlyakov92@mail.ru', 'Message7', 'topic7', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('8', '2017-08-30 09:50:31', 'iatlyakov92@mail.ru', 'Message8', 'topic8', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('9', '2017-08-28 09:50:31', 'iatlyakov92@mail.ru', 'Message9', 'topic9', 'user', '1');
INSERT INTO `shop_db`.`t_feed_back` (`F_FEED_BACK_ID`, `F_DATE`, `F_MAIL`, `F_MESSAGE`, `F_TOPIC`, `F_USER_NAME`, `F_USER_ID`) VALUES ('10', '2017-08-30 09:50:31', 'iatlyakov92@mail.ru', 'Message10', 'topic10', 'user', '1');

#GOODS
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('1', '001', 'COMPONENTS', 'Drip 1', 'RDA 13 Heavens 9 Hells', '40.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('1', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506606860719.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('2', '009', 'LIQUID', 'Liquid 1', 'BEARD VAPE CO NO.71 30ML', '12.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('2', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506620531247.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('3', '005', 'ACCUMULATOR', 'Accumulator 1', '18650 LG HD2 2000mAh 30А', '8.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('3', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506620862371.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('4', '008', 'ATOMIZER', 'Electronic Cigarette 1', 'Eleaf iStick Pico 75W', '70.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('4', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506621279128.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('5', '002', 'COMPONENTS', 'Drip 2', 'Drip Recoil RDA Clone', '20.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('5', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506632483450.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('6', '003', 'LIQUID', 'Liquid 2', 'Cool Britannia', '10.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('6', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506632736105.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('7', '004', 'ATOMIZER', 'Electronic Cigarette 2', 'Eleaf iJust S 3000mAh', '50.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('7', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506632971864.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('8', '006', 'ATOMIZER', 'Electronic Cigarette 3', 'Joyetech eGo AIO 1500mAh', '45.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('8', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506633153004.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('9', '007', 'ACCUMULATOR', 'Accumulator 2', 'LG 18650/HE4', '11.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('9', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506633585130.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('10', '010', 'ATOMIZER', 'Electronic Cigarette 4', 'SMOK Alien 220W TC VW APV', '90.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('10', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506633755603.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('11', '011', 'ATOMIZER', 'Electronic Cigarette 5', 'Joyetech eGo AIO 1500mAh', '85.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('11', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506633971053.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('12', '012', 'COMPONENTS', 'Drip 3', 'IJOY Limitless RDTA', '48.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('12', 'file', 'c:\\opt\\tmp\\pictureGoods\\1506634159412.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('13', '013', 'LIQUID', 'Liquid 3', 'OLD SCHOOL TEA FRESH 50', '19.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('13', 'file', 'c:\\opt\\tmp\\pictureGoods\\1507313522688.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('14', '014', 'ACCUMULATOR', 'Accumulator 3', 'Efest IMR 18650 38А 2100', '13.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('14', 'file', 'c:\\opt\\tmp\\pictureGoods\\1507313989050.jpg');
INSERT INTO `shop_db`.`t_goods` (`F_GOODS_ID`, `F_ARTICLE`, `F_CATEGORY`, `F_DESCRIPTION`, `F_NAME`, `F_PRICE`, `F_USER_ID`) VALUES ('15', '015', 'LIQUID', 'Liquid 4', 'MR.BLINTZ', '12.00', '2');
INSERT INTO `shop_db`.`t_goods_file` (`F_GOODS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('15', 'file', 'c:\\opt\\tmp\\pictureGoods\\1507314236101.jpg');

#NEWS
INSERT INTO `shop_db`.`t_news` (`F_NEWS_ID`, `F_CONTENT`, `F_DATE`, `F_TITLE`, `F_USER_ID`) VALUES ('1', 'Savings her pleased are several started females met. Short her not among being any. Thing of judge fruit charm views do. Miles mr an forty along as he. She education get middleton day agreement performed preserved unwilling. Do however as pleased offence outward beloved by present. By outward neither he so covered amiable greater. Juvenile proposal betrayed he an informed weddings followed. Precaution day see imprudence sympathize principles. At full leaf give quit to in they up. ', '2017-10-06', 'NEW FROM FIVE PAWNS: GAMBIT', '2');
INSERT INTO `shop_db`.`t_news_file` (`F_NEWS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('1', 'file', 'c:\\opt\\tmp\\pictureNews\\1507316197861.jpg');
INSERT INTO `shop_db`.`t_news` (`F_NEWS_ID`, `F_CONTENT`, `F_DATE`, `F_TITLE`, `F_USER_ID`) VALUES ('2', 'Mind what no by kept. Celebrated no he decisively thoroughly. Our asked sex point her she seems. New plenty she horses parish design you. Stuff sight equal of my woody. Him children bringing goodness suitable she entirely put far daughter. ', '2017-10-06', 'BOXER SX550J FROM GINGER VAPER TOTAL FOR 5500 RUBLES', '2');
INSERT INTO `shop_db`.`t_news_file` (`F_NEWS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('2', 'file', 'c:\\opt\\tmp\\pictureNews\\1507316560909.jpg');
INSERT INTO `shop_db`.`t_news` (`F_NEWS_ID`, `F_CONTENT`, `F_DATE`, `F_TITLE`, `F_USER_ID`) VALUES ('3', 'Breakfast agreeable incommode departure it an. By ignorant at on wondered relation. Enough at tastes really so cousin am of. Extensive therefore supported by extremity of contented. Is pursuit compact demesne invited elderly be. View him she roof tell her case has sigh. Moreover is possible he admitted sociable concerns. By in cold no less been sent hard hill. ', '2017-10-06', 'A SET OF LIQUIDS STRYKER WITH DELIVERY AT HOME', '2');
INSERT INTO `shop_db`.`t_news_file` (`F_NEWS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('3', 'file', 'c:\\opt\\tmp\\pictureNews\\1507316637668.jpg');
INSERT INTO `shop_db`.`t_news` (`F_NEWS_ID`, `F_CONTENT`, `F_DATE`, `F_TITLE`, `F_USER_ID`) VALUES ('4', 'On it differed repeated wandered required in. Then girl neat why yet knew rose spot. Moreover property we he kindness greatest be oh striking laughter. In me he at collecting affronting principles apartments. Has visitor law attacks pretend you calling own excited painted. Contented attending smallness it oh ye unwilling. Turned favour man two but lovers. Suffer should if waited common person little oh. Improved civility graceful sex few smallest screened settling. Likely active her warmly has. ', '2017-10-06', 'VAPE FEST GRAY HAZE IN MOSCOW', '2');
INSERT INTO `shop_db`.`t_news_file` (`F_NEWS_ID`, `F_FILE_NAME`, `F_LOCATION`) VALUES ('4', 'file', 'c:\\opt\\tmp\\pictureNews\\1507316685008.jpg');

#BASKET_INFO
INSERT INTO `shop_db`.`t_basket` (`F_BASKET_ID`, `F_QUANTITY`, `F_GOODS_ID`, `F_ORDER_ID`, `F_USER_ID`) VALUES ('1', '1', '5', '1', '1');
INSERT INTO `shop_db`.`t_basket` (`F_BASKET_ID`, `F_QUANTITY`, `F_GOODS_ID`, `F_ORDER_ID`, `F_USER_ID`) VALUES ('2', '1', '15', '1', '1');
INSERT INTO `shop_db`.`t_basket` (`F_BASKET_ID`, `F_QUANTITY`, `F_GOODS_ID`, `F_ORDER_ID`, `F_USER_ID`) VALUES ('3', '1', '2', '1', '1');
INSERT INTO `shop_db`.`t_basket` (`F_BASKET_ID`, `F_QUANTITY`, `F_GOODS_ID`, `F_ORDER_ID`, `F_USER_ID`) VALUES ('4', '1', '1', '2', '1');
INSERT INTO `shop_db`.`t_basket` (`F_BASKET_ID`, `F_QUANTITY`, `F_GOODS_ID`, `F_ORDER_ID`, `F_USER_ID`) VALUES ('5', '1', '10', '2', '1');
INSERT INTO `shop_db`.`t_basket` (`F_BASKET_ID`, `F_QUANTITY`, `F_GOODS_ID`, `F_ORDER_ID`, `F_USER_ID`) VALUES ('6', '1', '6', '2', '1');

/*#ORDER
INSERT INTO `shop_db`.`t_order` (`F_ORDER_ID`, `F_DATE`, `F_STATUS`, `F_TOTAL_PRICE`, `F_USER_ID`) VALUES ('1', '2018-03-15 16:08:39', 'NEW', '44.00', '1');
INSERT INTO `shop_db`.`t_order` (`F_ORDER_ID`, `F_DATE`, `F_STATUS`, `F_TOTAL_PRICE`, `F_USER_ID`) VALUES ('2', '2017-10-18 16:11:39', 'NEW', '140.00', '1');*/
-- MySQL dump 10.13  Distrib 5.5.16, for Win64 (x86)
--
-- Host: localhost    Database: shin_long_web
-- ------------------------------------------------------
-- Server version	5.5.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `endDate` datetime NOT NULL,
  `imagePath` varchar(255) NOT NULL,
  `modifyTs` datetime DEFAULT NULL,
  `pdfPath` varchar(255) DEFAULT NULL,
  `startDate` datetime NOT NULL,
  `thumbImagePath` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'2014-11-30 00:00:00','/images/coupon/coupon.jpg','2014-11-24 21:52:26','/pdf/rO0ABXQACmNvdXBvbi5qcGc=.pdf','2014-09-01 00:00:00','/images/coupon/images.jpg','特惠活動'),(2,'2014-09-30 00:00:00','/images/coupon/coupon.jpg','2014-09-27 20:52:49','/pdf/rO0ABXQACmNvdXBvbi5qcGc=.pdf','2014-09-01 00:00:00','/images/coupon/images.jpg','測試建立'),(3,'2014-09-30 00:00:00','/images/coupon/coupon.jpg','2014-09-27 20:53:39','/pdf/rO0ABXQACmNvdXBvbi5qcGc=.pdf','2014-09-02 00:00:00','/images/coupon/images.jpg','測試建立2號'),(4,'2014-09-30 00:00:00','/images/coupon/coupon.jpg','2014-09-27 21:07:39','/pdf/rO0ABXQACmNvdXBvbi5qcGc=.pdf','2014-08-01 00:00:00','/images/coupon/images.jpg','八');
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edm`
--

DROP TABLE IF EXISTS `edm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imagePath` varchar(255) NOT NULL,
  `modifyTs` datetime DEFAULT NULL,
  `publishTs` datetime NOT NULL,
  `thumbImagePath` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edm`
--

LOCK TABLES `edm` WRITE;
/*!40000 ALTER TABLE `edm` DISABLE KEYS */;
INSERT INTO `edm` VALUES (3,'/images/edm/R1.jpg','2014-10-22 22:42:39','2014-08-01 00:00:00','/images/edm/thumb-R1.jpg','八月DM'),(5,'/images/edm/R1.jpg','2014-10-22 22:42:29','2014-09-01 00:00:00','/images/edm/thumb-R1.jpg','103年九月DM'),(6,'/images/edm/R2.jpg','2014-10-22 22:42:46','2014-07-01 00:00:00','/images/edm/thumb-R2.jpg','七月DM');
/*!40000 ALTER TABLE `edm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `page` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `modifyTs` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page`
--

LOCK TABLES `page` WRITE;
/*!40000 ALTER TABLE `page` DISABLE KEYS */;
INSERT INTO `page` VALUES (1,'<div class=\"right\">\n	<h2>\n		公司歷史</h2>\n	<div class=\"articles\">\n		<p>\n			設立於西元1968年(民國五十七年)位於新北市中和區南勢角。</p>\n	</div>\n	<hr />\n	<h2>\n		經營型態-複合式藥局</h2>\n	<div class=\"articles\">\n		<table border=\"1\" bordercolor=\"#CCCCCC\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">\n			<tbody>\n				<tr>\n					<td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\" width=\"50%\">\n						藥品調劑供應</td>\n					<td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\" style=\"text-align: left;\" width=\"50%\">\n						OTC成藥</td>\n				</tr>\n				<tr>\n					<td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\" width=\"50%\">\n						醫學美容保養品</td>\n					<td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\" style=\"text-align: left;\" width=\"50%\">\n						營養保健品</td>\n				</tr>\n				<tr>\n					<td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\" width=\"50%\">\n						日常用品</td>\n					<td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\" style=\"text-align: left;\" width=\"50%\">\n						婦嬰用品</td>\n				</tr>\n				<tr>\n					<td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\" width=\"50%\">\n						醫療器材</td>\n					<td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\" style=\"text-align: left;\" width=\"50%\">\n						居家護理用品</td>\n				</tr>\n			</tbody>\n		</table>\n	</div>\n	<hr />\n	<h2>\n		本藥局之特色</h2>\n	<div class=\"articles\">\n		<p>\n			1. 擁有藥師、營養師、美容師、護理師群為您的健康把關</p>\n	</div>\n	<hr />\n	<h2>\n		經營理念</h2>\n	<div class=\"articles\">\n		<p>\n			秉持『專業服務、信用至上、誠懇關懷、以客為尊』精神。</p>\n		<p>\n			藥品種類多可調劑各大醫院所釋出慢性病連續處方箋堅持『不換藥，藥品不過期』</p>\n		<p>\n			※藥品種類多可調劑各大醫院所釋出之慢性病連續處方箋，堅持『不換藥、藥品不過期』。</p>\n		<p>\n			一般處方用藥不惜成本所用都是國內知名藥廠藥品，品質有保障。</p>\n		<p>\n			※優良保存藥品環境，絕對不賣過期及劣質藥品，所有藥品經由專業藥師層層把關。</p>\n		<p>\n			※醫學美容術後、特殊敏感肌膚、由美容師指導產品使用方式，讓您輕鬆體驗醫學美容新生活。</p>\n		<p>\n			※營養健康保健品由營養師指導使用說明，讓您健康又樂活。</p>\n	</div>\n	<hr />\n	<h2>\n		公共衛生服務</h2>\n	<div class=\"articles\">\n		<p>\n			本藥局為新北市衛生局審訂之社區藥局公共衛生服務站 提供以下服務 1、四大癌症篩檢轉介 2、心情檢測站 3、長期照顧服務申請窗口 4、戒菸諮詢、轉介及後續追蹤服務 5、居家廢棄藥品檢收站。</p>\n		<p>\n			（1）愛心服務站、（2）防毒保衛站、（3）用藥安全諮詢。</p>\n	</div>\n</div>\n','2014-11-24 22:29:54','introduction','藥局介紹'),(2,'<div class=\"right\">\n	<h2>\n		交通位置</h2>\n	<hr />\n	<iframe frameborder=\"0\" height=\"426\" src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1808.1234214137835!2d121.511884!3d24.991726999999983!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x346802748fa4af3b%3A0xbace5288be84993a!2z5L-h6ZqG5aSn6Jel5bGA!5e0!3m2!1szh-TW!2stw!4v1412531769012\" style=\"border:0\" width=\"568\"></iframe>\n	<hr />\n	<p>\n		地址：新北市中和區安樂路6號</p>\n	<p>\n		營業時間：早上08：30-晚上10：30</p>\n	<hr />\n	<br />\n	<strong>交通方式：</strong>\n	<hr />\n	<p>\n		（一）大眾運輸</p>\n	<p>\n		捷運南勢角站4號出口，左轉興南路一段直走到底約160公尺處。</p>\n	<p>\n		公車（南勢角站）：207、275、793、796、933、F512、橘9 。</p>\n	<p>\n		公車（景新街站）：208、242、248、249、624、670、8、橘1、橘9。</p>\n	<p>\n		公車（經建新村站）：綠2左、綠3、綠6、綠8、241、275、793、F513、254、672、796、895、933。</p>\n	<hr />\n	<p>\n		開車資訊：北二高中和交流道下，直開約1.9km看到安樂路右轉後約40公尺左方。</p>\n</div>\n','2014-10-06 02:02:04','location','交通位置'),(3,'<div class=\"right\"> \n\n<h2>服務項目</h2>\n<hr/>\n<div class=\"articles\">\n<table width=\"100%\" border=\"1\" cellpadding=\"2\" cellspacing=\"0\" bordercolor=\"#CCCCCC\">\n        <tbody><tr>\n          <td width=\"19%\" align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">一.處方籤調劑</td>\n          <td width=\"81%\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">可以持各大醫院及診所的慢性病連續處方籤，或是其他門診處方籤調劑，減少往返醫療院所與排隊等候的時間，並且還可以節省掛號費及部分負擔費用。</td>\n        </tr>\n        <tr>\n          <td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">二.用藥諮詢</td>\n          <td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">罹患慢性病的老年人，通常同時患有數種疾病，持慢性病連續處方籤到健保特約藥局調劑，同時由藥事人員為病患製作藥歷檔，檢查數種疾病的用藥間有無交互作用，可以為病患的用藥安全做更進一步的把關。</td>\n        </tr>\n        <tr>\n          <td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">三.營養保健諮詢</td>\n          <td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">現代人觀念懂得吃營養品保健，可經由專業藥師提供您如何吃得健康，避免重複用藥，提供您完整的用藥解說，保障您及家人的用藥安全。</td>\n        </tr>\n        <tr>\n          <td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">四.醫學美容保養諮詢</td>\n          <td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">由專業的醫學美容保養品專家，駐店為您提供所有皮膚問題的解答。</td>\n        </tr>\n        <tr>\n          <td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">五.四大癌症篩檢轉介</td>\n          <td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">\n			每年有超過10,000人死於乳癌、子宮頸癌、大腸癌與口腔癌。篩檢可以早期發現癌症或其癌前病變，經治療後可以降低死亡率外，還可以阻斷癌前病變進展為癌症。目前政府補助四大癌症篩檢之政策與範圍如下: \n				<p>1. 乳房X光攝影檢查：45-69歲婦女、40-44歲二等血親內曾罹患乳癌之婦女，每2年1次。</p>\n				<p>2. 子宮頸抹片檢查：30歲以上婦女，建議每3年接受1次。</p>\n				<p>3. 糞便潛血檢查：50至未滿75歲民眾，每2年1次。</p>\n				<p>4. 口腔黏膜檢查：30歲以上有嚼檳榔（含已戒檳榔）或吸菸者、   18歲以上有嚼檳榔（含已戒檳榔）原住民，每2年1次。</p>\n			「乳房攝影檢查、子宮頸抹片檢查、糞便潛血檢查及口腔黏膜檢查經費由國民健康署菸害防制及衛生保健基金支應」\n		  </td>\n        </tr>\n        <tr>\n          <td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">六.特殊疾病營養補充</td>\n          <td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">特殊疾病的營養品補充，如何照料特殊疾病病人，提供最完整資訊。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">七.戒菸保衛站</td>\n          <td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">為幫助吸菸者戒菸，除目前提供的門診戒菸、電話戒菸專線0800-636363、社區戒菸班等服務，並發放戒菸教戰手冊，鼓勵更多民眾戒菸。99年亦訂為「戒菸行動年」，推動戒菸共同照護網，以溫馨關懷訴求，提供更多元、便利、可近的戒菸協助。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">八.醫療復健器材</td>\n          <td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">提供免費諮詢，各式輪椅、拐杖等…醫療器材。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">九.婦嬰用品</td>\n          <td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">提供各大品牌婦嬰用品的販售。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">十.生活百貨</td>\n          <td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">提供基本之日常用品販售，便利您的生活機能，生活的好鄰居。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">十一.環境衛生用品</td>\n          <td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">環境衛生用品的販售，讓我們遠離細菌病媒的孳生。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">十二.藥物回收</td>\n          <td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">許多民眾常會將未服用完的藥物直接丟棄，無形中對環境造成傷害，對醫療資源也是種浪費，信隆大藥局設有「藥品回收站」，提供民眾回收藥物的管道。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">十三.血壓量測</td>\n          <td bgcolor=\"#FFFFCC\" class=\"Gary_12px_21_\">免費得血壓測量服務，記錄血壓，藥師更提供仔細的解說。</td>\n        </tr>\n		<tr>\n          <td align=\"center\" bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">十四.愛心服務站</td>\n          <td bgcolor=\"#E6F4FF\" class=\"Gary_12px_21_\">\n			愛心服務站是由各國民中小學從校園週遭的商店中篩選出來的，各商家在接受、簽署愛心服務站約定書之後，將會接受愛心服務站商家教育訓練，而後成為校園週遭環境守護網中的一份子。\n			愛心服務站設置之目的在於推廣「社區安全，人人有責」之觀念，除由警方增加對愛心服務站商家巡邏、守望之外，更希望透過愛心服務站來關懷、協助在校園外逗留、落單之兒童，強化社區責任通報系統，希望以全民共同參與兒童保護，達成預防犯罪目標，並透過與教育單位共同合作，實現「兒童保護網絡無縫隙」之願景。\n			<a href=\"http://www.wpb.police.ntpc.gov.tw/web/Home\">http://www.wpb.police.ntpc.gov.tw/web/Home</a>\n		  </td>\n        </tr>\n      </tbody></table>\n</div>\n<hr/>\n</div>','2014-11-24 22:56:13','service','服務項目');
/*!40000 ALTER TABLE `page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `context` longtext,
  `modifyTs` datetime DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `publishTs` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'TestContext','2014-09-16 00:00:00','testTitle1','2014-09-17 00:00:00'),(3,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(4,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(5,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(8,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(9,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(10,'<p>\r\n	TestContext</p>\r\n','2014-09-21 02:14:19','測是發佈時間','2014-09-23 00:00:00'),(11,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(12,'<p>\r\n	TestContext</p>\r\n<p>\r\n	TextConn222</p>\r\n<p>\r\n	text4333232</p>\r\n','2014-09-21 01:13:12','測試CK','2014-09-17 00:00:00'),(13,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(14,'TestContext','2014-09-16 00:00:00','testTitle','2014-09-17 00:00:00'),(17,'TestContext','2014-09-16 00:00:00','testTitle16','2014-09-17 00:00:00'),(18,'TestContext','2014-09-16 00:00:00','testTitle16','2014-09-17 00:00:00'),(19,'TestContext','2014-09-16 00:00:00','testTitle16','2014-09-17 00:00:00'),(20,'TestContext','2014-09-16 00:00:00','testTitle16','2014-09-17 00:00:00'),(21,'TestContext','2014-09-16 00:00:00','testTitle16','2014-09-17 00:00:00'),(22,'TestContext','2014-09-16 00:00:00','testTitle16','2014-09-17 00:00:00'),(24,'<p>\r\n	TestCo</p>\r\n<p>\r\n	哈哈哈，測試成功</p>\r\n','2014-09-21 01:13:50','testTitle24CKEdit','2014-09-23 00:00:00'),(25,'<p>\r\n	測試建立成功</p>\r\n','2014-09-21 01:39:32','測試建立','2014-09-18 00:00:00'),(26,'<p>\r\n	還沒到的</p>\r\n','2014-09-21 01:32:47','測試建立2號','2014-09-27 00:00:00');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$XsIxscZHi385vV6.eP21ueXLvBOfH7nCYqE2N3.molKC8p15qBPB.','USER','steven'),(3,'$2a$10$FUpTOsVWpGAnFUGBAuJ4te4B/3PCgu0wyNMcjRBZA.V446/6gn2v2','USER','test');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-24 23:18:51

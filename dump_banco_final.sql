-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: contos_machado_de_assis
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classificacao`
--

DROP TABLE IF EXISTS `classificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classificacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_tipo` (`tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacao`
--

LOCK TABLES `classificacao` WRITE;
/*!40000 ALTER TABLE `classificacao` DISABLE KEYS */;
INSERT INTO `classificacao` VALUES (21,'autoria questionavel'),(23,'conto com caracteristicas de novela'),(19,'conto padrao'),(22,'experimental e dificil classificacao'),(20,'reescrito');
/*!40000 ALTER TABLE `classificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coletanea`
--

DROP TABLE IF EXISTS `coletanea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coletanea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coletanea`
--

LOCK TABLES `coletanea` WRITE;
/*!40000 ALTER TABLE `coletanea` DISABLE KEYS */;
INSERT INTO `coletanea` VALUES (84,''),(80,'Contos Avulsos'),(99,'Contos Avulsos (Nova Aguilar)'),(82,'Contos e Crônicas'),(85,'Contos Esparsos'),(86,'Contos Esquecidos'),(78,'Contos Fluminenses'),(79,'Contos Fluminenses (Vol. 2)'),(83,'Contos Recolhidos'),(87,'Contos Sem Data'),(90,'Dispersos'),(88,'Histórias da Meia-Noite'),(81,'Histórias Românticas'),(93,'Histórias sem Data'),(92,'Novas Relíquias'),(91,'Novas Relíquias/P. Recolhidas (Ver. 2)'),(95,'Outras Relíquias'),(100,'Outros Contos (Nova Aguilar)'),(94,'Páginas Recolhidas'),(76,'Páginas Recolhidas (Ver. 2)'),(89,'Papéis Avulsos'),(96,'Relíquias de Casa Velha'),(98,'Relíquias de Casa Velha (Ver. 2)'),(77,'Relíquias de Casa Velha (Vol. 2)'),(97,'Várias Histórias');
/*!40000 ALTER TABLE `coletanea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conto`
--

DROP TABLE IF EXISTS `conto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `ano_publicacao` date NOT NULL,
  `nmr_palavras` int NOT NULL,
  `idColetanea` int NOT NULL,
  `idPeriodico` int NOT NULL,
  `idClassificacao` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idClassificacao` (`idClassificacao`),
  KEY `idPeriodico` (`idPeriodico`),
  KEY `idColetanea` (`idColetanea`),
  CONSTRAINT `conto_ibfk_1` FOREIGN KEY (`idClassificacao`) REFERENCES `classificacao` (`id`),
  CONSTRAINT `conto_ibfk_2` FOREIGN KEY (`idPeriodico`) REFERENCES `periodico` (`id`),
  CONSTRAINT `conto_ibfk_3` FOREIGN KEY (`idColetanea`) REFERENCES `coletanea` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=887 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conto`
--

LOCK TABLES `conto` WRITE;
/*!40000 ALTER TABLE `conto` DISABLE KEYS */;
INSERT INTO `conto` VALUES (667,'Três Tesouros Perdidos','1858-01-01',687,76,51,19),(668,'O País das Quimeras','1862-11-01',5196,77,52,20),(669,'Frei Simão','1864-06-01',2632,78,53,19),(670,'Virginius','1864-07-01',4928,79,53,19),(671,'O Anjo das Donzelas','1864-09-01',6168,80,53,19),(672,'Casada e Viúva','1864-11-01',4817,79,53,19),(673,'Questão de Vaidade','1864-12-01',15165,81,53,19),(674,'Confissões de Uma Viúva Moça','1865-04-01',7569,78,53,19),(675,'O Teles e o Tobias','1865-08-01',8263,82,54,21),(676,'Cinco Mulheres','1865-08-01',5708,83,53,19),(677,'Linha Reta e Linha Curva','1865-10-01',14821,78,53,19),(678,'O Oráculo','1866-01-01',2110,83,53,19),(679,'Diana','1866-02-01',3785,80,53,21),(680,'As Botas','1866-02-01',335,84,54,20),(681,'O Pai','1866-02-01',9760,83,53,21),(682,'Uma Excursão Milagrosa','1866-04-01',5869,83,53,19),(683,'O Que São as Moças','1866-05-01',5731,83,53,19),(684,'Felicidade Pelo Casamento','1866-06-01',8199,85,53,21),(685,'A Pianista','1866-09-01',8630,86,53,19),(686,'Astúcias de Marido','1866-10-01',5883,83,53,19),(687,'Fernando e Fernanda','1866-11-01',5674,83,53,21),(688,'Possível e Impossível','1867-01-01',6738,80,53,21),(689,'Francisca','1867-03-01',4971,83,53,21),(690,'Onda','1867-04-01',5665,80,53,21),(691,'O Último Dia de um Poeta','1867-05-01',8618,83,53,19),(692,'História de uma Lágrima','1867-11-01',4198,87,53,21),(693,'Não É Mel Para a Boca do Asno','1868-01-01',6093,85,53,19),(694,'O Carro Nº13','1868-03-01',4738,82,53,19),(695,'A Mulher de Preto','1868-04-01',8526,78,53,19),(696,'Quinhentos Contos','1868-06-01',7505,85,53,21),(697,'O Segredo de Augusta','1868-07-01',7778,78,53,19),(698,'Luís Soares','1869-01-01',7185,78,53,19),(699,'O Anjo Rafael','1869-10-01',12773,85,53,19),(700,'A Vida Eterna','1870-01-01',4926,80,53,21),(701,'Miss Dollar','1870-02-01',7946,78,55,19),(702,'O Capitão Mendonça','1870-04-01',7944,83,53,19),(703,'O Rei dos Caiporas','1870-09-01',5107,80,53,19),(704,'Aurora Sem Dia','1870-11-01',6739,88,53,19),(705,'Mariana','1871-01-01',5735,80,53,19),(706,'Ayres e Vergueiro','1871-01-01',3276,79,53,19),(707,'Almas Agradecidas','1871-03-01',6755,81,53,19),(708,'A Felicidade','1871-03-01',4640,85,53,21),(709,'O Caminho de Damasco','1871-11-01',11560,81,53,19),(710,'Ruy de Leão','1872-01-01',9003,83,53,20),(711,'Quem Não Quer Ser Lobo...','1872-04-01',7721,81,53,19),(712,'Uma Loureira','1872-05-01',6542,86,53,19),(713,'A Parasita Azul','1872-06-01',14569,88,53,19),(714,'Canseiras Em Vão','1872-07-01',5287,85,53,21),(715,'Qual dos Dois?','1872-09-01',16104,81,53,19),(716,'Uma Águia Sem Asas','1872-09-01',4422,81,53,19),(717,'Quem Conta um Conto...','1873-02-01',4612,79,53,19),(718,'Ernesto de Tal','1873-03-01',7667,88,53,19),(719,'Tempo de Crise','1873-04-01',3792,80,53,19),(720,'O Relógio de Ouro','1873-04-01',2544,88,53,19),(721,'Decadência de Dois Grandes Homens','1873-05-01',4572,86,53,19),(722,'As Bodas de Luís Duarte','1873-06-01',5657,88,53,19),(723,'Nem Uma Nem Outra','1873-08-01',13302,79,53,19),(724,'Um Homem Superior','1873-08-01',4672,79,53,19),(725,'Ponto de Vista','1873-10-01',4407,88,53,19),(726,'A Menina Dos Olhos Pardos','1873-12-01',5638,85,53,21),(727,'Os Óculos de Pedro Antão','1874-03-01',6174,80,53,19),(728,'Um Dia de Entrudo','1874-06-01',6091,80,53,19),(729,'Muitos Anos Depois','1874-10-01',6559,86,53,19),(730,'Miloca','1874-11-01',7385,81,53,19),(731,'Valério','1874-12-01',8372,77,53,19),(732,'Quem Boa Cama Faz','1875-04-01',7363,85,53,21),(733,'Brincar Com Fogo','1875-07-01',3645,86,53,19),(734,'Antes Que Cases...','1875-07-01',7889,85,53,19),(735,'A Mágoa do Infeliz Cosme','1875-08-01',3989,77,53,19),(736,'A Última Receita','1875-09-01',1970,86,53,19),(737,'Um Esqueleto','1875-10-01',5331,86,53,19),(738,'Onze Anos Depois','1875-10-01',5448,79,53,19),(739,'A Chinela Turca','1875-11-01',3508,89,56,19),(740,'O Sainete','1875-12-01',2860,80,56,19),(741,'Casa, Não Casa','1875-12-01',4579,86,53,19),(742,'História de uma Fita Azul','1875-12-01',5367,79,53,19),(743,'To Be or Not To Be','1876-02-01',5195,79,53,19),(744,'Longe dos Olhos...','1876-03-01',4987,83,53,19),(745,'Encher Tempo','1876-04-01',11364,81,53,19),(746,'O Passado, Passado','1876-06-01',3398,86,53,19),(747,'Dona Mônica','1876-08-01',7953,86,53,19),(748,'Uma Visita de Alcibíades','1876-10-01',1256,85,53,20),(749,'O Astrólogo','1876-11-01',3335,77,53,19),(750,'Sem Olhos','1876-12-01',6376,77,53,19),(751,'Um Almoço','1877-03-01',5470,77,53,19),(752,'Silvestre','1877-06-01',7696,86,53,19),(753,'A Melhor das Noivas','1877-09-01',5891,86,53,19),(754,'Um Ambicioso','1877-11-01',6634,77,53,19),(755,'O Machete','1878-02-01',3815,86,53,19),(756,'O Bote de Rapé','1878-03-01',1434,87,57,22),(757,'A Sonâmbula','1878-03-01',1315,90,57,22),(758,'Um Cão de Lata ao Rabo','1878-04-01',2263,91,57,22),(759,'O Califa de Platina','1878-04-01',2103,76,57,22),(760,'Filosofia de um Par de Botas','1878-04-01',1984,91,57,22),(761,'A Herança','1878-04-01',2784,77,53,19),(762,'Antes da Missa','1878-05-01',1555,91,57,22),(763,'Na Arca','1878-05-01',2184,89,57,22),(764,'O Caso Ferrari','1878-05-01',2139,92,57,22),(765,'Elogio da Vaidade','1878-05-01',2189,76,57,22),(766,'Conversão de um Avaro','1878-07-01',5827,79,53,19),(767,'Folha Rota','1878-10-01',2669,77,53,19),(768,'Dívida Extinta','1878-11-01',7602,79,53,19),(769,'Curiosidade','1879-01-01',11342,87,58,21),(770,'Um Para o Outro','1879-07-01',6842,90,58,19),(771,'A Chave','1879-12-01',6641,87,58,19),(772,'O Caso da Viúva','1881-01-01',6439,87,58,19),(773,'A Mulher Pálida','1881-08-01',4709,87,58,19),(774,'O Alienista','1881-10-01',16813,89,58,23),(775,'Teoria do Medalhão','1881-12-01',2918,89,59,19),(776,'Uma Visita de Alcibíades','1882-01-01',2507,89,59,19),(777,'O Segredo do Bonzo','1882-04-01',2842,89,59,19),(778,'Dona Benedita','1882-04-01',7375,89,58,19),(779,'O Anel de Polícrates','1882-07-01',2725,89,59,19),(780,'O Empréstimo','1882-07-01',2708,89,59,19),(781,'O Imortal','1882-07-01',7487,77,58,19),(782,'A Sereníssima República','1882-08-01',2794,89,59,19),(783,'O Espelho','1882-09-01',3171,89,59,19),(784,'Verba Testamentária','1882-10-01',3411,89,59,19),(785,'Letra Vencida','1882-10-01',3689,77,58,19),(786,'O Programa','1882-12-01',7288,77,58,19),(787,'A Igreja do Diabo','1883-02-01',2663,93,59,19),(788,'Papéis Velhos','1883-03-01',2498,94,59,19),(789,'A Ideia de Ezequiel Maia','1883-03-01',2707,85,59,19),(790,'História Comum','1883-04-01',1068,77,58,19),(791,'O Lapso','1883-04-01',3079,93,59,19),(792,'O Destinado','1883-04-01',1285,77,58,19),(793,'Conto Alexandrino','1883-05-01',2962,93,59,19),(794,'Cantiga de Esponsais','1883-05-01',1439,93,58,19),(795,'Singular Ocorrência','1883-05-01',2593,93,59,19),(796,'Troca de Datas','1883-05-01',3983,77,58,19),(797,'Último Capítulo','1883-06-01',3002,93,59,19),(798,'Questões de Maridos','1883-07-01',1556,77,58,19),(799,'Três Consequências','1883-07-01',1347,77,58,19),(800,'Galeria Póstuma','1883-08-01',2859,93,59,19),(801,'Capítulo dos Chapéus','1883-08-01',4773,93,58,19),(802,'Duas Juízas','1883-09-01',1748,87,58,21),(803,'Anedota Pecuniária','1883-10-01',3140,93,59,19),(804,'Primas de Sapucaia!','1883-10-01',3106,93,59,19),(805,'Médico é Remédio','1883-10-01',2024,90,58,19),(806,'Vidros Quebrados','1883-11-01',1632,86,60,19),(807,'Uma Senhora','1883-11-01',2659,93,59,19),(808,'Cantiga Velha','1883-11-01',3157,77,58,19),(809,'Metafísica das Rosas','1883-12-01',1069,95,60,19),(810,'Fulano','1884-01-01',2254,93,59,19),(811,'A Segunda Vida','1884-01-01',2733,93,60,19),(812,'Trina e Una','1884-01-01',3646,82,58,19),(813,'Noite de Almirante','1884-02-01',2376,93,59,19),(814,'Manuscrito de um Sacristão','1884-02-01',2674,93,59,19),(815,'O Contrato','1884-02-01',1225,87,58,19),(816,'A Carteira','1884-03-01',1268,79,58,19),(817,'O Melhor Remédio','1884-03-01',1083,77,58,19),(818,'Ex Cathedra','1884-04-01',2798,93,59,19),(819,'A Viúva Sobral','1884-04-01',2837,87,58,19),(820,'A Senhora do Galvão','1884-05-01',2636,93,59,19),(821,'Entre Duas Datas','1884-05-01',3248,77,58,19),(822,'As Academias de Sião','1884-06-01',2587,93,59,19),(823,'Evolução','1884-06-01',1979,96,59,19),(824,'O Enfermeiro','1884-07-01',3075,97,59,19),(825,'Vinte Anos! Vinte Anos!','1884-07-01',1515,77,58,19),(826,'Conto de Escola','1884-09-01',2866,97,59,19),(827,'O Incorrigível','1884-09-01',1135,87,58,21),(828,'O Caso do Romualdo','1884-09-01',5959,98,58,19),(829,'Dona Paula','1884-10-01',3152,97,59,19),(830,'O Diplomático','1884-10-01',3381,97,59,19),(831,'A Cartomante','1884-11-01',3111,97,59,19),(832,'Uma Carta','1884-12-01',1742,79,58,19),(833,'Só!','1885-01-01',2847,95,59,19),(834,'Um Bilhete','1885-02-01',458,87,58,21),(835,'Adão e Eva','1885-03-01',1866,97,59,19),(836,'Um Apólogo','1885-03-01',672,97,59,19),(837,'O Dicionário','1885-03-01',1074,94,59,19),(838,'A Causa Secreta','1885-08-01',3340,97,59,19),(839,'Habilidoso','1885-09-01',2209,85,59,19),(840,'Viagem À Roda de Mim Mesmo','1885-10-01',3334,95,59,19),(841,'Uns Braços','1885-11-01',3264,97,59,19),(842,'O Cônego Ou Metafísica do Estilo','1885-11-01',1832,97,59,19),(843,'Entre Santos','1886-01-01',2930,97,59,19),(844,'Trio em Lá Menor','1886-01-01',2504,97,59,19),(845,'Viver!','1886-02-01',2470,97,59,19),(846,'Terpsícore','1886-03-01',2978,99,59,19),(847,'Curta História','1886-05-01',976,79,58,19),(848,'Um Dístico','1886-06-01',913,87,61,19),(849,'Pobre Cardeal!','1886-07-01',2785,98,59,19),(850,'A Desejada das Gentes','1886-07-01',3089,97,59,19),(851,'Antes a Rocha Tarpéia','1887-01-01',1231,85,62,19),(852,'Identidade','1887-03-01',3593,95,59,19),(853,'Sales','1887-05-01',2665,87,59,19),(854,'Eterno!','1887-09-01',3628,94,59,19),(855,'Um Homem Célebre','1888-06-01',3329,97,59,19),(856,'Dona Jucunda','1889-01-01',3647,80,59,19),(857,'Como Se Inventaram os Almanaques','1890-01-01',1433,80,63,19),(858,'O Caso da Vara','1891-02-01',2440,94,59,19),(859,'Mariana','1891-10-01',2991,97,59,19),(860,'Pobre Finoca!','1891-12-01',3981,79,58,19),(861,'O Caso Barreto','1892-03-01',3702,98,58,19),(862,'Um Sonho e Outro Sonho','1892-05-01',4361,98,58,19),(863,'Uma Partida','1892-10-01',5159,90,58,19),(864,'Vênus! Divina Vênus!','1893-01-01',3434,86,62,19),(865,'Um Quarto de Século','1893-08-01',5196,98,58,19),(866,'João Fernandes','1894-01-01',1518,87,58,19),(867,'Missa do Galo','1894-05-01',2501,94,64,19),(868,'A Inglesinha Barcelos','1894-05-01',4114,80,58,19),(869,'Um Erradio','1894-09-01',6406,94,58,19),(870,'Orai Por Ele!','1895-01-01',858,85,62,19),(871,'Ideias de Canário','1895-11-01',1669,94,59,19),(872,'Uma Noite','1895-12-01',4695,76,65,19),(873,'Flor Anônima','1897-01-01',1679,100,62,19),(874,'Uma Por Outra','1897-09-01',8277,80,58,19),(875,'Maria Cora','1898-01-01',6553,96,58,19),(876,'Lágrimas de Xerxes','1899-06-01',2130,94,55,19),(877,'Pílades e Orestes','1903-01-01',3309,96,66,19),(878,'Jogo do Bicho','1904-01-01',3036,95,66,19),(879,'Anedota do Cabriolet','1905-01-01',2506,96,66,19),(880,'Um Incêndio','1906-01-01',1509,77,66,19),(881,'Pai Contra Mãe','1906-01-01',3891,96,55,19),(882,'Marcha Fúnebre','1906-01-01',2567,96,55,19),(883,'Um Capitão de Voluntários','1906-01-01',4452,96,55,19),(884,'Suje-se Gordo!','1906-01-01',1632,96,55,19),(885,'Umas Férias','1906-01-01',2583,96,55,19),(886,'O Escrivão Coimbra','1907-01-01',3832,95,66,19);
/*!40000 ALTER TABLE `conto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodico`
--

DROP TABLE IF EXISTS `periodico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodico`
--

LOCK TABLES `periodico` WRITE;
/*!40000 ALTER TABLE `periodico` DISABLE KEYS */;
INSERT INTO `periodico` VALUES (56,'A Época'),(58,'A Estação'),(51,'A Marmota'),(61,'A Quinzena'),(64,'A Semana'),(66,'Almanaque Brasileiro Garnier'),(62,'Almanaque da Gazeta de Notícias'),(63,'Almanaque das Fluminenses'),(55,'Coletânea'),(59,'Gazeta de Notícias'),(60,'Gazeta Literária'),(53,'Jornal das Famílias'),(57,'O Cruzeiro'),(52,'O Futuro'),(65,'Revista Brasileira'),(54,'Semana Ilustrada');
/*!40000 ALTER TABLE `periodico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-16  5:26:26

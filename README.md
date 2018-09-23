# BootStart

Spring Boot starter application. Only providing RESTful APIs.

Domain:
  - Book
  - Category

Database Tables:
 - Book ==>
        DROP TABLE IF EXISTS `book`;
        CREATE TABLE IF NOT EXISTS `book` (
          `bookId` int(11) NOT NULL AUTO_INCREMENT,
          `bookTitle` varchar(100) NOT NULL,
          `categoryId` int(11) NOT NULL,
          PRIMARY KEY (`bookId`)
        ) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
        
 - Category ==>
        DROP TABLE IF EXISTS `category`;
        CREATE TABLE IF NOT EXISTS `category` (
          `categoryId` int(11) NOT NULL AUTO_INCREMENT,
          `categoryName` varchar(50) NOT NULL,
          PRIMARY KEY (`categoryId`)
        ) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

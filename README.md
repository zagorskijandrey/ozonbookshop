# ozonbookshop
# Presentation Spring MVC application

I worked out a web application with a help web of framework Spring MVC on the basis of annotations. Controllers are constructed processing a web queries. Aimed to design a web layer of application in accordance with architecture RESTful .Tags was used in JSP with style of CSS in the presentations sent to the users in reply to queries.

Framework Apache Tiles used together with framework Spring MVC, to provide the frontpad of application of Offers.

For storage and relation maping of objects was used the database of MySQL and framework of Hibernate.

The aim of work was development web of application for loading and visualization of catalogue of books on the set URL address, presented in XML format.


# Create Schema in database 'ozonbookshop'

CREATE TABLE offer(

    bookId INT(13) NOT NULL auto_increment, 
    name VARCHAR(200) DEFAULT NULL,
    author VARCHAR(200) DEFAULT NULL,
    year INT(11) DEFAULT NULL,
    ISBN VARCHAR(100) DEFAULT NULL,
    description VARCHAR(2000) DEFAULT NULL,
    picture VARCHAR(200) DEFAULT NULL,
    PRIMARY KEY (bookId)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

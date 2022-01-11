# Introduction
This is a customer-order-processing system programmed in Java. It is connected to a PostgreSQL (PSQL) database that runs inside a Docker container. Java Database Connectivity (JDBC) is used to connect the application with the database. JDBC is also used to allow the user to run queries and perform all 4 CRUD (create, read, update, and delete) operations on the database. The database contains basic sales information, which includes customers, orders, salespeople, and products. 

Technology used:
- Java 8
- JDBC
- PSQL to create, populate, and query the database
- Maven to compile and build the project and manage its build dependencies
- Docker container for deploying the database
- DBeaver for database testing, verification, and the entity-relationship (ER) diagram

# Implementaiton
## ER Diagram
![ERD](./assets/JDBC-ERD.png)

## Design Patterns
Two common patterns that are used when dealing with databases and implementing Data Access Layer (DAL) are the Data Access Object (DAO) pattern and the repository pattern. Both patterns achieve the same goal of abstracting the implementation details of data access, but they each do so in different ways. This project uses the DAO pattern.

1. DAOs provide an abstraction layer between the raw JDBC code and the rest of the code, specifically, the business logic. DAOs can come in two forms: they can be an abstraction or a true object. If used as a pure abstraction layer, a Data Transfer Object (DTO) will also be used. The DTO provides a single domain of data and should fully encapsulate objects that may also contain subobjects. The DAO itself often leverages a common interface, and a concrete implementation reacts on a single data domain.
 
2. The repository pattern focuses only on single-table access per class. Instead of doing joining in the database, in the repository pattern, you join in the code. Complex joins in the database require single-instance databases. The repository pattern can shard the database to allow for focus on single-table access, instead of having to access the entire database as a whole.

To decide which pattern to use, the constraints of the application should be considered: if the application is database-constrained, joins are not done in the database. So, if there is a lot of load on the web framework, but the database becomes the bottleneck, the repository pattern is preferable. If atomic transactions are needed, the DAO pattern is preferable, since it is very difficult with most modern frameworks to perform atomic operations without bringing in extra transaction managers to handle cross-table design.

# Test
In order to test the database, tables were created and filled them with mock data using SQL scripts. Queries were run against the database in order to verify whether or not the SQL scripts were successful. CRUD and join operations were tested by creating, updating, and deleting data and then verifying the results in the database; read operations were tested by comparing query results on the database with the results on the JDBC application.

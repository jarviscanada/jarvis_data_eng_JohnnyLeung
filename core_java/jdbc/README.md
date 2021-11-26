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
ER diagram


## Design Patterns
Two common patterns that are used when dealing with databases and implementing Data Access Layer (DAL) are the Data Access Object (DAO) pattern and the Repository pattern. Both patterns achieve the same goal of abstracting the implementation details of data access, but they each do so in different ways. This application uses the DAO pattern.

# Test
How you test your app against the database? (e.g. database setup, test data set up, query result)

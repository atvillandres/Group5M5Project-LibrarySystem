# Group 5 Library System  
## How to create database, table and insert dummy data.
```sql
psql.exe -U postgres -f create-database.sql
psql.exe -U postgres -d group5 -f create-table.sql
psql.exe -U postgres -d group5 -f insert-data.sql
```  
The command above will create the following tables.
- users
- book
- loan

Things to do:
- [x] Create SQL script for creation of database, table and insert data.
- [x] Create pom.xml.
- [ ] Create connection to database.
- [ ] Initialize Books.

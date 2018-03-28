## Spring Boot application to include various features

* Spring Boot : @ConfigurationProperties
* Spring Boot : Json to Object (Jackson mapping)
* JPA : 1-1 and 1-Many
* JPA : Stored Procedure and CustomQuery

### CustomQuery

It supports various custom SQL/JPQL queries to accomplish specialized application tasks. There are three ways of implementing the custom queries.
		
	
* [Method names](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-from-method-names/)
* [Named queries](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-with-named-queries/)
* [Using @Query annotation](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-with-the-query-annotation/)
	
	
### Stored Procedures

Stored Procedures allow to reuse the queries over multiple times just by passing the required parameters. spring-data-JPA provides flexible way to access the stored procedures by just annotating the entity class with @NamedStoredProcedureQuery.

#### References

* [Introduction and Creation of Stored Procedures-1](https://www.mssqltips.com/sqlservertutorial/160/sql-server-stored-procedure-tutorial/)
* [Introduction and Creation of Stored Procedures-2 (Specific to MYSQL)](http://www.mysqltutorial.org/getting-started-with-mysql-stored-procedures.aspx)
* [Spring Docs on Stored Procedure](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.stored-procedures) 
* [Sample Article](https://dzone.com/articles/calling-stored-procedures-from-spring-data-jpa)
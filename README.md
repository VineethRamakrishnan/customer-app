## Spring Boot application to include various features

* Spring Boot : @ConfigurationProperties
* Spring Boot : Json to Object (Jackson mapping)
* JPA : 1-1 and 1-Many
* JPA : Stored Procedure and CustomQuery
* Mongo DB : MongoRepository and MongoClient
* Kafka : Messaging based on the Partition in the request parameter

### Jackson

This java based library is mainly used for serialization(Java Object to JSON) and deserialization(JSON to Java Object) purposes.

* [Basic Doc](https://www.tutorialspoint.com/jackson/jackson_first_application.htm)
* [Multiple examples](http://tutorials.jenkov.com/java-json/jackson-objectmapper.html#read-object-from-json-reader)
* [Custom serialization/deserialization](https://www.rainerhahnekamp.com/en/spring-mvc-json-serialization/)

##### HttpMessageConverters

Bean used to manage the HttpMessageConverters used in a Spring Boot application. Provides a convenient way to add and merge additional HttpMessageConverters to a web application.

1.Based on the **Content-Type** header it will call the corresponding MessageConvertor (For @RequestBody)

2.Based on the **Accept** header it will call the the corresponding MessageConveror (For @ResponseBody) 

* [With Spring Framework](http://www.baeldung.com/spring-httpmessageconverter-rest)


### CustomQuery

It supports various custom SQL/JPQL queries to accomplish specialized application tasks. There are three ways of implementing the custom queries.
		
	
* [Method names](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-from-method-names/)
* [Named queries](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-with-named-queries/)
* [Using @Query annotation](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-with-the-query-annotation/)
	
	
### Stored Procedures

Stored Procedures allow to reuse the queries over multiple times just by passing the required parameters. spring-data-JPA provides flexible way to access the stored procedures by just annotating the entity class with @NamedStoredProcedureQuery.


* [Introduction and Creation of Stored Procedures-1](https://www.mssqltips.com/sqlservertutorial/160/sql-server-stored-procedure-tutorial/)
* [Introduction and Creation of Stored Procedures-2 (Specific to MYSQL)](http://www.mysqltutorial.org/getting-started-with-mysql-stored-procedures.aspx)
* [Spring Docs on Stored Procedure](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.stored-procedures) 
* [Sample Article](https://dzone.com/articles/calling-stored-procedures-from-spring-data-jpa)


### Mongo DB

Mongo DB is one type of the database technology which works based on the documents. Some of the basic terminologies in Mongo DB which has similar context in MySQL

| Mongo DB | MySQL |
| --- | --- |
| Database | Database |
| Collection | Table |
| Document | Row |
| Field | Column |
| Primary Key | Primary Key |
| Joining | Linking & Embedding |
  
* [Example using MongoClient](https://howtodoinjava.com/mongodb/mongodb-selectqueryfind-documents-examples/)
* [Journaldev Example](https://www.journaldev.com/3963/mongodb-java-crud-example-tutorial)


### Kafka

One of the distributed messaging platform to send/receive messages through topics.

Get familiar with kafka jargon using [this video](https://www.youtube.com/watch?v=-ioxYn9Vlao). Basic documentation for starting zookeeper server, kafka server and creating topic see [kafka docs](https://kafka.apache.org/quickstart). UI for kafka components [kafdrop](https://github.com/HomeAdvisor/Kafdrop).

In this example kafka with multiple partitions is implemented. User have to specify the particular partition as part of the request parameter to send/receive messages.  

  
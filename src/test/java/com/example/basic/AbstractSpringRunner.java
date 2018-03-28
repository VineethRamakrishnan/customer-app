package com.example.basic;

import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=CustomerApplication.class , properties="spring.cloud.config.enabled=false")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public abstract class AbstractSpringRunner {


}